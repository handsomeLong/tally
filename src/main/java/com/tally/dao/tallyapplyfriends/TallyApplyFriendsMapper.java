package com.tally.dao.tallyapplyfriends;

import com.tally.dao.tallyapplyfriends.model.TallyApplyFriends;
import com.tally.dao.tallyapplyfriends.model.TallyApplyFriendsExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyApplyFriendsMapper {
    int countByExample(TallyApplyFriendsExample example);

    int deleteByExample(TallyApplyFriendsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyApplyFriends record);

    int insertSelective(TallyApplyFriends record);

    List<TallyApplyFriends> selectByExample(TallyApplyFriendsExample example);

    TallyApplyFriends selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyApplyFriends record, @Param("example") TallyApplyFriendsExample example);

    int updateByExample(@Param("record") TallyApplyFriends record, @Param("example") TallyApplyFriendsExample example);

    int updateByPrimaryKeySelective(TallyApplyFriends record);

    int updateByPrimaryKey(TallyApplyFriends record);
}