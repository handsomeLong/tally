package com.tally.dao.tallystorageauit;

import com.tally.dao.tallystorageauit.model.TallyStorageAuit;
import com.tally.dao.tallystorageauit.model.TallyStorageAuitExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyStorageAuitMapper {
    int countByExample(TallyStorageAuitExample example);

    int deleteByExample(TallyStorageAuitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyStorageAuit record);

    int insertSelective(TallyStorageAuit record);

    List<TallyStorageAuit> selectByExample(TallyStorageAuitExample example);

    TallyStorageAuit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyStorageAuit record, @Param("example") TallyStorageAuitExample example);

    int updateByExample(@Param("record") TallyStorageAuit record, @Param("example") TallyStorageAuitExample example);

    int updateByPrimaryKeySelective(TallyStorageAuit record);

    int updateByPrimaryKey(TallyStorageAuit record);

    List<TallyStorageAuit> findByIds(@Param("ids")String ids);
}