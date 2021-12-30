package com.tally.service.tallyorder;

import com.tally.api.inputDto.OrderInputDto;
import com.tally.api.inputDto.ProfitsReportInputDto;
import com.tally.api.inputDto.SalesAndPurchaseReportInputDto;
import com.tally.api.outputDto.OrderReportOutputDto;
import com.tally.api.outputDto.TallyOrderOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallyorder.model.TallyOrder;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 订单表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyOrderService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyOrder tallyOrder);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateById(TallyOrder tallyOrder);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyOrder> tallyOrders);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyOrder findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyOrderOutputDto findOne(TallyOrder tallyOrder);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyOrderOutputDto> findList(TallyOrder tallyOrder);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyOrder> findListWithNoSpec(TallyOrder tallyOrder);

    /**
     * 分页查询
     * @param pageWrap
     * @return
     */
    public PageData<TallyOrder> findPageWithNoSpec(PageWrap<TallyOrder> pageWrap);
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyOrderOutputDto> findPage(PageWrap<OrderInputDto> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyOrder tallyOrder);

    ApiResponse addOrder(OrderInputDto addOrderInputDto);

    ApiResponse deliverGoods(OrderInputDto orderInputDto, HttpServletRequest request);

    ApiResponse takeGoods(OrderInputDto orderInputDto, HttpServletRequest request);

    PageData<TallyOrder> findCollectPage(PageWrap<TallyOrder> pageWrap);

    Map<String,String> profitsReport(ProfitsReportInputDto profitsReportInputDto) throws ParseException;

    PageData<OrderReportOutputDto> salesAndPurchaseReportPage(SalesAndPurchaseReportInputDto salesAndPurchaseReportInputDto);

    PageData<OrderReportOutputDto> cusContributeReport(SalesAndPurchaseReportInputDto inputDto);

    void saveByBill(TallyBill bill, Integer userId, Integer btypeUserId, String btypeUserName, Integer type, boolean isCreateProduct);
}