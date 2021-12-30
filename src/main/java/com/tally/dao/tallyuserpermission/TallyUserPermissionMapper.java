package com.tally.dao.tallyuserpermission;

import com.tally.dao.tallyuserpermission.model.TallyUserPermission;
import com.tally.dao.tallyuserpermission.model.TallyUserPermissionExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyUserPermissionMapper {
    int countByExample(TallyUserPermissionExample example);

    int deleteByExample(TallyUserPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TallyUserPermission record);

    int insertSelective(TallyUserPermission record);

    List<TallyUserPermission> selectByExample(TallyUserPermissionExample example);

    TallyUserPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TallyUserPermission record, @Param("example") TallyUserPermissionExample example);

    int updateByExample(@Param("record") TallyUserPermission record, @Param("example") TallyUserPermissionExample example);

    int updateByPrimaryKeySelective(TallyUserPermission record);

    int updateByPrimaryKey(TallyUserPermission record);
}
