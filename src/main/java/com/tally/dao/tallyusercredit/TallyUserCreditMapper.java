package com.tally.dao.tallyusercredit;

import com.tally.dao.tallyusercredit.model.TallyUserCredit;
import com.tally.dao.tallyusercredit.model.TallyUserCreditExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserCreditMapper {
    int countByExample(TallyUserCreditExample example);

    int deleteByExample(TallyUserCreditExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyUserCredit record);

    int insertSelective(TallyUserCredit record);

    List<TallyUserCredit> selectByExample(TallyUserCreditExample example);

    TallyUserCredit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyUserCredit record, @Param("example") TallyUserCreditExample example);

    int updateByExample(@Param("record") TallyUserCredit record, @Param("example") TallyUserCreditExample example);

    int updateByPrimaryKeySelective(TallyUserCredit record);

    int updateByPrimaryKey(TallyUserCredit record);
}