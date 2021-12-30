package com.tally.dao.tallystoragelog;

import com.tally.api.outputDto.TallyStorageLogOutDto;
import com.tally.dao.tallystoragelog.model.TallyStorageLog;
import com.tally.dao.tallystoragelog.model.TallyStorageLogExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyStorageLogMapper {
    int countByExample(TallyStorageLogExample example);

    int deleteByExample(TallyStorageLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyStorageLog record);

    int insertSelective(TallyStorageLog record);

    List<TallyStorageLog> selectByExample(TallyStorageLogExample example);

    TallyStorageLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyStorageLog record, @Param("example") TallyStorageLogExample example);

    int updateByExample(@Param("record") TallyStorageLog record, @Param("example") TallyStorageLogExample example);

    int updateByPrimaryKeySelective(TallyStorageLog record);

    int updateByPrimaryKey(TallyStorageLog record);

    List<TallyStorageLogOutDto> findPageWithSpec(@Param("userId") Integer userId, @Param("specId") Integer specId);
}