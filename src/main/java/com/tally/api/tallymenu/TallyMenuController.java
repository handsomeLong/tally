package com.tally.api.tallymenu;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallymenu.model.TallyMenu;
import com.tally.service.tallymenu.TallyMenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户菜单接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyMenu")
//@Api(tags = "用户菜单接口")
public class TallyMenuController extends BaseController {

    @Autowired
    private TallyMenuService tallyMenuService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyMenu tallyMenu) {
        return ApiResponse.success(tallyMenuService.create(tallyMenu));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyMenuService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyMenu tallyMenu) {
        tallyMenuService.updateById(tallyMenu);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyMenu> pageWrap) {
        return ApiResponse.success(tallyMenuService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyMenuService.findById(id));
    }
}