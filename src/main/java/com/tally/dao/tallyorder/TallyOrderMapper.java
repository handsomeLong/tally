package com.tally.dao.tallyorder;

import com.tally.api.inputDto.SalesAndPurchaseReportInputDto;
import com.tally.api.outputDto.OrderReportOutputDto;
import com.tally.api.outputDto.TallyOrderOutputDto;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorder.model.TallyOrderExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyOrderMapper {
    int countByExample(TallyOrderExample example);

    int deleteByExample(TallyOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyOrder record);

    int insertSelective(TallyOrder record);

    List<TallyOrderOutputDto> selectByExample(TallyOrderExample example);

    List<TallyOrder> selectByExampleWithNoSpec(TallyOrderExample example);

    TallyOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyOrder record, @Param("example") TallyOrderExample example);

    int updateByExample(@Param("record") TallyOrder record, @Param("example") TallyOrderExample example);

    int updateByPrimaryKeySelective(TallyOrder record);

    int updateByPrimaryKey(TallyOrder record);


    List<TallyOrder> findCollect(@Param("userId")Integer userId, @Param("orderType")Integer orderType);

    List<OrderReportOutputDto> salesAndPurchaseXlReport(SalesAndPurchaseReportInputDto inputDto);

    List<OrderReportOutputDto> salesAndPurchaseXSEReport(SalesAndPurchaseReportInputDto inputDto);

    List<OrderReportOutputDto> salesAndPurchaseLRReport(SalesAndPurchaseReportInputDto inputDto);

    List<OrderReportOutputDto> cusContributeXLReport(SalesAndPurchaseReportInputDto inputDto);

    List<OrderReportOutputDto> cusContributeXSEReport(SalesAndPurchaseReportInputDto inputDto);

    List<OrderReportOutputDto> cusContributeLRReport(SalesAndPurchaseReportInputDto inputDto);
}