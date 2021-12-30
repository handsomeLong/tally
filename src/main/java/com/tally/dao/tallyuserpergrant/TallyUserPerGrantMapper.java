package com.tally.dao.tallyuserpergrant;

import com.tally.dao.tallyuserpergrant.model.TallyUserPerGrant;
import com.tally.dao.tallyuserpergrant.model.TallyUserPerGrantExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserPerGrantMapper {
    int countByExample(TallyUserPerGrantExample example);

    int deleteByExample(TallyUserPerGrantExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TallyUserPerGrant record);

    int insertSelective(TallyUserPerGrant record);

    List<TallyUserPerGrant> selectByExample(TallyUserPerGrantExample example);

    TallyUserPerGrant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TallyUserPerGrant record, @Param("example") TallyUserPerGrantExample example);

    int updateByExample(@Param("record") TallyUserPerGrant record, @Param("example") TallyUserPerGrantExample example);

    int updateByPrimaryKeySelective(TallyUserPerGrant record);

    int updateByPrimaryKey(TallyUserPerGrant record);

    List<TallyUserPerGrant> findGrantList(@Param("userId")String userId, @Param("alias")String alias);
}
