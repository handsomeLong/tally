package com.tally.dao.tallyproduct;

import com.tally.api.outputDto.ProductOutputDto;
import com.tally.api.outputDto.TallyOrderOutputDto;
import com.tally.dao.tallyproduct.model.TallyProduct;
import com.tally.dao.tallyproduct.model.TallyProductExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TallyProductMapper {
    int countByExample(TallyProductExample example);

    int deleteByExample(TallyProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyProduct record);

    int insertSelective(TallyProduct record);

    List<ProductOutputDto> selectByExample(TallyProductExample example);

    ProductOutputDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyProduct record, @Param("example") TallyProductExample example);

    int updateByExample(@Param("record") TallyProduct record, @Param("example") TallyProductExample example);

    int updateByPrimaryKeySelective(TallyProduct record);

    int updateByPrimaryKey(TallyProduct record);

    BigDecimal getStockBalance(String userId);
}