package com.tally.dao.tallyusergrade;

import com.tally.dao.tallyusergrade.model.TallyUserGrade;
import com.tally.dao.tallyusergrade.model.TallyUserGradeExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserGradeMapper {
    int countByExample(TallyUserGradeExample example);

    int deleteByExample(TallyUserGradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyUserGrade record);

    int insertSelective(TallyUserGrade record);

    List<TallyUserGrade> selectByExample(TallyUserGradeExample example);

    TallyUserGrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyUserGrade record, @Param("example") TallyUserGradeExample example);

    int updateByExample(@Param("record") TallyUserGrade record, @Param("example") TallyUserGradeExample example);

    int updateByPrimaryKeySelective(TallyUserGrade record);

    int updateByPrimaryKey(TallyUserGrade record);
}