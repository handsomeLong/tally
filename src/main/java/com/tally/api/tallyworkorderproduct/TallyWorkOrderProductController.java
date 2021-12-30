package com.tally.api.tallyworkorderproduct;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyworkorderproduct.model.TallyWorkOrderProduct;
import com.tally.service.tallyworkorderproduct.TallyWorkOrderProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 生产单产品关系表
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyWorkOrderProduct")
//@Api(tags = "任务单接口")
public class TallyWorkOrderProductController extends BaseController {

    @Autowired
    private TallyWorkOrderProductService tallyWorkOrderProductService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyWorkOrderProduct tallyWorkOrderProduct) {
        return ApiResponse.success(tallyWorkOrderProductService.create(tallyWorkOrderProduct));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyWorkOrderProductService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyWorkOrderProduct tallyWorkOrderProduct) {
        tallyWorkOrderProductService.updateById(tallyWorkOrderProduct);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyWorkOrderProduct> pageWrap) {
        return ApiResponse.success(tallyWorkOrderProductService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyWorkOrderProductService.findById(id));
    }
}