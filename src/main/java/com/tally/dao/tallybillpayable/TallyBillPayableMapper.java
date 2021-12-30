package com.tally.dao.tallybillpayable;

import com.tally.dao.tallybillpayable.model.TallyBillPayable;
import com.tally.dao.tallybillpayable.model.TallyBillPayableExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyBillPayableMapper {
    int countByExample(TallyBillPayableExample example);

    int deleteByExample(TallyBillPayableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyBillPayable record);

    int insertSelective(TallyBillPayable record);

    List<TallyBillPayable> selectByExample(TallyBillPayableExample example);

    TallyBillPayable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyBillPayable record, @Param("example") TallyBillPayableExample example);

    int updateByExample(@Param("record") TallyBillPayable record, @Param("example") TallyBillPayableExample example);

    int updateByPrimaryKeySelective(TallyBillPayable record);

    int updateByPrimaryKey(TallyBillPayable record);
}