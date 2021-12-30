package com.tally.dao.tallyaccounttype;

import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import com.tally.dao.tallyaccounttype.model.TallyAccountTypeExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyAccountTypeMapper {
    int countByExample(TallyAccountTypeExample example);

    int deleteByExample(TallyAccountTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyAccountType record);

    int insertSelective(TallyAccountType record);

    List<TallyAccountType> selectByExample(TallyAccountTypeExample example);

    TallyAccountType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyAccountType record, @Param("example") TallyAccountTypeExample example);

    int updateByExample(@Param("record") TallyAccountType record, @Param("example") TallyAccountTypeExample example);

    int updateByPrimaryKeySelective(TallyAccountType record);

    int updateByPrimaryKey(TallyAccountType record);
}