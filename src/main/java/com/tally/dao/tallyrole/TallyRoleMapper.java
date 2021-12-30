package com.tally.dao.tallyrole;

import com.tally.dao.tallyrole.model.TallyRole;
import com.tally.dao.tallyrole.model.TallyRoleExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyRoleMapper {
    int countByExample(TallyRoleExample example);

    int deleteByExample(TallyRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyRole record);

    int insertSelective(TallyRole record);

    List<TallyRole> selectByExample(TallyRoleExample example);

    TallyRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyRole record, @Param("example") TallyRoleExample example);

    int updateByExample(@Param("record") TallyRole record, @Param("example") TallyRoleExample example);

    int updateByPrimaryKeySelective(TallyRole record);

    int updateByPrimaryKey(TallyRole record);
}