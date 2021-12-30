package com.tally.api.tallyuserpermission;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserpermission.model.TallyUserPermission;
import com.tally.service.tallyuserpermission.TallyUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户权限表接口
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
@RestController
@RequestMapping("/api/tallyUserPermission")
public class TallyUserPermissionController extends BaseController {

    @Autowired
    private TallyUserPermissionService tallyUserPermissionService;

    /**
     * 分页查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    @PostMapping("/page")
    public ApiResponse findPage (Integer page) {
        PageWrap  pageWrap = new PageWrap();
        TallyUserPermission permission = new TallyUserPermission();
        permission.setStatus(100);
        pageWrap.setModel(permission);
        pageWrap.setPage(page);
        return ApiResponse.success(tallyUserPermissionService.findPage(pageWrap));
    }

//    /**
//     * 创建
//     * @author 我是传奇
//     * @date 2021/07/21 10:16
//     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyUserPermission tallyUserPermission) {
//        return ApiResponse.success(tallyUserPermissionService.create(tallyUserPermission));
//    }
//
//    /**
//     * 用户删除
//     * @author 我是传奇
//     * @date 2021/07/21 10:16
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Long id) {
//        tallyUserPermissionService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 我是传奇
//     * @date 2021/07/21 10:16
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyUserPermission tallyUserPermission) {
//        tallyUserPermissionService.updateById(tallyUserPermission);
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
//        return ApiResponse.success(tallyUserPermissionService.findById(id));
//    }
}
