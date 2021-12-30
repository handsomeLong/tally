package com.tally.service.tallyaccountwaterdetail;

import com.tally.api.inputDto.BillReportInputDto;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 账户流水明细Service定义
 * @author 131****2893
 * @date 2021/01/08 14:39
 */
public interface TallyAccountWaterDetailService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    Integer create(TallyAccountWaterDetail tallyAccountWaterDetail);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    void updateById(TallyAccountWaterDetail tallyAccountWaterDetail);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    void updateByIdInBatch(List<TallyAccountWaterDetail> tallyAccountWaterDetails);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    TallyAccountWaterDetail findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    WaterDetailOutputDto findOne(TallyAccountWaterDetail tallyAccountWaterDetail);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    List<WaterDetailOutputDto> findList(TallyAccountWaterDetail tallyAccountWaterDetail, Date startTime, Date endTime);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    PageData<WaterDetailOutputDto> findPage(PageWrap<TallyAccountWaterDetail> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    long count(TallyAccountWaterDetail tallyAccountWaterDetail);

    List<TallyAccountWaterDetail> findDetailByBillId(Integer id);

    PageData<WaterDetailOutputDto>  findReportPage(BillReportInputDto detail);

    Map<String,BigDecimal> billReportCount(BillReportInputDto billReportInputDto);
}