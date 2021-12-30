package com.tally.dao.tallyaccountwaterdetail;

import com.tally.api.inputDto.BillReportInputDto;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetail;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetailExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyAccountWaterDetailMapper {
    int countByExample(TallyAccountWaterDetailExample example);

    int deleteByExample(TallyAccountWaterDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyAccountWaterDetail record);

    int insertSelective(TallyAccountWaterDetail record);
	
    List<TallyAccountWaterDetail> selectByExampleWithBLOBs(TallyAccountWaterDetailExample example);

    List<WaterDetailOutputDto> selectByExample(TallyAccountWaterDetailExample example);

    TallyAccountWaterDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyAccountWaterDetail record, @Param("example") TallyAccountWaterDetailExample example);

    int updateByExampleWithBLOBs(@Param("record") TallyAccountWaterDetail record, @Param("example") TallyAccountWaterDetailExample example);

    int updateByExample(@Param("record") TallyAccountWaterDetail record, @Param("example") TallyAccountWaterDetailExample example);

    int updateByPrimaryKeySelective(TallyAccountWaterDetail record);

    int updateByPrimaryKeyWithBLOBs(TallyAccountWaterDetail record);

    int updateByPrimaryKey(TallyAccountWaterDetail record);

    void insertBatch(List list);

    List<TallyAccountWaterDetail> findDetailByBillId(Integer id);

    List<WaterDetailOutputDto> findReport(BillReportInputDto inputDto);
}