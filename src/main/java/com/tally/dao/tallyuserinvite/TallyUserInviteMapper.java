package com.tally.dao.tallyuserinvite;

import com.tally.dao.tallyuserinvite.model.TallyUserInvite;
import com.tally.dao.tallyuserinvite.model.TallyUserInviteExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserInviteMapper {
    int countByExample(TallyUserInviteExample example);

    int deleteByExample(TallyUserInviteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyUserInvite record);

    int insertSelective(TallyUserInvite record);

    List<TallyUserInvite> selectByExample(TallyUserInviteExample example);

    TallyUserInvite selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyUserInvite record, @Param("example") TallyUserInviteExample example);

    int updateByExample(@Param("record") TallyUserInvite record, @Param("example") TallyUserInviteExample example);

    int updateByPrimaryKeySelective(TallyUserInvite record);

    int updateByPrimaryKey(TallyUserInvite record);
}