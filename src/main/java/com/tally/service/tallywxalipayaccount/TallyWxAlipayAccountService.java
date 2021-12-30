package com.tally.service.tallywxalipayaccount;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallywxalipayaccount.model.TallyWxAlipayAccount;
import java.util.List;

/**
 * 微信支付宝账号表Service定义
 * @author 131****2893
 * @date 2020/10/28 15:18
 */
public interface TallyWxAlipayAccountService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    Integer create(TallyWxAlipayAccount tallyWxAlipayAccount);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    void updateById(TallyWxAlipayAccount tallyWxAlipayAccount);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    void updateByIdInBatch(List<TallyWxAlipayAccount> tallyWxAlipayAccounts);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    TallyWxAlipayAccount findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    TallyWxAlipayAccount findOne(TallyWxAlipayAccount tallyWxAlipayAccount);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    List<TallyWxAlipayAccount> findList(TallyWxAlipayAccount tallyWxAlipayAccount);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    PageData<TallyWxAlipayAccount> findPage(PageWrap<TallyWxAlipayAccount> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/28 15:18
     */
    long count(TallyWxAlipayAccount tallyWxAlipayAccount);
}