package com.tally.api.tallyuser;

import com.alibaba.fastjson.JSONObject;
import com.tally.api.BaseController;
import com.tally.api.inputDto.ApplyFriendsInputDto;
import com.tally.api.inputDto.MiniQrCodeInputDto;
import com.tally.config.FileConfig;
import com.tally.config.WeiXinConfig;
import com.tally.core.model.ApiResponse;
import com.tally.core.utils.AccessToken;
import com.tally.core.utils.HttpUtils;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.service.tallyuser.TallyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * 用户表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyUser")
@Api(tags = "用户设置接口")
public class TallyUserController extends BaseController {

    @Autowired
    private TallyUserService tallyUserService;

    @Autowired
    private WeiXinConfig weiXinConfig;
    @Autowired
    private FileConfig fileConfig;

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息")
    public ApiResponse getUserInfo (HttpServletRequest request,@Param("user_id") String user_id) {
        if(null==user_id){
            user_id = getUserId(request);
        }
        TallyUser tallyUser = tallyUserService.findById(Integer.valueOf(user_id));
        return ApiResponse.success(tallyUser);
    }
    @PostMapping("/addFriendsUser")
    @ApiOperation("添加用户并关联好友关系")
    public ApiResponse addFriendsUser(String name,String mobile,HttpServletRequest request) {
        String userId = getUserId(request);
        TallyUser tallyUser = null;
        try {
            TallyUser tu = new TallyUser();
            tu.setMobile(mobile);
            tallyUser= tallyUserService.findOne(tu);
            if(null==tallyUser){//用户不存在,添加用户
                tallyUser = tallyUserService.saveUser(name, mobile);
            }
            if(StringUtils.isBlank(tallyUser.getName())){
                tallyUser.setName(name);
            }
            ApplyFriendsInputDto applyFriendsInputDto = new ApplyFriendsInputDto();
            applyFriendsInputDto.setUserId(tallyUser.getId());
            applyFriendsInputDto.setFriendsUserName(name);
            applyFriendsInputDto.setApplyUserId(Integer.valueOf(userId));
            tallyUserService.addFriendsDirect(applyFriendsInputDto);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return ApiResponse.success(tallyUser);
    }
    /**
     * 设置用户信息
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateTallyUser")
    @ApiOperation("设置用户信息")
    public ApiResponse updateTallyUser(@RequestBody TallyUser tallyUser,HttpServletRequest request) {
        String userId = getUserId(request);
        tallyUser.setId(Integer.valueOf(userId));
        tallyUserService.updateById(tallyUser);
        return ApiResponse.success(null);
    }
    /**
     * 生成个性名片
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/getBusinessCardQR")
    @ApiOperation("生成个性名片")
    public ApiResponse getBusinessCardQR(@RequestBody TallyUser tallyUser,HttpServletRequest request) {
        String userId = getUserId(request);
        tallyUser.setId(Integer.valueOf(userId));
        tallyUserService.updateById(tallyUser);
        return ApiResponse.success(null);
    }
    /**
     * 添加好友请求
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/addFriendsRequest")
    @ApiOperation("添加好友请求")
    public ApiResponse addFriendsRequest(@RequestBody ApplyFriendsInputDto applyFriendsInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        return tallyUserService.addFriendsRequest(applyFriendsInputDto,userId);
    }

    @PostMapping("/addFriendsDirect")
    @ApiOperation("直接添加为好友")
    public ApiResponse addFriendsDirect(@RequestBody ApplyFriendsInputDto applyFriendsInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        applyFriendsInputDto.setApplyUserId(Integer.valueOf(userId));
        return tallyUserService.addFriendsDirect(applyFriendsInputDto);
    }

    @PostMapping("/getMiniQrCode")
    @ApiOperation("获取小程序码")
    public ApiResponse getMiniQrCode(HttpServletRequest request, MiniQrCodeInputDto vo,String activityId){
        String user_id = getUserId(request);
        vo.setScene(user_id);
        ApiResponse apiResponse = ApiResponse.failed("获取失败！");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //设置token
            File ticket_file=new File(request.getServletContext().getRealPath("/WEB-INF/classes/conf"),"MAccessToken.txt");
            String wxmini = AccessToken.getWxmini(ticket_file);
            //发送请求
            JSONObject params = (JSONObject) JSONObject.toJSON(vo);
            byte[] bytes = HttpUtils.httpsPostBackBytes(weiXinConfig.getWxacodeunlimit_url() + "?access_token=" + wxmini, params.toJSONString());
            inputStream = new ByteArrayInputStream(bytes);
            //生成图片
            String miniQrCode_path=fileConfig.getFilepath()+fileConfig.getUpload_miniqrcode_path();
            String suffix="/"+user_id+"/"+user_id+"_"+activityId+".png";
            File dir = new File(miniQrCode_path+"/"+user_id);
            if(!dir.exists()){
                dir.mkdirs();
            }
            File file = new File(miniQrCode_path+suffix);
            if (!file.exists()){
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
            apiResponse.setData(fileConfig.getUpload_miniqrcode_path()+suffix);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("获取成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return apiResponse;
    }


//
//    /**
//     * 分页查询
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @PostMapping("/page")
//    public ApiResponse findPage (@RequestBody PageWrap<TallyUser> pageWrap) {
//        return ApiResponse.success(tallyUserService.findPage(pageWrap));
//    }
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyUserService.findById(id));
//    }
}