package com.tally.dao.tallyuserfriends;

import com.tally.api.outputDto.TallyUserFriendsInputDto;
import com.tally.api.outputDto.TallyUserFriendsOutDto;
import com.tally.dao.tallyuserfriends.model.TallyUserFriends;
import com.tally.dao.tallyuserfriends.model.TallyUserFriendsExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserFriendsMapper {
    int countByExample(TallyUserFriendsExample example);

    int deleteByExample(TallyUserFriendsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyUserFriends record);

    int insertSelective(TallyUserFriends record);

    List<TallyUserFriendsOutDto> selectByExample(TallyUserFriendsExample example);

    TallyUserFriends selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyUserFriends record, @Param("example") TallyUserFriendsExample example);

    int updateByExample(@Param("record") TallyUserFriends record, @Param("example") TallyUserFriendsExample example);

    int updateByPrimaryKeySelective(TallyUserFriends record);

    int updateByPrimaryKey(TallyUserFriends record);

List<TallyUserFriendsOutDto> findList(TallyUserFriendsInputDto tallyUserFriendsInputDto);
}