package com.tally.service.tallystorageauit;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallystorageauit.model.TallyStorageAuit;
import java.util.List;

/**
 * 出入库审核表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyStorageAuitService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyStorageAuit tallyStorageAuit);

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
    void updateById(TallyStorageAuit tallyStorageAuit);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyStorageAuit> tallyStorageAuits);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyStorageAuit findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyStorageAuit findOne(TallyStorageAuit tallyStorageAuit);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyStorageAuit> findList(TallyStorageAuit tallyStorageAuit);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyStorageAuit> findPage(PageWrap<TallyStorageAuit> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyStorageAuit tallyStorageAuit);

    void saveByOrder(TallyOrder tallyOrder,List<TallyOrderProduct> list);

    /**
     * 账单审核
     * @param ids
     * @param status
     */
    void updateAuit(String ids, Integer status,Integer operateUserId);

    void storageAuitSuccess(Integer status, Integer operateUserId, TallyStorageAuit auit);
}