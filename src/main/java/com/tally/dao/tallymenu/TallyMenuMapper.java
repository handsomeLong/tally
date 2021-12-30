package com.tally.dao.tallymenu;

import com.tally.dao.tallymenu.model.TallyMenu;
import com.tally.dao.tallymenu.model.TallyMenuExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyMenuMapper {
    int countByExample(TallyMenuExample example);

    int deleteByExample(TallyMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyMenu record);

    int insertSelective(TallyMenu record);

    List<TallyMenu> selectByExample(TallyMenuExample example);

    TallyMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyMenu record, @Param("example") TallyMenuExample example);

    int updateByExample(@Param("record") TallyMenu record, @Param("example") TallyMenuExample example);

    int updateByPrimaryKeySelective(TallyMenu record);

    int updateByPrimaryKey(TallyMenu record);
}