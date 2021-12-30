package com.tally.service.tallyinouttype;

import com.tally.api.outputDto.TallyTypeOutputDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyinouttype.model.TallyInOutType;
import java.util.List;

/**
 * 收支类型Service定义
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
public interface TallyInOutTypeService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    Integer create(TallyInOutType tallyInOutType);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void updateById(TallyInOutType tallyInOutType);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void updateByIdInBatch(List<TallyInOutType> tallyInOutTypes);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyInOutType findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyInOutType findOne(TallyInOutType tallyInOutType);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    List<TallyInOutType> findList(TallyInOutType tallyInOutType);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    PageData<TallyInOutType> findPage(PageWrap<TallyInOutType> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    long count(TallyInOutType tallyInOutType);

    TallyTypeOutputDto save(TallyInOutType tallyInOutType);
}