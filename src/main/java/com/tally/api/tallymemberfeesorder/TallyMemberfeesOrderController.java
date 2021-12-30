package com.tally.api.tallymemberfeesorder;

import com.tally.api.BaseController;
import com.tally.api.inputDto.MemberfeesOrderInputDto;
import com.tally.api.inputDto.MiniPayInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.service.tallymemberfeesorder.TallyMemberfeesOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 会员缴费订单接口
 * @author 131****2893
 * @date 2020/10/31 21:47
 */
@RestController
@RequestMapping("/api/tallyMemberfeesOrder")
@Api(tags = "会员缴费订单接口")
public class TallyMemberfeesOrderController extends BaseController {

    @Autowired
    private TallyMemberfeesOrderService tallyMemberfeesOrderService;

    /**
     *  会员缴费下单
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    @PostMapping("/addOrder")
    @ApiOperation("会员缴费下单")
    public ApiResponse addOrder(@RequestBody MemberfeesOrderInputDto memberfeesOrderInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        return tallyMemberfeesOrderService.addOrder(memberfeesOrderInputDto,userId);
    }
    /**
     *  会员缴费小程序支付
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    @PostMapping("/miniPay")
    @ApiOperation("小程序支付")
    public ApiResponse miniPay(@RequestBody MiniPayInputDto miniPayInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        return tallyMemberfeesOrderService.saveMiniPay(miniPayInputDto,userId);
    }
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2020/10/31 21:47
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyMemberfeesOrderService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2020/10/31 21:47
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyMemberfeesOrder tallyMemberfeesOrder) {
//        tallyMemberfeesOrderService.updateById(tallyMemberfeesOrder);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 分页查询
//     * @author 131****2893
//     * @date 2020/10/31 21:47
//     */
//    @PostMapping("/page")
//    public ApiResponse findPage (@RequestBody PageWrap<TallyMemberfeesOrder> pageWrap) {
//        return ApiResponse.success(tallyMemberfeesOrderService.findPage(pageWrap));
//    }
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2020/10/31 21:47
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyMemberfeesOrderService.findById(id));
//    }
}