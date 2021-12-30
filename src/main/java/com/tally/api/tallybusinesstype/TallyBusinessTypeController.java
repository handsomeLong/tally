package com.tally.api.tallybusinesstype;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.service.tallybusinesstype.TallyBusinessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 业务类型表接口
 * @author 131****2893
 * @date 2021/03/27 19:02
 */
@RestController
@RequestMapping("/tallyBusinessType")
public class TallyBusinessTypeController extends BaseController {

    @Autowired
    private TallyBusinessTypeService tallyBusinessTypeService;

    /**
     * 创建
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyBusinessType tallyBusinessType) {
        return ApiResponse.success(tallyBusinessTypeService.create(tallyBusinessType));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyBusinessTypeService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyBusinessType tallyBusinessType) {
        tallyBusinessTypeService.updateById(tallyBusinessType);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyBusinessType> pageWrap) {
        return ApiResponse.success(tallyBusinessTypeService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyBusinessTypeService.findById(id));
    }
}