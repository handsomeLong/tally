package com.tally.dao.tallyuserrole;

import com.tally.dao.tallyuserrole.model.TallyUserRole;
import com.tally.dao.tallyuserrole.model.TallyUserRoleExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserRoleMapper {
    int countByExample(TallyUserRoleExample example);

    int deleteByExample(TallyUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyUserRole record);

    int insertSelective(TallyUserRole record);

    List<TallyUserRole> selectByExample(TallyUserRoleExample example);

    TallyUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyUserRole record, @Param("example") TallyUserRoleExample example);

    int updateByExample(@Param("record") TallyUserRole record, @Param("example") TallyUserRoleExample example);

    int updateByPrimaryKeySelective(TallyUserRole record);

    int updateByPrimaryKey(TallyUserRole record);
}