package com.tally.service.tallybilldetail;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import java.util.List;

/**
 * 账单明细Service定义
 * @author 131****2893
 * @date 2021/04/13 19:31
 */
public interface TallyBillDetailService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    Integer create(TallyBillDetail tallyBillDetail);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    void updateById(TallyBillDetail tallyBillDetail);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    void updateByIdInBatch(List<TallyBillDetail> tallyBillDetails);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    TallyBillDetail findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    TallyBillDetail findOne(TallyBillDetail tallyBillDetail);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    List<TallyBillDetail> findList(TallyBillDetail tallyBillDetail);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    PageData<TallyBillDetail> findPage(PageWrap<TallyBillDetail> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/04/13 19:31
     */
    long count(TallyBillDetail tallyBillDetail);

    PageData<TallyBillDetail> findCollectPage(Integer page, List<TallyBill> bills);

}