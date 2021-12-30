package com.tally.dao.tallyaccountwater;

import com.tally.api.inputDto.BillReportInputDto;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.dao.tallyaccountwater.model.TallyAccountWater;
import com.tally.dao.tallyaccountwater.model.TallyAccountWaterExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyAccountWaterMapper {
    int countByExample(TallyAccountWaterExample example);

    int deleteByExample(TallyAccountWaterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyAccountWater record);

    int insertSelective(TallyAccountWater record);
	
    List<TallyAccountWater> selectByExampleWithBLOBs(TallyAccountWaterExample example);

    List<TallyAccountWater> selectByExample(TallyAccountWaterExample example);

    List<TallyAccountWater> findCollect(@Param("userId") Integer userId, @Param("accountTypeCode")String accountTypeCode);

    TallyAccountWater selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyAccountWater record, @Param("example") TallyAccountWaterExample example);

    int updateByExampleWithBLOBs(@Param("record") TallyAccountWater record, @Param("example") TallyAccountWaterExample example);

    int updateByExample(@Param("record") TallyAccountWater record, @Param("example") TallyAccountWaterExample example);

    int updateByPrimaryKeySelective(TallyAccountWater record);

    int updateByPrimaryKeyWithBLOBs(TallyAccountWater record);

    int updateByPrimaryKey(TallyAccountWater record);

    List<TallyAccountWater> waterCollectList(TallyAccountWater tallyAccountWater);

    List<TallyAccountWater> findWater(TallyAccountWater tallyAccountWater);

    List<TallyAccountWater> findReport(BillReportInputDto inputDto);
}