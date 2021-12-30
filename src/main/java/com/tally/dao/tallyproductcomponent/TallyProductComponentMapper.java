package com.tally.dao.tallyproductcomponent;

import com.tally.dao.tallyproductcomponent.model.TallyProductComponent;
import com.tally.dao.tallyproductcomponent.model.TallyProductComponentExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyProductComponentMapper {
    int countByExample(TallyProductComponentExample example);

    int deleteByExample(TallyProductComponentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyProductComponent record);

    int insertSelective(TallyProductComponent record);

    List<TallyProductComponent> selectByExample(TallyProductComponentExample example);

    TallyProductComponent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyProductComponent record, @Param("example") TallyProductComponentExample example);

    int updateByExample(@Param("record") TallyProductComponent record, @Param("example") TallyProductComponentExample example);

    int updateByPrimaryKeySelective(TallyProductComponent record);

    int updateByPrimaryKey(TallyProductComponent record);
}