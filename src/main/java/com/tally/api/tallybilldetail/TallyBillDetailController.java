package com.tally.api.tallybilldetail;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.service.tallybilldetail.TallyBillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 账单明细接口
 * @author 131****2893
 * @date 2021/04/13 19:31
 */
@RestController
@RequestMapping("/tallyBillDetail")
public class TallyBillDetailController extends BaseController {

    @Autowired
    private TallyBillDetailService tallyBillDetailService;

    /**
     * 创建
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyBillDetail tallyBillDetail) {
        return ApiResponse.success(tallyBillDetailService.create(tallyBillDetail));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyBillDetailService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyBillDetail tallyBillDetail) {
        tallyBillDetailService.updateById(tallyBillDetail);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyBillDetail> pageWrap) {
        return ApiResponse.success(tallyBillDetailService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyBillDetailService.findById(id));
    }
}