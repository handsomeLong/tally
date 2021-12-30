package com.tally.service.tallymemberfeesorder;

import com.tally.api.inputDto.MemberfeesOrderInputDto;
import com.tally.api.inputDto.MiniPayInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallymemberfeesorder.model.TallyMemberfeesOrder;
import java.util.List;

/**
 * 会员缴费订单Service定义
 * @author 131****2893
 * @date 2020/10/31 21:47
 */
public interface TallyMemberfeesOrderService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    Integer create(TallyMemberfeesOrder tallyMemberfeesOrder);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    void updateById(TallyMemberfeesOrder tallyMemberfeesOrder);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    void updateByIdInBatch(List<TallyMemberfeesOrder> tallyMemberfeesOrders);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    TallyMemberfeesOrder findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    TallyMemberfeesOrder findOne(TallyMemberfeesOrder tallyMemberfeesOrder);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    List<TallyMemberfeesOrder> findList(TallyMemberfeesOrder tallyMemberfeesOrder);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    PageData<TallyMemberfeesOrder> findPage(PageWrap<TallyMemberfeesOrder> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/31 21:47
     */
    long count(TallyMemberfeesOrder tallyMemberfeesOrder);

    /**
     * 会员缴费下单
     * @param memberfeesOrderInputDto
     * @return
     */
    ApiResponse addOrder(MemberfeesOrderInputDto memberfeesOrderInputDto, String userId);

    /**
     * 小程序支付
     * @param miniPayInputDto
     * @param userId
     * @return
     */
    ApiResponse saveMiniPay(MiniPayInputDto miniPayInputDto, String userId);
}