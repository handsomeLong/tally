package com.tally.service.tallyaccounttype;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import java.util.List;

/**
 * 账户类型表Service定义
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
public interface TallyAccountTypeService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    Integer create(TallyAccountType tallyAccountType);

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
    void updateById(TallyAccountType tallyAccountType);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void updateByIdInBatch(List<TallyAccountType> tallyAccountTypes);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyAccountType findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyAccountType findOne(TallyAccountType tallyAccountType);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    List<TallyAccountType> findList(TallyAccountType tallyAccountType);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    PageData<TallyAccountType> findPage(PageWrap<TallyAccountType> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    long count(TallyAccountType tallyAccountType);
}