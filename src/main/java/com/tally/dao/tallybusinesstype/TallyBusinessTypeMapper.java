package com.tally.dao.tallybusinesstype;

import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.dao.tallybusinesstype.model.TallyBusinessTypeExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyBusinessTypeMapper {
    int countByExample(TallyBusinessTypeExample example);

    int deleteByExample(TallyBusinessTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyBusinessType record);

    int insertSelective(TallyBusinessType record);

    List<TallyBusinessType> selectByExample(TallyBusinessTypeExample example);

    TallyBusinessType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyBusinessType record, @Param("example") TallyBusinessTypeExample example);

    int updateByExample(@Param("record") TallyBusinessType record, @Param("example") TallyBusinessTypeExample example);

    int updateByPrimaryKeySelective(TallyBusinessType record);

    int updateByPrimaryKey(TallyBusinessType record);

    TallyBusinessType findByType(@Param("type") Integer type);
}