package com.tally.dao.tallyinouttype;

import com.tally.dao.tallyinouttype.model.TallyInOutType;
import com.tally.dao.tallyinouttype.model.TallyInOutTypeExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyInOutTypeMapper {
    int countByExample(TallyInOutTypeExample example);

    int deleteByExample(TallyInOutTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyInOutType record);

    int insertSelective(TallyInOutType record);

    List<TallyInOutType> selectByExample(TallyInOutTypeExample example);

    TallyInOutType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyInOutType record, @Param("example") TallyInOutTypeExample example);

    int updateByExample(@Param("record") TallyInOutType record, @Param("example") TallyInOutTypeExample example);

    int updateByPrimaryKeySelective(TallyInOutType record);

    int updateByPrimaryKey(TallyInOutType record);
}