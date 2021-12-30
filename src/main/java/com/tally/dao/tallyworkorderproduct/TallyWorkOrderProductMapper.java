package com.tally.dao.tallyworkorderproduct;

import com.tally.dao.tallyworkorderproduct.model.TallyWorkOrderProduct;
import com.tally.dao.tallyworkorderproduct.model.TallyWorkOrderProductExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyWorkOrderProductMapper {
    int countByExample(TallyWorkOrderProductExample example);

    int deleteByExample(TallyWorkOrderProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyWorkOrderProduct record);

    int insertSelective(TallyWorkOrderProduct record);

    List<TallyWorkOrderProduct> selectByExample(TallyWorkOrderProductExample example);

    TallyWorkOrderProduct selectByPrimaryKey(Integer id);

    List<TallyWorkOrderProduct> selectByWorkOrderId(Integer id);

    int updateByExampleSelective(@Param("record") TallyWorkOrderProduct record, @Param("example") TallyWorkOrderProductExample example);

    int updateByExample(@Param("record") TallyWorkOrderProduct record, @Param("example") TallyWorkOrderProductExample example);

    int updateByPrimaryKeySelective(TallyWorkOrderProduct record);

    int updateByPrimaryKey(TallyWorkOrderProduct record);

    void insertBatch(List<TallyWorkOrderProduct> list);
}