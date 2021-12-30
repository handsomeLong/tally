package com.tally.api.tallyorder;
import com.tally.api.BaseController;
import com.tally.api.inputDto.OrderInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.service.tallyorder.TallyOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyOrder")
@Api(tags = "订单接口")
public class TallyOrderController extends BaseController {

    @Autowired
    private TallyOrderService tallyOrderService;

    /**
     * 开单
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/addOrder")
    @ApiOperation("开单接口")
    public ApiResponse addOrder(@RequestBody OrderInputDto addOrderInputDto,HttpServletRequest request) {
        String userId = getUserId(request);
        addOrderInputDto.setUserId(Integer.valueOf(userId));
        return tallyOrderService.addOrder(addOrderInputDto);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/orderList")
    @ApiOperation("订单分页查询")
    public ApiResponse orderList (OrderInputDto orderInputDto,Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            orderInputDto.setUserId(Integer.valueOf(userId));
            PageWrap pageWrap = new PageWrap();
            pageWrap.setModel(orderInputDto);
            pageWrap.setPage(page);
            List<PageWrap.SortData> list = new ArrayList<>();
            PageWrap.SortData sortData = new PageWrap.SortData();
            sortData.setProperty("id");
            sortData.setDirection("desc");
            list.add(sortData);
            pageWrap.setSorts(list);
            PageData pageData = tallyOrderService.findPage(pageWrap);
            return ApiResponse.success(pageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ApiResponse.failed("调用失败");
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/orderPageWithNoSpec")
    @ApiOperation("订单分页查询")
    public ApiResponse orderPageWithNoSpec (TallyOrder tallyOrder,Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            tallyOrder.setUserId(Integer.valueOf(userId));
            PageWrap pageWrap = new PageWrap();
            pageWrap.setModel(tallyOrder);
            pageWrap.setPage(page);
            List<PageWrap.SortData> list = new ArrayList<>();
            PageWrap.SortData sortData = new PageWrap.SortData();
            sortData.setProperty("id");
            sortData.setDirection("desc");
            list.add(sortData);
            pageWrap.setSorts(list);
            PageData pageData = tallyOrderService.findPageWithNoSpec(pageWrap);
            return ApiResponse.success(pageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ApiResponse.failed("调用失败");
    }
    /**
     * 订单统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/getSumByOrderType")
    @ApiOperation("订单分页查询")
    public ApiResponse getSumByOrderType (TallyOrder tallyOrder, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            tallyOrder.setUserId(Integer.valueOf(userId));
            List<TallyOrder> list = tallyOrderService.findListWithNoSpec(tallyOrder);
            Double amount = new Double(0);
            if(!CollectionUtils.isEmpty(list))
                amount = list.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            return ApiResponse.success(new BigDecimal(amount).setScale(2,RoundingMode.HALF_DOWN));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ApiResponse.failed("调用失败");
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    @PostMapping("/collectPage")
    public ApiResponse findCollectPage (TallyOrder tallyOrder,
                                        Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            tallyOrder.setUserId(Integer.valueOf(userId));
            PageWrap pageWrap = new PageWrap();
            pageWrap.setPage(page);
            pageWrap.setModel(tallyOrder);
            return ApiResponse.success(tallyOrderService.findCollectPage(pageWrap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }

    /**
     * 发货
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/deliverGoods")
    @ApiOperation("发货")
    public ApiResponse deliverGoods (@RequestBody OrderInputDto orderInputDto, HttpServletRequest request) {
        return ApiResponse.success(tallyOrderService.deliverGoods(orderInputDto,request));
    }

    /**
     * 收货
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/takeGoods")
    @ApiOperation("收货")
    public ApiResponse takeGoods (@RequestBody OrderInputDto orderInputDto, HttpServletRequest request) {
        return ApiResponse.success(tallyOrderService.takeGoods(orderInputDto,request));
    }

//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyOrderService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyOrder tallyOrder) {
//        tallyOrderService.updateById(tallyOrder);
//        return ApiResponse.success(null);
//    }
//

//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyOrderService.findById(id));
//    }
    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/findById")
    @ApiOperation("订单详情")
    public ApiResponse finById(@RequestBody TallyOrder tallyOrder, HttpServletRequest request) {
        String userId = getUserId(request);
        tallyOrder.setUserId(Integer.valueOf(userId));
        return ApiResponse.success(tallyOrderService.findOne(tallyOrder));
    }
}