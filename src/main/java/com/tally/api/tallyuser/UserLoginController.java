package com.tally.api.tallyuser;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tally.api.BaseController;
import com.tally.api.inputDto.WxAuthLoginInputDto;
import com.tally.config.WeiXinConfig;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.HttpConnectionUtil;
import com.tally.core.utils.HttpUtils;
import com.tally.core.utils.RsaUtils;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.dao.tallywxalipayaccount.model.TallyWxAlipayAccount;
import com.tally.oauth.model.UserDetail;
import com.tally.oauth.tool.JwtUtils;
import com.tally.service.tallyuser.TallyUserService;
import com.tally.service.tallywxalipayaccount.TallyWxAlipayAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/tallyUser")
@Api(tags = "登录接口")
public class UserLoginController extends BaseController {

    @Autowired
    private TallyUserService tallyUserService;
    @Autowired
    private TallyWxAlipayAccountService tallyWxAlipayAccountService;
    @Autowired
    private WeiXinConfig weiXinConfig;

    private final JwtUtils jwtTokenUtil;

    private final AuthenticationManager authenticationManager;

    public UserLoginController(JwtUtils jwtTokenUtil, AuthenticationManager authenticationManager) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }


    /**
     * 微信小程序手机号授权登陆
     * @param wxAuthLoginInputDto
     * @return
     */
    @PostMapping("/wxMini_auth_login")
    @ApiOperation("微信授权登陆")
    public ApiResponse wxMini_auth_login(@RequestBody WxAuthLoginInputDto wxAuthLoginInputDto){
        ApiResponse response = ApiResponse.failed("登陆失败！");
        try {
            JSONObject jsonObject = RsaUtils.parseWxMiniPhone(wxAuthLoginInputDto.getSession_key(), wxAuthLoginInputDto.getEncryptedData(), wxAuthLoginInputDto.getIv());
            String mobile = jsonObject.getString("phoneNumber");
            String client_id = wxAuthLoginInputDto.getOpenid();
            //判断是否注册过
            TallyUser tallyUser = new TallyUser();
            tallyUser.setMobile(mobile);
            TallyUser one = tallyUserService.findOne(tallyUser);
            boolean hasRegister = false;
            UserDetail detail = null;
            if(null!=one){
                hasRegister=true;
                //这里如果解析成功，到这个位置说明登陆成功了
                 detail = auth(mobile, "123456");
                //更新token
                TallyUser tu = new TallyUser();
                tu.setId(one.getId());
                tu.setDeviceToken(detail.getToken());
                tallyUserService.updateById(tu);
            }else{
                //注册新用户
                one = tallyUserService.saveWxAuthRegisterUser(wxAuthLoginInputDto,mobile);
                detail = auth(mobile, "123456");
                //更新token
                TallyUser tu = new TallyUser();
                tu.setId(one.getId());
                tu.setDeviceToken(detail.getToken());
                tallyUserService.updateById(tu);
            }
            if(hasRegister){
                //更新第三方账号
                List<TallyWxAlipayAccount> list = new ArrayList<>();
                TallyWxAlipayAccount  tallyWxAlipayAccount = new TallyWxAlipayAccount();
                tallyWxAlipayAccount.setId(one.getId());
                tallyWxAlipayAccount.setAccountNo(client_id);
                list.add(tallyWxAlipayAccount);
                tallyWxAlipayAccountService.updateByIdInBatch(list);
            }else{
                //创建新的第三方账号
                TallyWxAlipayAccount tallyWxAlipayAccount = new TallyWxAlipayAccount();
                tallyWxAlipayAccount.setAccountNo(client_id);
                tallyWxAlipayAccount.setAccType("wxpay");
                tallyWxAlipayAccount.setUserId(one.getId());
                tallyWxAlipayAccountService.create(tallyWxAlipayAccount);
            }
            /**
             * 保存邀请关系
             */
//            usersService.saveInviteRalation(hasRegister,mobile,inviteUserId);
            /**
             * 派送奖励
             */
//            usersService.saveRegisterUserCoupon(hasRegister,mobile,inviteUserId);

             response.setSuccess(true);
             response.setMessage("登陆成功");
             Map  map= Maps.newHashMap();
             map.put("access_token",detail.getToken());
             map.put("user_id",one.getId());
             response.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setMessage("登陆异常");
        }
        return  response;
    }

    private UserDetail auth(String userName, String password) throws Exception {
        final Authentication authentication = authenticate(userName, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        final UserDetail userDetail = (UserDetail) authentication.getPrincipal();

        final String token = jwtTokenUtil.generateAccessToken(userDetail);
        final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetail);
        return UserDetail.builder()
                .id(userDetail.getId())
                .username(userDetail.getUsername())
                .nickname(userDetail.getNickname())
                .token(token)
                .refreshToken(refreshToken)
                .build();
    }
    private Authentication authenticate(String username, String password) throws Exception {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("用户名或密码无效");
        }
    }

    /**
     * 微信小程序 session
     * @param code
     * @return
     */
    @GetMapping("/getWxMiniCode2Seesion")
    @ApiOperation("微信小程序授权")
    public ApiResponse getWxMiniCode2Seesion(@Param("code") String code){
        ApiResponse response = ApiResponse.failed("获取失败！");
        try {
            JSONObject wxpay =(JSONObject)JSONObject.toJSON(weiXinConfig);
            JSONObject jsonObject = this.getWxOpenId(wxpay, code);
            Map map = new HashMap();
            map.put("openid",jsonObject.get("openid"));
            map.put("session_key",jsonObject.get("session_key"));
            response.setData(map);
            response.setSuccess(true);
            response.setMessage("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.setMessage("获取失败");
        }
        return response;
    }
    /**
     * 获取小程序 openId
     * @param wxpay
     * @param code
     * @return
     * @throws Exception
     */
    private JSONObject getWxOpenId(JSONObject wxpay, String code) throws Exception {
        String wxspAppid = (String)wxpay.get("mini_app_id");
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret =(String)wxpay.get("mini_secret");
        String grantType = "authorization_code";

        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grantType;
        //发送请求
        String response = HttpUtils.httpsGet(wxpay.getString("get_openid_url") + "?" + params);
//        String response=HttpConnectionUtil.getHttp(wxpay.getString("get_openid_url")+"?"+params);
        JSONObject jsonObject = JSONObject.parseObject(response);
        return jsonObject;
    }
}