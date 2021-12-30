package com.tally.service.tallyworkorder;

import com.tally.api.inputDto.WorkOrderInputDto;
import com.tally.api.outputDto.TallyWorkOrderOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyworkorder.model.TallyWorkOrder;

import java.text.ParseException;
import java.util.List;

/**
 * 生产单Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyWorkOrderService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyWorkOrder tallyWorkOrder);

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
    void updateById(TallyWorkOrder tallyWorkOrder);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyWorkOrder> tallyWorkOrders);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyWorkOrder findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyWorkOrderOutputDto findOne(TallyWorkOrder tallyWorkOrder);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyWorkOrderOutputDto> findList(TallyWorkOrder tallyWorkOrder);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyWorkOrder> findPage(PageWrap<WorkOrderInputDto> pageWrap);


    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyWorkOrder tallyWorkOrder);

    /**
     * 添加生产单
     * @param workOrderInputDto
     * @param userId
     * @return
     */
    ApiResponse addOrder(WorkOrderInputDto workOrderInputDto, String userId);



}