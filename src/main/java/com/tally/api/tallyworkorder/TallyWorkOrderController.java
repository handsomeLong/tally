package com.tally.api.tallyworkorder;

import com.tally.api.BaseController;
import com.tally.api.inputDto.WorkOrderInputDto;
import com.tally.api.outputDto.TallyWorkOrderOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyworkorder.model.TallyWorkOrder;
import com.tally.service.tallyworkorder.TallyWorkOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 生产单接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyWorkOrder")
@Api(tags = "生产单接口")
public class TallyWorkOrderController extends BaseController {

    @Autowired
    private TallyWorkOrderService tallyWorkOrderService;

    /**
     * 添加生产单
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/addWorkOrder")
    @ApiOperation("添加生产单")
    public ApiResponse addWorkOrder(@RequestBody WorkOrderInputDto workOrderInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        return tallyWorkOrderService.addOrder(workOrderInputDto,userId);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/workOrderList")
    @ApiOperation("生产单分页查询")
    public ApiResponse workOrderList (@RequestBody PageWrap<WorkOrderInputDto> pageWrap) {
        return ApiResponse.success(tallyWorkOrderService.findPage(pageWrap));
    }

    /**
     * 修改生产单
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    @ApiOperation("修改生产单")
    public ApiResponse updateById(@RequestBody TallyWorkOrder tallyWorkOrder) {
        tallyWorkOrderService.updateById(tallyWorkOrder);
        return ApiResponse.success(null);
    }

//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyWorkOrderService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//

//
//
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyWorkOrderService.findById(id));
//    }
}