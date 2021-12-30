package com.tally.dao.tallyworkorder;

import com.tally.api.outputDto.TallyWorkOrderOutputDto;
import com.tally.dao.tallyworkorder.model.TallyWorkOrder;
import com.tally.dao.tallyworkorder.model.TallyWorkOrderExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyWorkOrderMapper {
    int countByExample(TallyWorkOrderExample example);

    int deleteByExample(TallyWorkOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyWorkOrder record);

    int insertSelective(TallyWorkOrder record);

    List<TallyWorkOrderOutputDto> selectByExample(TallyWorkOrderExample example);

    TallyWorkOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyWorkOrder record, @Param("example") TallyWorkOrderExample example);

    int updateByExample(@Param("record") TallyWorkOrder record, @Param("example") TallyWorkOrderExample example);

    int updateByPrimaryKeySelective(TallyWorkOrder record);

    int updateByPrimaryKey(TallyWorkOrder record);
}