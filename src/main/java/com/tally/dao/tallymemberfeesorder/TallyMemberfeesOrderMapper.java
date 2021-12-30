package com.tally.dao.tallymemberfeesorder;

import com.tally.dao.tallymemberfeesorder.model.TallyMemberfeesOrder;
import com.tally.dao.tallymemberfeesorder.model.TallyMemberfeesOrderExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyMemberfeesOrderMapper {
    int countByExample(TallyMemberfeesOrderExample example);

    int deleteByExample(TallyMemberfeesOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyMemberfeesOrder record);

    int insertSelective(TallyMemberfeesOrder record);

    List<TallyMemberfeesOrder> selectByExample(TallyMemberfeesOrderExample example);

    TallyMemberfeesOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyMemberfeesOrder record, @Param("example") TallyMemberfeesOrderExample example);

    int updateByExample(@Param("record") TallyMemberfeesOrder record, @Param("example") TallyMemberfeesOrderExample example);

    int updateByPrimaryKeySelective(TallyMemberfeesOrder record);

    int updateByPrimaryKey(TallyMemberfeesOrder record);
}