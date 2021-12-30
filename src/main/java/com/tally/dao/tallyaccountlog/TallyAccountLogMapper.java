package com.tally.dao.tallyaccountlog;

import com.tally.dao.tallyaccountlog.model.TallyAccountLog;
import com.tally.dao.tallyaccountlog.model.TallyAccountLogExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyAccountLogMapper {
    int countByExample(TallyAccountLogExample example);

    int deleteByExample(TallyAccountLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyAccountLog record);

    int insertSelective(TallyAccountLog record);

    List<TallyAccountLog> selectByExample(TallyAccountLogExample example);

    TallyAccountLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyAccountLog record, @Param("example") TallyAccountLogExample example);

    int updateByExample(@Param("record") TallyAccountLog record, @Param("example") TallyAccountLogExample example);

    int updateByPrimaryKeySelective(TallyAccountLog record);

    int updateByPrimaryKey(TallyAccountLog record);
}