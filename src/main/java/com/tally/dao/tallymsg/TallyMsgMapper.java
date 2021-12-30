package com.tally.dao.tallymsg;

import com.tally.dao.tallymsg.model.TallyMsg;
import com.tally.dao.tallymsg.model.TallyMsgExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyMsgMapper {
    int countByExample(TallyMsgExample example);

    int deleteByExample(TallyMsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyMsg record);

    int insertSelective(TallyMsg record);
	
    List<TallyMsg> selectByExampleWithBLOBs(TallyMsgExample example);

    List<TallyMsg> selectByExample(TallyMsgExample example);

    TallyMsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyMsg record, @Param("example") TallyMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") TallyMsg record, @Param("example") TallyMsgExample example);

    int updateByExample(@Param("record") TallyMsg record, @Param("example") TallyMsgExample example);

    int updateByPrimaryKeySelective(TallyMsg record);

    int updateByPrimaryKeyWithBLOBs(TallyMsg record);

    int updateByPrimaryKey(TallyMsg record);
}