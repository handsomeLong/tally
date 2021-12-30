package com.tally.api.tallybillreceivable;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybillreceivable.model.TallyBillReceivable;
import com.tally.service.tallybillreceivable.TallyBillReceivableService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 应收账单接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyBillReceivable")
//@Api(tags = "应收账单接口")
public class TallyBillReceivableController extends BaseController {

    @Autowired
    private TallyBillReceivableService tallyBillReceivableService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyBillReceivable tallyBillReceivable) {
        return ApiResponse.success(tallyBillReceivableService.create(tallyBillReceivable));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyBillReceivableService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyBillReceivable tallyBillReceivable) {
        tallyBillReceivableService.updateById(tallyBillReceivable);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyBillReceivable> pageWrap) {
        return ApiResponse.success(tallyBillReceivableService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyBillReceivableService.findById(id));
    }
}