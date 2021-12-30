package com.tally.api.tallyuserpergrant;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.dao.tallyuserpergrant.model.TallyUserPerGrant;
import com.tally.dao.tallyuserpermission.model.TallyUserPermission;
import com.tally.service.tallyuser.TallyUserService;
import com.tally.service.tallyuserpergrant.TallyUserPerGrantService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户权限授权表接口
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
@RestController
@RequestMapping("/api/tallyUserPerGrant")
public class TallyUserPerGrantController extends BaseController {

    @Autowired
    private TallyUserPerGrantService tallyUserPerGrantService;
    @Autowired
    private TallyUserService tallyUserService;


    /**
     * 分页查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    @PostMapping("/page")
    public ApiResponse findPage (Integer page,Integer permissionId ,HttpServletRequest request) {
        PageWrap  pageWrap = new PageWrap();
        TallyUserPerGrant grant = new TallyUserPerGrant();
        String userId = getUserId(request);
        grant.setUseId(Integer.valueOf(userId));
        grant.setStatus(101);
        grant.setPermissonId(permissionId);
        pageWrap.setModel(grant);
        pageWrap.setPage(page);
        return ApiResponse.success(tallyUserPerGrantService.findPage(pageWrap));
    }

    @PostMapping("/grant")
    public ApiResponse grant (String grantUserMobile, Integer permissionId,HttpServletRequest request) {
         String userId = getUserId(request);
        try {
            TallyUserPerGrant temp= new TallyUserPerGrant();
            temp.setUseId(Integer.valueOf(userId));
            temp.setPermissonId(permissionId);
            temp.setGrantUserMobile(grantUserMobile);
            temp.setStatus(101);
            TallyUserPerGrant one = tallyUserPerGrantService.findOne(temp);
            if(one!=null){
                return ApiResponse.failed("请勿重复授权！");
            }
            TallyUserPerGrant grant = new TallyUserPerGrant();
            grant.setPermissonId(permissionId);
            grant.setGrantUserMobile(grantUserMobile);
            grant.setUseId(Integer.valueOf(userId));
            grant.setStatus(101);
            TallyUser tallyUser = new TallyUser();
            tallyUser.setMobile(grantUserMobile);
            TallyUser user = tallyUserService.findOne(tallyUser);
            if(null!=user){
                grant.setGrantUserId(user.getId());
                if(userId.equals(user.getId().toString())){
                    return ApiResponse.failed("请勿给自己授权！");
                }
            }
            return ApiResponse.success(tallyUserPerGrantService.create(grant));
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.failed("处理失败！");
        }
    }
    @PostMapping("/grantCancel")
    public ApiResponse grantCancel (Integer id,HttpServletRequest request) {
        String userId = getUserId(request);
        try {
            TallyUserPerGrant grant = new TallyUserPerGrant();
            grant.setId(id);
            grant.setUseId(Integer.valueOf(userId));
            grant.setStatus(102);
            tallyUserPerGrantService.updateById(grant);
            return ApiResponse.success("处理成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.failed("处理失败！");
        }
    }
//    /**
//     * 创建
//     * @author 我是传奇
//     * @date 2021/07/21 10:16
//     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyUserPerGrant tallyUserPerGrant) {
//        return ApiResponse.success(tallyUserPerGrantService.create(tallyUserPerGrant));
//    }
//
//    /**
//     * 用户删除
//     * @author 我是传奇
//     * @date 2021/07/21 10:16
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Long id) {
//        tallyUserPerGrantService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 我是传奇
//     * @date 2021/07/21 10:16
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyUserPerGrant tallyUserPerGrant) {
//        tallyUserPerGrantService.updateById(tallyUserPerGrant);
//        return ApiResponse.success(null);
//    }
//
//
//
//    /**
//     * 通过ID查询
//     * @author 我是传奇
//     * @date 2021/07/21 10:16
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Long id) {
//        return ApiResponse.success(tallyUserPerGrantService.findById(id));
//    }
}
