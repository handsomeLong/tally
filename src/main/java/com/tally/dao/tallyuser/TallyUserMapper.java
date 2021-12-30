package com.tally.dao.tallyuser;

import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.dao.tallyuser.model.TallyUserExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserMapper {
    int countByExample(TallyUserExample example);

    int deleteByExample(TallyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyUser record);

    int insertSelective(TallyUser record);

    List<TallyUser> selectByExample(TallyUserExample example);

    TallyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyUser record, @Param("example") TallyUserExample example);

    int updateByExample(@Param("record") TallyUser record, @Param("example") TallyUserExample example);

    int updateByPrimaryKeySelective(TallyUser record);

    int updateByPrimaryKey(TallyUser record);

    List<TallyUser> findByIds(@Param("userIdList")List<Integer> userIdList);
}