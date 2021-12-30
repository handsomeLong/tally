package com.tally.dao.tallybillreceivable;

import com.tally.dao.tallybillreceivable.model.TallyBillReceivable;
import com.tally.dao.tallybillreceivable.model.TallyBillReceivableExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyBillReceivableMapper {
    int countByExample(TallyBillReceivableExample example);

    int deleteByExample(TallyBillReceivableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyBillReceivable record);

    int insertSelective(TallyBillReceivable record);

    List<TallyBillReceivable> selectByExample(TallyBillReceivableExample example);

    TallyBillReceivable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyBillReceivable record, @Param("example") TallyBillReceivableExample example);

    int updateByExample(@Param("record") TallyBillReceivable record, @Param("example") TallyBillReceivableExample example);

    int updateByPrimaryKeySelective(TallyBillReceivable record);

    int updateByPrimaryKey(TallyBillReceivable record);
}