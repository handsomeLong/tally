package com.tally.dao.tallyorderproduct;

import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyorderproduct.model.TallyOrderProductExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TallyOrderProductMapper {
    int countByExample(TallyOrderProductExample example);

    int deleteByExample(TallyOrderProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyOrderProduct record);

    int insertSelective(TallyOrderProduct record);

    List<TallyOrderProduct> selectByExample(TallyOrderProductExample example);

    List<TallyOrderProduct> selectByOrderId(TallyOrderProductExample example);

    TallyOrderProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyOrderProduct record, @Param("example") TallyOrderProductExample example);

    int updateByExample(@Param("record") TallyOrderProduct record, @Param("example") TallyOrderProductExample example);

    int updateByPrimaryKeySelective(TallyOrderProduct record);

    int updateByPrimaryKey(TallyOrderProduct record);

    void insertBatch(List<TallyOrderProduct> list);

    BigDecimal getProfits(@Param("ids")List<Integer> ids);

}