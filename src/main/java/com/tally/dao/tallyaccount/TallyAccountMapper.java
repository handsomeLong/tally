package com.tally.dao.tallyaccount;

import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccount.model.TallyAccountExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyAccountMapper {
    int countByExample(TallyAccountExample example);

    int deleteByExample(TallyAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyAccount record);

    int insertSelective(TallyAccount record);

    List<TallyAccount> selectByExample(TallyAccountExample example);

    TallyAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyAccount record, @Param("example") TallyAccountExample example);

    int updateByExample(@Param("record") TallyAccount record, @Param("example") TallyAccountExample example);

    int updateByPrimaryKeySelective(TallyAccount record);

    int updateByPrimaryKey(TallyAccount record);
}