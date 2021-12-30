package com.tally.dao.tallyproductspec;

import com.tally.api.outputDto.ProductSpecOutputDto;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.dao.tallyproductspec.model.TallyProductSpecExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyProductSpecMapper {
    int countByExample(TallyProductSpecExample example);

    int deleteByExample(TallyProductSpecExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyProductSpec record);

    int insertSelective(TallyProductSpec record);

    List<TallyProductSpec> selectByExample(TallyProductSpecExample example);

    TallyProductSpec selectByPrimaryKey(Integer id);

    TallyProductSpec selectByProductId(Integer productId);

    int updateByExampleSelective(@Param("record") TallyProductSpec record, @Param("example") TallyProductSpecExample example);

    int updateByExample(@Param("record") TallyProductSpec record, @Param("example") TallyProductSpecExample example);

    int updateByPrimaryKeySelective(TallyProductSpec record);

    int updateByPrimaryKey(TallyProductSpec record);

    void insertBatch(List<TallyProductSpec> list);

    void updateStorageAdd(@Param("productSpecId")Integer productSpecId, @Param("specNum")Integer specNum);

    void updateStorageSubtract(@Param("productSpecId")Integer productSpecId, @Param("specNum")Integer specNum);

    List<ProductSpecOutputDto> findWithProduct(@Param("userIdList")List userIdList);

    List<TallyProductSpec> findbyIds(@Param("ids")String productSpecIds);

    List<TallyProductSpec> findByUserId(@Param("userId")Integer userId, @Param("spec")TallyProductSpec spec);
}