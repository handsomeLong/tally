package com.tally.dao.tallywxalipayaccount;

import com.tally.dao.tallywxalipayaccount.model.TallyWxAlipayAccount;
import com.tally.dao.tallywxalipayaccount.model.TallyWxAlipayAccountExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyWxAlipayAccountMapper {
    int countByExample(TallyWxAlipayAccountExample example);

    int deleteByExample(TallyWxAlipayAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyWxAlipayAccount record);

    int insertSelective(TallyWxAlipayAccount record);

    List<TallyWxAlipayAccount> selectByExample(TallyWxAlipayAccountExample example);

    TallyWxAlipayAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyWxAlipayAccount record, @Param("example") TallyWxAlipayAccountExample example);

    int updateByExample(@Param("record") TallyWxAlipayAccount record, @Param("example") TallyWxAlipayAccountExample example);

    int updateByPrimaryKeySelective(TallyWxAlipayAccount record);

    int updateByPrimaryKey(TallyWxAlipayAccount record);
}