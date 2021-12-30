package com.tally.api.tallyrolemenu;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyrolemenu.model.TallyRoleMenu;
import com.tally.service.tallyrolemenu.TallyRoleMenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色菜单关系表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyRoleMenu")
//@Api(tags = "角色菜单关系表接口")
public class TallyRoleMenuController extends BaseController {

    @Autowired
    private TallyRoleMenuService tallyRoleMenuService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyRoleMenu tallyRoleMenu) {
        return ApiResponse.success(tallyRoleMenuService.create(tallyRoleMenu));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyRoleMenuService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyRoleMenu tallyRoleMenu) {
        tallyRoleMenuService.updateById(tallyRoleMenu);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyRoleMenu> pageWrap) {
        return ApiResponse.success(tallyRoleMenuService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyRoleMenuService.findById(id));
    }
}