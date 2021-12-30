package com.tally.api.tallyuserrole;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserrole.model.TallyUserRole;
import com.tally.service.tallyuserrole.TallyUserRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户角色关系表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyUserRole")
//@Api(tags = "用户角色关系表接口")
public class TallyUserRoleController extends BaseController {

    @Autowired
    private TallyUserRoleService tallyUserRoleService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyUserRole tallyUserRole) {
        return ApiResponse.success(tallyUserRoleService.create(tallyUserRole));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyUserRoleService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyUserRole tallyUserRole) {
        tallyUserRoleService.updateById(tallyUserRole);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyUserRole> pageWrap) {
        return ApiResponse.success(tallyUserRoleService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyUserRoleService.findById(id));
    }
}