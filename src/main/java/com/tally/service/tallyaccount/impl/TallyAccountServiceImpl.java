package com.tally.service.tallyaccount.impl;

import com.tally.api.inputDto.AddCollectionInputDto;
import com.tally.core.enums.AccountTypeEnums;
import com.tally.core.enums.OrderTypeEnums;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyaccount.TallyAccountMapper;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccount.model.TallyAccountExample;
import com.tally.dao.tallyaccountlog.model.TallyAccountLog;
import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import com.tally.dao.tallyaccountwater.model.TallyAccountWater;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.dao.tallyinouttype.model.TallyInOutType;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.service.tallyaccount.TallyAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tally.service.tallyaccountlog.TallyAccountLogService;
import com.tally.service.tallyaccounttype.TallyAccountTypeService;
import com.tally.service.tallybusinesstype.TallyBusinessTypeService;
import com.tally.service.tallyinouttype.TallyInOutTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账户流水Service实现
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Service
public class TallyAccountServiceImpl implements TallyAccountService {

    @Autowired
    private TallyAccountMapper tallyAccountMapper;

    @Autowired
    private TallyAccountTypeService tallyAccountTypeService;
    @Autowired
    private TallyInOutTypeService tallyInOutTypeService;
    @Autowired
    private TallyAccountLogService tallyAccountLogService;
    @Autowired
    private TallyBusinessTypeService tallyBusinessTypeService;


    @Override
    public Integer create(TallyAccount tallyAccount) {
        tallyAccountMapper.insertSelective(tallyAccount);
        return tallyAccount.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyAccount tallyAccount) {
        tallyAccountMapper.updateByPrimaryKeySelective(tallyAccount);
    }

    @Override
    public void updateByIdInBatch(List<TallyAccount> tallyAccounts) {
        if (CollectionUtils.isEmpty(tallyAccounts)) return;
        for (TallyAccount tallyAccount: tallyAccounts) {
            this.updateById(tallyAccount);
        }
    }

    @Override
    public TallyAccount findById(Integer id) {
        return tallyAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyAccount findOne(TallyAccount tallyAccount) {
        ExampleBuilder<TallyAccountExample, TallyAccountExample.Criteria> builder = ExampleBuilder.create(TallyAccountExample.class, TallyAccountExample.Criteria.class);
        List<TallyAccount> tallyAccounts = tallyAccountMapper.selectByExample(builder.buildExamplePack(tallyAccount).getExample());
        if (tallyAccounts.size() > 0) {
            return tallyAccounts.get(0);
        }
        return null;
    }

    @Override
    public List<TallyAccount> findList(TallyAccount tallyAccount) {
        ExampleBuilder<TallyAccountExample, TallyAccountExample.Criteria> builder = ExampleBuilder.create(TallyAccountExample.class, TallyAccountExample.Criteria.class);
        return tallyAccountMapper.selectByExample(builder.buildExamplePack(tallyAccount).getExample());
    }
  
    @Override
    public PageData<TallyAccount> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyAccountExample, TallyAccountExample.Criteria> builder = ExampleBuilder.create(TallyAccountExample.class, TallyAccountExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyAccountExample, TallyAccountExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyAccountMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyAccount tallyAccount) {
        ExampleBuilder<TallyAccountExample, TallyAccountExample.Criteria> builder = ExampleBuilder.create(TallyAccountExample.class, TallyAccountExample.Criteria.class);
        return tallyAccountMapper.countByExample(builder.buildExamplePack(tallyAccount).getExample());
    }

    @Override
    public void createNewUserAccount(TallyUser tallyUser) {
        TallyAccountType tallyAccountType = new TallyAccountType();
        tallyAccountType.setUserId(0);
        List<TallyAccountType> types = tallyAccountTypeService.findList(tallyAccountType);
        for (TallyAccountType accountType:types) {
            //插入账户类型
            TallyAccountType accountType1 = new TallyAccountType();
            BeanUtils.copyProperties(accountType,accountType1);
            accountType1.setUserId(tallyUser.getId());
            Integer typeId = tallyAccountTypeService.create(accountType1);
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(tallyUser.getId());
            tallyAccount.setAmout(BigDecimal.ZERO);
            tallyAccount.setBooksId(0);
            tallyAccount.setTypeId(typeId);
            tallyAccountMapper.insertSelective(tallyAccount);
        }
        //创建收支类型
        TallyInOutType tallyInOutType = new TallyInOutType();
        tallyInOutType.setUserId(0);
        List<TallyInOutType> list = tallyInOutTypeService.findList(tallyInOutType);
        for (TallyInOutType type:list ) {
            //插入收支类型
            TallyInOutType tallyInOutType1 = new TallyInOutType();
            BeanUtils.copyProperties(type,tallyInOutType1);
            tallyInOutType1.setUserId(tallyUser.getId());
            tallyInOutTypeService.create(tallyInOutType1);
        }
    }

    @Override
    public void updateByOrder(TallyOrder tallyOrder, TallyAccountWater water,List<TallyOrderProduct> list) {
        //账户资金变动
        Integer accountId = tallyOrder.getSettleAccountId();
        TallyAccount account = this.findById(accountId);
        OrderTypeEnums typeEnums = OrderTypeEnums.getEnum(tallyOrder.getOrderType());
        TallyAccount newAccount = new  TallyAccount();
        newAccount.setId(accountId);
        if(typeEnums==OrderTypeEnums.SALES){
            newAccount.setAmout(account.getAmout().add(tallyOrder.getAmount()));
        }else if(typeEnums==OrderTypeEnums.PURCHASE){
            AccountTypeEnums accountTypeEnums = AccountTypeEnums.getEnum(account.getTypeCode());
            switch (accountTypeEnums){
                case YF:
                    newAccount.setAmout(account.getAmout().add(tallyOrder.getAmount()));
                    break;
                default:
                    newAccount.setAmout(account.getAmout().subtract(tallyOrder.getAmount()));
                    break;
            }
        }else if(typeEnums==OrderTypeEnums.SALES_RETURN){
            newAccount.setAmout(account.getAmout().subtract(tallyOrder.getAmount()));
        }else if(typeEnums==OrderTypeEnums.PURCHASE_RETURN){
            newAccount.setAmout(account.getAmout().add(tallyOrder.getAmount()));
        }
        tallyAccountMapper.updateByPrimaryKeySelective(newAccount);
        //保存日志
        TallyAccountLog log = new TallyAccountLog();
        log.setAccountId(accountId);
        log.setBeforeAmount(account.getAmout());
        log.setAfterAmount(newAccount.getAmout());
        log.setUserId(tallyOrder.getUserId());
        log.setWaterId(water.getId());
        log.setAmount(tallyOrder.getAmount());
        log.setType(typeEnums.getRetCode());
        log.setTypeName(typeEnums.getRetMsg());
        log.setRemark(tallyOrder.getRemark());
        tallyAccountLogService.create(log);
    }

    @Override
    public void updateByWater(TallyAccountWater tallyAccountWater) {
        //账户资金变动
        Integer accountId = tallyAccountWater.getAccountId();
        TallyAccount account = this.findById(accountId);
        TallyBusinessType tallyBusinessType = tallyBusinessTypeService.findById(tallyAccountWater.getTypeId());
        String typeCode = tallyBusinessType.getTypeCode();
        TallyAccount newAccount = new  TallyAccount();
        newAccount.setId(accountId);
        Integer type = 100;
        if(typeCode.equals("SR")){
            newAccount.setAmout(account.getAmout().add(tallyAccountWater.getAmount()));
            type=104;
        }else if(typeCode.equals("SQK")){
            newAccount.setAmout(account.getAmout().subtract(tallyAccountWater.getAmount()));
            type=104;
        }else if(typeCode.equals("SRGZ")){
            newAccount.setAmout(account.getAmout().add(tallyAccountWater.getAmount()));
            type=104;
        }else if(typeCode.equals("ZC")){
            newAccount.setAmout(account.getAmout().subtract(tallyAccountWater.getAmount()));
            type=105;
        }else if(typeCode.equals("HQK")){
            newAccount.setAmout(account.getAmout().subtract(tallyAccountWater.getAmount()));
            type=105;
        }else if(typeCode.equals("ZCGZ")){
            newAccount.setAmout(account.getAmout().add(tallyAccountWater.getAmount()));
            type=105;
        }
        tallyAccountMapper.updateByPrimaryKeySelective(newAccount);
        //保存日志
        TallyAccountLog log = new TallyAccountLog();
        log.setAccountId(accountId);
        log.setBeforeAmount(account.getAmout());
        log.setAfterAmount(newAccount.getAmout());
        log.setUserId(tallyAccountWater.getUserId());
        log.setWaterId(tallyAccountWater.getId());
        log.setAmount(tallyAccountWater.getAmount());
        log.setType(type);
        log.setRemark(tallyAccountWater.getRemark());
        log.setTypeName(tallyBusinessType.getTypeName());
        tallyAccountLogService.create(log);
    }

    @Override
    public void updateByBill(TallyBill bill,TallyAccount account, Integer waterId,
                             String typeName, String operaType) {
        //账户资金变动
        TallyAccount newAccount = new  TallyAccount();
        newAccount.setId(account.getId());
        Integer type = 100;
        if("ADD".equals(operaType)){
            newAccount.setAmout(account.getAmout().add(bill.getTotalPrice()));
            type=104;
        }else if("REDUCE".equals(operaType)){
            newAccount.setAmout(account.getAmout().subtract(bill.getTotalPrice()));
            type=105;
        }
        tallyAccountMapper.updateByPrimaryKeySelective(newAccount);
        //保存日志
        TallyAccountLog log = new TallyAccountLog();
        log.setAccountId(account.getId());
        log.setBeforeAmount(account.getAmout());
        log.setAfterAmount(newAccount.getAmout());
        log.setUserId(bill.getUserId());
        log.setWaterId(waterId);
        log.setAmount(bill.getTotalPrice());
        log.setType(type);
        log.setRemark(bill.getRemark());
        log.setTypeName(typeName);
        tallyAccountLogService.create(log);
    }
}