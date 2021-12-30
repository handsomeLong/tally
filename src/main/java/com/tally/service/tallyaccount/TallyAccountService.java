package com.tally.service.tallyaccount;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccountwater.model.TallyAccountWater;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyuser.model.TallyUser;

import java.util.List;

/**
 * 账户流水Service定义
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
public interface TallyAccountService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    Integer create(TallyAccount tallyAccount);

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
    void updateById(TallyAccount tallyAccount);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void updateByIdInBatch(List<TallyAccount> tallyAccounts);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyAccount findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyAccount findOne(TallyAccount tallyAccount);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    List<TallyAccount> findList(TallyAccount tallyAccount);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    PageData<TallyAccount> findPage(PageWrap<TallyAccount> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    long count(TallyAccount tallyAccount);

    void createNewUserAccount(TallyUser tallyUser);

    void updateByOrder(TallyOrder tallyOrder, TallyAccountWater water,List<TallyOrderProduct> list);

    void updateByWater(TallyAccountWater tallyAccountWater);

    void updateByBill(TallyBill bill,TallyAccount account, Integer waterId,
                      String typeName, String operaType);
}