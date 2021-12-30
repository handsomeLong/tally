package com.tally.dao.tallystoragecheck;

import com.tally.dao.tallystoragecheck.model.TallyStorageCheck;
import com.tally.dao.tallystoragecheck.model.TallyStorageCheckExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyStorageCheckMapper {
    int countByExample(TallyStorageCheckExample example);

    int deleteByExample(TallyStorageCheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyStorageCheck record);

    int insertSelective(TallyStorageCheck record);
	
    List<TallyStorageCheck> selectByExampleWithBLOBs(TallyStorageCheckExample example);

    List<TallyStorageCheck> selectByExample(TallyStorageCheckExample example);

    TallyStorageCheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyStorageCheck record, @Param("example") TallyStorageCheckExample example);

    int updateByExampleWithBLOBs(@Param("record") TallyStorageCheck record, @Param("example") TallyStorageCheckExample example);

    int updateByExample(@Param("record") TallyStorageCheck record, @Param("example") TallyStorageCheckExample example);

    int updateByPrimaryKeySelective(TallyStorageCheck record);

    int updateByPrimaryKeyWithBLOBs(TallyStorageCheck record);

    int updateByPrimaryKey(TallyStorageCheck record);
}