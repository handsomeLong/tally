package com.tally.dao.tallyrolemenu;

import com.tally.dao.tallyrolemenu.model.TallyRoleMenu;
import com.tally.dao.tallyrolemenu.model.TallyRoleMenuExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyRoleMenuMapper {
    int countByExample(TallyRoleMenuExample example);

    int deleteByExample(TallyRoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyRoleMenu record);

    int insertSelective(TallyRoleMenu record);

    List<TallyRoleMenu> selectByExample(TallyRoleMenuExample example);

    TallyRoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyRoleMenu record, @Param("example") TallyRoleMenuExample example);

    int updateByExample(@Param("record") TallyRoleMenu record, @Param("example") TallyRoleMenuExample example);

    int updateByPrimaryKeySelective(TallyRoleMenu record);

    int updateByPrimaryKey(TallyRoleMenu record);
}