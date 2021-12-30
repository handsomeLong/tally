package com.tally.service.tallybusinesstype;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import java.util.List;

/**
 * 业务类型表Service定义
 * @author 131****2893
 * @date 2021/03/27 19:02
 */
public interface TallyBusinessTypeService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    Integer create(TallyBusinessType tallyBusinessType);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    void updateById(TallyBusinessType tallyBusinessType);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    void updateByIdInBatch(List<TallyBusinessType> tallyBusinessTypes);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    TallyBusinessType findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    TallyBusinessType findOne(TallyBusinessType tallyBusinessType);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    List<TallyBusinessType> findList(TallyBusinessType tallyBusinessType);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    PageData<TallyBusinessType> findPage(PageWrap<TallyBusinessType> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/03/27 19:02
     */
    long count(TallyBusinessType tallyBusinessType);
}