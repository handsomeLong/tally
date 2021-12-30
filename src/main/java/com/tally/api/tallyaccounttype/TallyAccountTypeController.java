package com.tally.api.tallyaccounttype;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import com.tally.service.tallyaccounttype.TallyAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 账户类型表接口
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@RestController
@RequestMapping("/tallyAccountType")
public class TallyAccountTypeController extends BaseController {

    @Autowired
    private TallyAccountTypeService tallyAccountTypeService;

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyAccountType tallyAccountType) {
        return ApiResponse.success(tallyAccountTypeService.create(tallyAccountType));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyAccountTypeService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyAccountType tallyAccountType) {
        tallyAccountTypeService.updateById(tallyAccountType);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyAccountType> pageWrap) {
        return ApiResponse.success(tallyAccountTypeService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyAccountTypeService.findById(id));
    }
}