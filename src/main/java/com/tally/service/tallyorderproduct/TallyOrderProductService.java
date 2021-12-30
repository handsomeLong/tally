package com.tally.service.tallyorderproduct;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import java.util.List;

/**
 * 订单产品规格关系表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyOrderProductService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyOrderProduct tallyOrderProduct);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateById(TallyOrderProduct tallyOrderProduct);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyOrderProduct> tallyOrderProducts);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyOrderProduct findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyOrderProduct findOne(TallyOrderProduct tallyOrderProduct);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyOrderProduct> findList(TallyOrderProduct tallyOrderProduct);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyOrderProduct> findPage(PageWrap<TallyOrderProduct> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyOrderProduct tallyOrderProduct);
}