package com.tally.service.tallyaccountwater.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tally.api.inputDto.*;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.core.enums.AccountTypeEnums;
import com.tally.core.enums.OrderTypeEnums;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.DateUtils;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccountwater.TallyAccountWaterMapper;
import com.tally.dao.tallyaccountwater.model.TallyAccountWater;
import com.tally.dao.tallyaccountwater.model.TallyAccountWaterExample;
import com.tally.dao.tallyaccountwaterdetail.TallyAccountWaterDetailMapper;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetail;
import com.tally.dao.tallybill.TallyBillMapper;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybilldetail.TallyBillDetailMapper;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.dao.tallyinouttype.model.TallyInOutType;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.TallyOrderProductMapper;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyaccountwater.TallyAccountWaterService;
import com.tally.service.tallybill.TallyBillService;
import com.tally.service.tallybusinesstype.TallyBusinessTypeService;
import com.tally.service.tallyinouttype.TallyInOutTypeService;
import com.tally.service.tallyuser.TallyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 账户流水Service实现
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Service
public class TallyAccountWaterServiceImpl implements TallyAccountWaterService {

    @Autowired
    private TallyAccountWaterMapper tallyAccountWaterMapper;
    @Autowired
    private TallyAccountWaterService tallyAccountWaterService;
    @Autowired
    private TallyAccountWaterDetailMapper tallyAccountWaterDetailMapper;
    @Autowired
    private TallyOrderProductMapper tallyOrderProductMapper;
    @Autowired
    private TallyBusinessTypeService tallyBusinessTypeService;
    @Autowired
    private TallyInOutTypeService tallyInOutTypeService;
    @Autowired
    private TallyAccountService tallyAccountService;
    @Autowired
    private TallyBillDetailMapper tallyBillDetailMapper;
    @Autowired
    private TallyBillMapper tallyBillMapper;
    @Autowired
    private TallyUserService tallyUserService;
    @Autowired
    private TallyBillService tallyBillService;

    @Override
    public Integer create(TallyAccountWater tallyAccountWater) {
        tallyAccountWaterMapper.insertSelective(tallyAccountWater);
        return tallyAccountWater.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyAccountWaterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyAccountWater tallyAccountWater) {
        tallyAccountWaterMapper.updateByPrimaryKeySelective(tallyAccountWater);
    }

    @Override
    public void updateByIdInBatch(List<TallyAccountWater> tallyAccountWaters) {
        if (CollectionUtils.isEmpty(tallyAccountWaters)) return;
        for (TallyAccountWater tallyAccountWater: tallyAccountWaters) {
            this.updateById(tallyAccountWater);
        }
    }

    @Override
    public TallyAccountWater findById(Integer id) {
        return tallyAccountWaterMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyAccountWater findOne(TallyAccountWater tallyAccountWater) {
        ExampleBuilder<TallyAccountWaterExample, TallyAccountWaterExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterExample.class, TallyAccountWaterExample.Criteria.class);
        List<TallyAccountWater> tallyAccountWaters = tallyAccountWaterMapper.selectByExample(builder.buildExamplePack(tallyAccountWater).getExample());
        if (tallyAccountWaters.size() > 0) {
            return tallyAccountWaters.get(0);
        }
        return null;
    }

    @Override
    public TallyAccountWater findWater(TallyAccountWater tallyAccountWater) {
        List<TallyAccountWater> tallyAccountWaters = tallyAccountWaterMapper.findWater(tallyAccountWater);
        if (tallyAccountWaters.size() > 0) {
            return tallyAccountWaters.get(0);
        }
        return null;
    }

    @Override
    public List<TallyAccountWater> findList(TallyAccountWater tallyAccountWater) {
        ExampleBuilder<TallyAccountWaterExample, TallyAccountWaterExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterExample.class, TallyAccountWaterExample.Criteria.class);
        return tallyAccountWaterMapper.selectByExample(builder.buildExamplePack(tallyAccountWater).getExample());
    }
  
    @Override
    public PageData<TallyAccountWater> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyAccountWaterExample, TallyAccountWaterExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterExample.class, TallyAccountWaterExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyAccountWaterExample, TallyAccountWaterExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        pack.getCriteria().andamountGreaterThan(BigDecimal.ZERO);
        return PageData.from(new PageInfo<>(tallyAccountWaterMapper.selectByExample(pack.getExample())));
    }

    @Override
    public PageData<TallyAccountWater> findReportPage(BillReportInputDto inputDto) {
        PageHelper.startPage(inputDto.getPage(), inputDto.getCapacity());
        return PageData.from(new PageInfo<>(tallyAccountWaterMapper.findReport(inputDto)));
    }

    @Override
    public Map billReportCount(BillReportInputDto inputDto) {
        List<TallyAccountWater> list = tallyAccountWaterMapper.findReport(inputDto);
        Map<String,BigDecimal> map = new HashMap<>();
        BigDecimal amount = BigDecimal.ZERO;
        if(list.size()>0)
            amount = new BigDecimal(list.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get());
        map.put("amount",amount);
        return map;
    }

    @Override
    public PageData<TallyAccountWater> findCollectPage(PageWrap pageWrap, WaterDetailCollectInputDto inputDto) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        return PageData.from(new PageInfo<>(tallyAccountWaterMapper.findCollect(inputDto.getUserId(),inputDto.getAccountTypeCode())));
    }

    @Override
    public long count(TallyAccountWater tallyAccountWater) {
        ExampleBuilder<TallyAccountWaterExample, TallyAccountWaterExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterExample.class, TallyAccountWaterExample.Criteria.class);
        return tallyAccountWaterMapper.countByExample(builder.buildExamplePack(tallyAccountWater).getExample());
    }

    @Override
    public void addWater(AddWaterInputDto addWaterInputDto) throws  Exception {
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setAccountId(addWaterInputDto.getAccountId());
        tallyAccountWater.setAmount(addWaterInputDto.getAmout());
        tallyAccountWater.setBtypeUserId(addWaterInputDto.getBtypeUserId());
        tallyAccountWater.setBtypeUserName(addWaterInputDto.getBtypeUserName());
        tallyAccountWater.setDealTime(addWaterInputDto.getDealTime());
        tallyAccountWater.setRemark(addWaterInputDto.getRemark());
        tallyAccountWater.setUserId(addWaterInputDto.getUserId());
        TallyBusinessType businessType = new TallyBusinessType();
        businessType.setType(addWaterInputDto.getType());
        businessType.setSubClassType(addWaterInputDto.getSubClassType());
        TallyBusinessType btype = tallyBusinessTypeService.findOne(businessType);
        tallyAccountWater.setTypeId(btype.getId());
        tallyAccountWater.setTypeName(btype.getTypeName());
        tallyAccountWater.setType(addWaterInputDto.getType());
        //判断是应收或者应付类型则直接用应收应付账户
        if(addWaterInputDto.getSubClassType()==201){
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(addWaterInputDto.getUserId());
            if(addWaterInputDto.getType()==100){
                tallyAccount.setTypeCode(AccountTypeEnums.YS.getRetCode());
                TallyAccount one = tallyAccountService.findOne(tallyAccount);
                tallyAccountWater.setAccountId(one.getId());
            }else if(addWaterInputDto.getType()==101){
                tallyAccount.setTypeCode(AccountTypeEnums.YF.getRetCode());
                TallyAccount one = tallyAccountService.findOne(tallyAccount);
                tallyAccountWater.setAccountId(one.getId());
            }
        }
         tallyAccountWaterMapper.insertSelective(tallyAccountWater);
        //保存账单明细
        List<WaterDetailInputDto> list = addWaterInputDto.getWaterDetailList();
        List batchList = new ArrayList<TallyAccountWaterDetail>();
        for (WaterDetailInputDto in:list) {
            TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
            detail.setNumber(in.getNumber());
            detail.setPerPrice(in.getPerPrice());
            detail.setProductId(in.getProductId());
            detail.setProductSpecId(in.getProductSpecId());
            detail.setProductSpecName(in.getProductSpecName());
            detail.setAmount(in.getAmout());
            detail.setInOutType(in.getInOutType());
            detail.setInOutTypeId(in.getInOutTypeId());
            detail.setInOutTypeName(in.getInOutTypeName());
            detail.setRemark(in.getRemark());
            detail.setWaterId(tallyAccountWater.getId());
            batchList.add(detail);
        }
        tallyAccountWaterDetailMapper.insertBatch(batchList);
        //保存账户流水
        tallyAccountService.updateByWater(tallyAccountWater);
    }

    @Override
    public void addQuickAccount(AddWaterInputDto addWaterInputDto) {
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setAccountId(addWaterInputDto.getAccountId());
        tallyAccountWater.setAmount(addWaterInputDto.getAmout());
        tallyAccountWater.setBtypeUserId(addWaterInputDto.getBtypeUserId());
        tallyAccountWater.setBtypeUserName(addWaterInputDto.getBtypeUserName());
        tallyAccountWater.setDealTime(addWaterInputDto.getDealTime());
        tallyAccountWater.setRemark(addWaterInputDto.getRemark());
        tallyAccountWater.setUserId(addWaterInputDto.getUserId());
        TallyBusinessType businessType = new TallyBusinessType();
        businessType.setType(addWaterInputDto.getType());
        businessType.setSubClassType(addWaterInputDto.getSubClassType());
        TallyBusinessType btype = tallyBusinessTypeService.findOne(businessType);
        tallyAccountWater.setTypeId(btype.getId());
        tallyAccountWater.setTypeName(btype.getTypeName());
        tallyAccountWater.setType(addWaterInputDto.getType());
        //判断是应收或者应付类型则直接用应收应付账户
        if(addWaterInputDto.getSubClassType()==201){
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(addWaterInputDto.getUserId());
            if(addWaterInputDto.getType()==100){
                tallyAccount.setTypeCode(AccountTypeEnums.YS.getRetCode());
                TallyAccount one = tallyAccountService.findOne(tallyAccount);
                tallyAccountWater.setAccountId(one.getId());
            }else if(addWaterInputDto.getType()==101){
                tallyAccount.setTypeCode(AccountTypeEnums.YF.getRetCode());
                TallyAccount one = tallyAccountService.findOne(tallyAccount);
                tallyAccountWater.setAccountId(one.getId());
            }
        }
        tallyAccountWaterMapper.insertSelective(tallyAccountWater);
        //保存账单明细
        List<WaterDetailInputDto> list = addWaterInputDto.getWaterDetailList();
        if(!CollectionUtils.isEmpty(list)){
            List batchList = new ArrayList<TallyAccountWaterDetail>();
            for (WaterDetailInputDto in:list) {
                TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
                detail.setNumber(in.getNumber());
                detail.setPerPrice(in.getPerPrice());
                detail.setProductId(in.getProductId());
                detail.setProductSpecId(in.getProductSpecId());
                detail.setProductSpecName(in.getProductSpecName());
                detail.setAmount(in.getAmout());
                detail.setInOutType(in.getInOutType());
                detail.setInOutTypeId(in.getInOutTypeId());
                detail.setInOutTypeName(in.getInOutTypeName());
                detail.setRemark(in.getRemark());
                detail.setWaterId(tallyAccountWater.getId());
                batchList.add(detail);
            }
            if(!CollectionUtils.isEmpty(batchList))
                tallyAccountWaterDetailMapper.insertBatch(batchList);
        }else{
            TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
            detail.setNumber(0);
            detail.setPerPrice(BigDecimal.ZERO);
            detail.setProductId(0);
            detail.setProductSpecId(0);
            detail.setProductSpecName("其他");
            detail.setAmount(tallyAccountWater.getAmount());
            detail.setInOutType(addWaterInputDto.getInOutType());
            detail.setInOutTypeId(addWaterInputDto.getInOutType());
            detail.setInOutTypeName(addWaterInputDto.getInOutTypeName());
            detail.setRemark(tallyAccountWater.getRemark());
            detail.setWaterId(tallyAccountWater.getId());
            tallyAccountWaterDetailMapper.insertSelective(detail);
        }
    }

    @Override
    @Deprecated
    public void addCollection(AddCollectionInputDto addWaterInputDto) {
//        TallyBill bill = tallyBillMapper.selectByPrimaryKey(addWaterInputDto.getBillId());
//        TallyAccountWater tallyAccountWater = new TallyAccountWater();
//        tallyAccountWater.setAmount(addWaterInputDto.getAmount());
//        tallyAccountWater.setBtypeUserId(addWaterInputDto.getBtypeUserId());
//        tallyAccountWater.setBtypeUserName(addWaterInputDto.getBtypeUserName());
//        tallyAccountWater.setDealTime(addWaterInputDto.getDealTime());
//        tallyAccountWater.setRemark(addWaterInputDto.getRemark());
//        tallyAccountWater.setUserId(addWaterInputDto.getUserId());
//
//        TallyBusinessType businessType = new TallyBusinessType();
//        businessType.setType(addWaterInputDto.getType());
////        businessType.setSubClassType(addWaterInputDto.getSubClassType());
//        TallyBusinessType btype = tallyBusinessTypeService.findOne(businessType);
//
//        tallyAccountWater.setTypeId(btype.getId());
//        tallyAccountWater.setTypeName(btype.getTypeName());
//        tallyAccountWater.setType(addWaterInputDto.getType());
//        //判断是应收或者应付类型则直接用应收应付账户
//        TallyAccount account = new TallyAccount();
//        account.setUserId(addWaterInputDto.getUserId());
//        account.setTypeCode(AccountTypeEnums.XJ.getRetCode());
//        TallyAccount one = tallyAccountService.findOne(account);
//        tallyAccountWater.setAccountId(one.getId());
//        tallyAccountWaterMapper.insertSelective(tallyAccountWater);
//        /**
//         * 保存明细
//         */
//        TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
//        detail.setNumber(0);
//        detail.setPerPrice(BigDecimal.ZERO);
//        detail.setProductId(0);
//        detail.setProductSpecId(0);
//        detail.setProductSpecName("其他");
//        detail.setAmount(tallyAccountWater.getAmount());
//        detail.setRemark(tallyAccountWater.getRemark());
//        detail.setWaterId(tallyAccountWater.getId());
//        tallyAccountWaterDetailMapper.insertSelective(detail);
//        //账户处理
//        //更新账单
//        //查询未结算账单
//        TallyBill tb = new TallyBill();
//        tb.setBtypeUserId(addWaterInputDto.getBtypeUserId());
//        tb.setType(addWaterInputDto.getType());
//        tb.setStatus(100);
//        tb.setAuitStatus(101);
//        tb.setIsMaterial(0);
//        List<TallyBill> list = tallyBillService.findList(tb);
//        //按照金额大小倒序
//        list = list.stream().sorted(Comparator.comparingInt(TallyBill::getId)).collect(Collectors.toList());
//        BigDecimal amount = addWaterInputDto.getAmount();//结算金额
//        for (TallyBill tallyBill:list) {
//            BigDecimal unSettledAmount = tallyBill.getTotalPrice().subtract(tallyBill.getSettleAmount());
//            if(amount.compareTo(BigDecimal.ZERO)==0){
//                break;
//            }
//            if(unSettledAmount.compareTo(amount)>0){
//                TallyBill tbs = new TallyBill();
//                tbs.setId(tallyBill.getId());
//                tbs.setSettleAmount(tallyBill.getSettleAmount().add(amount));
//                tallyBillMapper.updateByPrimaryKeySelective(tbs);
//                break;
//            }else if(unSettledAmount.compareTo(amount)==0){
//                TallyBill tbs = new TallyBill();
//                tbs.setId(tallyBill.getId());
//                tbs.setSettleAmount(tallyBill.getSettleAmount().add(amount));
//                tbs.setStatus(101);
//                tallyBillMapper.updateByPrimaryKeySelective(tbs);
//                break;
//            }else if(unSettledAmount.compareTo(amount)<0){
//                TallyBill tbs = new TallyBill();
//                tbs.setId(tallyBill.getId());
//                tbs.setSettleAmount(tallyBill.getTotalPrice());
//                tbs.setStatus(101);
//                tallyBillMapper.updateByPrimaryKeySelective(tbs);
//                amount = amount.subtract(unSettledAmount);
//            }
//        }
    }



    @Override
    public void addWater(BigDecimal amount,Integer subClassType, AddBillInputDto addBillInputDto, List<BillDetailInputDto> productSpecList,Integer billId) {
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setAmount(amount);
        tallyAccountWater.setBtypeUserId(addBillInputDto.getBtypeUserId());
        tallyAccountWater.setBtypeUserName(addBillInputDto.getBtypeUserName());
        tallyAccountWater.setDealTime(addBillInputDto.getDealTime());
        tallyAccountWater.setRemark(addBillInputDto.getRemark());
        tallyAccountWater.setUserId(addBillInputDto.getUserId());
        TallyBusinessType businessType = new TallyBusinessType();
        businessType.setType(addBillInputDto.getType());
        businessType.setSubClassType(subClassType);
        TallyBusinessType btype = tallyBusinessTypeService.findOne(businessType);
        tallyAccountWater.setTypeId(btype.getId());
        tallyAccountWater.setTypeName(btype.getTypeName());
        tallyAccountWater.setType(addBillInputDto.getType());
        tallyAccountWater.setBillId(billId);
        //判断是应收或者应付类型则直接用应收应付账户
        if(subClassType==201){
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(addBillInputDto.getUserId());
            if(addBillInputDto.getType()==100){//应收账户
                tallyAccount.setTypeCode(AccountTypeEnums.YS.getRetCode());
                TallyAccount one = tallyAccountService.findOne(tallyAccount);
                tallyAccountWater.setAccountId(one.getId());
            }else if(addBillInputDto.getType()==101){//应付账户
                tallyAccount.setTypeCode(AccountTypeEnums.YF.getRetCode());
                TallyAccount one = tallyAccountService.findOne(tallyAccount);
                tallyAccountWater.setAccountId(one.getId());
            }
        }else{//现金账户
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(addBillInputDto.getUserId());
            tallyAccount.setTypeCode(AccountTypeEnums.XJ.getRetCode());
            TallyAccount one = tallyAccountService.findOne(tallyAccount);
            tallyAccountWater.setAccountId(one.getId());
        }
        tallyAccountWaterMapper.insertSelective(tallyAccountWater);
        //保存账单流水明细
        if(!CollectionUtils.isEmpty(productSpecList)){
            List batchList = new ArrayList<TallyAccountWaterDetail>();
            for (BillDetailInputDto in:productSpecList) {
                TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
                detail.setNumber(in.getNumber());
                detail.setPerPrice(in.getSpecPrice());
                detail.setProductId(in.getProductId());
                detail.setProductSpecId(in.getSpecId());
                detail.setProductSpecName(in.getName());
                detail.setAmount(in.getAmount());
                detail.setInOutType(addBillInputDto.getType());
                detail.setInOutTypeId(0);
                detail.setInOutTypeName(addBillInputDto.getType().equals(100)?"收入":"支出");
                detail.setWaterId(tallyAccountWater.getId());
                batchList.add(detail);
            }
            if(!CollectionUtils.isEmpty(batchList))
                tallyAccountWaterDetailMapper.insertBatch(batchList);
        }
    }

    @Override
    public TallyAccountWater saveByOrder(TallyOrder tallyOrder, List<TallyOrderProduct> list) {
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setAccountId(tallyOrder.getSettleAccountId());
        tallyAccountWater.setAmount(tallyOrder.getAmount());
        tallyAccountWater.setBtypeUserId(tallyOrder.getBuyerId());
        tallyAccountWater.setBtypeUserName(tallyOrder.getBuyerName());
        tallyAccountWater.setDealTime(DateUtils.getDateByPattern("yyyy-MM-dd",new Date()));
        tallyAccountWater.setRemark(tallyOrder.getRemark());
        tallyAccountWater.setUserId(tallyOrder.getUserId());
        TallyBusinessType businessType = new TallyBusinessType();
        OrderTypeEnums typeEnums = OrderTypeEnums.getEnum(tallyOrder.getOrderType());
        String inoutTypename = "销售收入";
        switch (typeEnums){
            case SALES:
                businessType.setTypeCode("SR");
                break;
            case PURCHASE:
                businessType.setTypeCode("ZC");
                inoutTypename="销售成本";
                break;
            case SALES_RETURN:
                businessType.setTypeCode("ZC");
                break;
            case PURCHASE_RETURN:
                businessType.setTypeCode("SR");
                break;
        }
        TallyBusinessType btype = tallyBusinessTypeService.findOne(businessType);
        tallyAccountWater.setTypeId(btype.getId());
        tallyAccountWater.setTypeName(btype.getTypeName());
        tallyAccountWater.setType(btype.getType());
        tallyAccountWaterMapper.insertSelective(tallyAccountWater);
        TallyInOutType tallyInOutType = new TallyInOutType();
        tallyInOutType.setUserId(tallyOrder.getUserId());
        tallyInOutType.setTypeName(inoutTypename);
        TallyInOutType one = tallyInOutTypeService.findOne(tallyInOutType);
        //保存账单明细
        List batchList = new ArrayList<TallyAccountWaterDetail>();
        for (TallyOrderProduct in:list) {
            TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
            detail.setNumber(in.getSpecNum());
            detail.setPerPrice(in.getSpecPrice());
            detail.setProductId(in.getProductId());
            detail.setProductSpecId(in.getProductSpecId());
            detail.setProductSpecName(in.getProductSpecName());
            detail.setAmount(in.getSpecPrice().multiply(new BigDecimal(in.getSpecNum())));
            detail.setInOutType(one.getType());
            detail.setInOutTypeId(one.getId());
            detail.setInOutTypeName(one.getTypeName());
            detail.setRemark(tallyOrder.getRemark());
            detail.setWaterId(tallyAccountWater.getId());
            batchList.add(detail);
        }
        tallyAccountWaterDetailMapper.insertBatch(batchList);
        return tallyAccountWater;
    }

    @Override
    public void saveByBill(TallyBill bill) {
            Integer type = bill.getType(); //账单类型
            TallyUser temp = new TallyUser();
            temp.setMobile(bill.getBtypeMobile());
            TallyUser btypeUser = tallyUserService.findOne(temp);
            TallyUser tallyUser = tallyUserService.findById(bill.getUserId());
            Integer btypeType = type==100?101:100;
        /**
             *   一、结算金额为零，只需要生成已收已付
             */
        if(bill.getSettleAmount().compareTo(BigDecimal.ZERO)==0){
                //应收应付
                TallyAccount tallyAccount2 = new TallyAccount();
                tallyAccount2.setUserId(tallyUser.getId());
                tallyAccount2.setTypeCode(type==100?AccountTypeEnums.YS.getRetCode():AccountTypeEnums.YF.getRetCode());
                TallyAccount account2 = tallyAccountService.findOne(tallyAccount2);
                TallyBusinessType businessType2 = new TallyBusinessType();
                businessType2.setTypeCode(type==100?"SRGZ":"ZCGZ");
                TallyBusinessType tallyBusinessType2 = tallyBusinessTypeService.findOne(businessType2);
                String  typeName = type==100?"收入挂账":"支出挂账";
                String  inOutTypeName = type==100?"收入挂账":"支出挂账";
                BigDecimal waterAmount = bill.getTotalPrice();
                Integer detailFlag = 1;
                //保存明细
                saveDetail(bill,tallyUser.getId(),btypeUser,waterAmount, type, account2.getId(), tallyBusinessType2.getId(), typeName, inOutTypeName,  detailFlag);
                /**
                 * 对方账户
                 */
                if(btypeUser==null){
                    return;
                }
                TallyAccount tallyAccount3 = new TallyAccount();
                tallyAccount3.setUserId(btypeUser.getId());
                tallyAccount3.setTypeCode(btypeType==100?AccountTypeEnums.YS.getRetCode():AccountTypeEnums.YF.getRetCode());
                TallyAccount account3 = tallyAccountService.findOne(tallyAccount3);
                TallyBusinessType businessType3 = new TallyBusinessType();
                businessType3.setTypeCode(btypeType==100?"SRGZ":"ZCGZ");
                TallyBusinessType tallyBusinessType3 = tallyBusinessTypeService.findOne(businessType3);
                typeName = btypeType==100?"收入挂账":"支出挂账";
                inOutTypeName = btypeType==100?"收入挂账":"支出挂账";
                saveDetail(bill,btypeUser.getId(),tallyUser,waterAmount, btypeType, account3.getId(), tallyBusinessType3.getId(), typeName, inOutTypeName,  detailFlag);
                return;
            }
            /**
             *   二、结算金额大于零，生成两个账单,有待收已收待付已付
             */
            if(bill.getTotalPrice().compareTo(bill.getSettleAmount())>0){

                /**
                 * 己方账户
                 */
                //已收已付
                TallyAccount tallyAccount = new TallyAccount();
                tallyAccount.setUserId(bill.getUserId());
                tallyAccount.setTypeCode(AccountTypeEnums.XJ.getRetCode());
                TallyAccount account = tallyAccountService.findOne(tallyAccount);
                TallyBusinessType businessType = new TallyBusinessType();
                businessType.setTypeCode(type==100?"SR":"ZC");
                TallyBusinessType tallyBusinessType = tallyBusinessTypeService.findOne(businessType);
                String typeName = type==100?"收入":"支出";
                String inOutTypeName = type==100?"收入":"支出";
                BigDecimal waterAmount = bill.getSettleAmount();
                Integer detailFlag = 2;
                //保存明细
                saveDetail(bill,tallyUser.getId(),btypeUser,waterAmount, type, account.getId(), tallyBusinessType.getId(), typeName, inOutTypeName,  detailFlag);
                /**
                 * 对方账户
                 */
                if(btypeUser==null){
                    return;
                }
                //已收已付
                TallyAccount tallyAccount1 = new TallyAccount();
                tallyAccount1.setUserId(btypeUser.getId());
                tallyAccount1.setTypeCode(AccountTypeEnums.XJ.getRetCode());
                TallyAccount account1 = tallyAccountService.findOne(tallyAccount1);
                TallyBusinessType businessType1 = new TallyBusinessType();
                businessType1.setTypeCode(btypeType==100?"SR":"ZC");
                TallyBusinessType tallyBusinessTyp1 = tallyBusinessTypeService.findOne(businessType1);
                typeName = btypeType==100?"收入":"支出";
                inOutTypeName = btypeType==100?"收入":"支出";
                //保存明细
                saveDetail(bill,btypeUser.getId(),tallyUser,waterAmount, btypeType, account1.getId(), tallyBusinessTyp1.getId(), typeName, inOutTypeName,  detailFlag);

                /**
                 * 己方账户
                 */
                //应收应付
                TallyAccount tallyAccount2 = new TallyAccount();
                tallyAccount2.setUserId(bill.getUserId());
                tallyAccount2.setTypeCode(type==100?AccountTypeEnums.YS.getRetCode():AccountTypeEnums.YF.getRetCode());
                TallyAccount account2 = tallyAccountService.findOne(tallyAccount2);
                TallyBusinessType businessType2 = new TallyBusinessType();
                businessType2.setTypeCode(type==100?"SRGZ":"ZCGZ");
                TallyBusinessType tallyBusinessType2 = tallyBusinessTypeService.findOne(businessType2);
                typeName = type==100?"收入挂账":"支出挂账";
                inOutTypeName = type==100?"收入挂账":"支出挂账";
                waterAmount = bill.getTotalPrice().subtract(bill.getSettleAmount());
                detailFlag = 3;
                //保存明细
                saveDetail(bill,tallyUser.getId(),btypeUser,waterAmount, type, account2.getId(), tallyBusinessType2.getId(), typeName, inOutTypeName,  detailFlag);

                /**
                 * 对方账户
                 */
                if(btypeUser==null){
                    return;
                }
                //应收应付
                TallyAccount tallyAccount3 = new TallyAccount();
                tallyAccount3.setUserId(btypeUser.getId());
                tallyAccount3.setTypeCode(btypeType==100?AccountTypeEnums.YS.getRetCode():AccountTypeEnums.YF.getRetCode());
                TallyAccount account3 = tallyAccountService.findOne(tallyAccount3);
                TallyBusinessType businessType3 = new TallyBusinessType();
                businessType3.setTypeCode(btypeType==100?"SRGZ":"ZCGZ");
                TallyBusinessType tallyBusinessType3 = tallyBusinessTypeService.findOne(businessType3);
                typeName = btypeType==100?"收入挂账":"支出挂账";
                inOutTypeName = btypeType==100?"收入挂账":"支出挂账";
                //保存明细
                saveDetail(bill,btypeUser.getId(),tallyUser,waterAmount, btypeType, account3.getId(), tallyBusinessType3.getId(), typeName, inOutTypeName,  detailFlag);


            }else{

                /**
                 * 己方账户
                 */

                //生成一个账单，只有收入或者支出
                TallyAccount tallyAccount = new TallyAccount();
                tallyAccount.setUserId(bill.getUserId());
                tallyAccount.setTypeCode(AccountTypeEnums.XJ.getRetCode());
                TallyAccount account = tallyAccountService.findOne(tallyAccount);

                TallyBusinessType businessType = new TallyBusinessType();
                businessType.setTypeCode(type==100?"SR":"ZC");
                TallyBusinessType tallyBusinessType = tallyBusinessTypeService.findOne(businessType);
                String typeName = type==100?"收入":"支出";
                String inOutTypeName = type==100?"收入":"支出";
                BigDecimal waterAmount = bill.getTotalPrice();
                Integer detailFlag = 1;

                saveDetail(bill,tallyUser.getId(),btypeUser,waterAmount, type, account.getId(), tallyBusinessType.getId(), typeName, inOutTypeName,  detailFlag);

                /**
                 * 对方账户
                 */
                if(btypeUser==null){
                    return;
                }
                //生成一个账单，只有收入或者支出
                TallyAccount tallyAccount1 = new TallyAccount();
                tallyAccount1.setUserId(btypeUser.getId());
                tallyAccount1.setTypeCode(AccountTypeEnums.XJ.getRetCode());
                TallyAccount account1 = tallyAccountService.findOne(tallyAccount1);

                TallyBusinessType businessType1 = new TallyBusinessType();
                businessType1.setTypeCode(btypeType==100?"SR":"ZC");
                TallyBusinessType tallyBusinessType1 = tallyBusinessTypeService.findOne(businessType1);
                typeName = btypeType==100?"收入":"支出";
                inOutTypeName = btypeType==100?"收入":"支出";

                saveDetail(bill,btypeUser.getId(),tallyUser,waterAmount, btypeType, account1.getId(), tallyBusinessType1.getId(), typeName, inOutTypeName,  detailFlag);

            }
    }

    private void saveDetail(TallyBill bill,Integer userId,TallyUser btypeUser, BigDecimal waterAmount, Integer type, Integer accountId, Integer typeId, String typeName, String inOutTypeName, Integer detailFlag) {
        TallyAccountWater water = new TallyAccountWater();
        water.setBillId(bill.getId());
        water.setAmount(waterAmount);
        water.setAccountId(accountId);
        water.setBtypeUserId(btypeUser.getId());
        water.setBtypeUserName(StringUtils.isEmpty(btypeUser.getName())?btypeUser.getMobile():btypeUser.getName());
        water.setDealTime(bill.getDealTime());
        water.setRemark(bill.getRemark());
        water.setType(type);
        water.setTypeId(typeId);
        water.setTypeName(typeName);
        water.setUserId(userId);
        water.setAuitStatus(101);
        this.create(water);

        //生成账单明细,流水明细和账单明细一一对应
        List<TallyBillDetail> detailList = tallyBillDetailMapper.findByBillId(bill.getId());
        List batchList = new ArrayList<TallyAccountWaterDetail>();
        for (TallyBillDetail in:detailList) {
            TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
            detail.setNumber(in.getNumber());
            detail.setPerPrice(in.getPerPrice());
            detail.setProductId(in.getProductId());
            detail.setProductSpecId(in.getProductSpecId());
            detail.setProductSpecName(in.getProductSpecName());
            if(1==detailFlag){
                detail.setAmount(in.getAmount());
            }else if(2==detailFlag){
                detail.setAmount(in.getSettleAmount());
            }else if(3==detailFlag){
                detail.setAmount(in.getAmount().subtract(in.getSettleAmount()));
            }
            detail.setInOutType(type);
            detail.setInOutTypeId(0);
            detail.setInOutTypeName(inOutTypeName);
            detail.setRemark(bill.getRemark());
            detail.setWaterId(water.getId());
            detail.setBillDetailId(in.getId());
            batchList.add(detail);
        }
        tallyAccountWaterDetailMapper.insertBatch(batchList);
        //保存账户流水
        tallyAccountService.updateByWater(water);
    }

    @Override
    public PageData<TallyAccountWater> waterCollectPage(TallyAccountWater tallyAccountWater, Integer page) {
        PageHelper.startPage(page, 10);
        List<TallyAccountWater> list = tallyAccountWaterMapper.waterCollectList(tallyAccountWater);
        return PageData.from(new PageInfo<>(list));
    }
    /**
     * 收款 则 自己账户 待收账户减少 增加现金账户收入，对方账户 待还账户减少 现金账户支出
     * 还款 则 自己账户 待还账户减少 现金账户支出，对方账户 待收账户减少 现金账户增加
     * @param bill
     */
    @Override
    public void saveCollection(TallyBill bill) {
        TallyAccount ta = new TallyAccount();
        ta.setUserId(bill.getUserId());
        ta.setTypeCode("XJ");
        TallyAccount userXJAccount = tallyAccountService.findOne(ta);
        ta.setUserId(bill.getBtypeUserId());
        TallyAccount btypeUserXJAccount = tallyAccountService.findOne(ta);
        TallyUser tallyUser = tallyUserService.findById(bill.getUserId());
        TallyUser btypeUser = tallyUserService.findById(bill.getBtypeUserId());
        Integer type1=100;
        Integer type2=101;
        if(103==bill.getType()){
            type1=101;
            type2=100;
        }
        Integer waterId = this.addCollectionWater(userXJAccount,bill,tallyUser,btypeUser,type1);
        Integer btwaterId = this.addCollectionWater(btypeUserXJAccount,bill,btypeUser,tallyUser,type2);
        if(102==bill.getType()){//收款
            //当前应收账户
            ta.setTypeCode("YS");
            ta.setUserId(bill.getUserId());
            TallyAccount ysAccount = tallyAccountService.findOne(ta);
            //对方应付账户
             ta.setTypeCode("YF");
             ta.setUserId(bill.getBtypeUserId());
            TallyAccount yfAccount = tallyAccountService.findOne(ta);

            tallyAccountService.updateByBill(bill,ysAccount,waterId,"收欠款","REDUCE");//应收减少
            tallyAccountService.updateByBill(bill,userXJAccount,waterId,"收欠款","ADD");//现金增加

            tallyAccountService.updateByBill(bill,yfAccount,btwaterId,"还欠款","REDUCE");//应付减少
            tallyAccountService.updateByBill(bill,btypeUserXJAccount,btwaterId,"还欠款","REDUCE");//现金减少
        }else if(103==bill.getType()){//还款
            //当前应付账户
            ta.setTypeCode("YF");
            ta.setUserId(bill.getUserId());
            TallyAccount yfAccount = tallyAccountService.findOne(ta);
            //对方应收账户
            ta.setTypeCode("YS");
            ta.setUserId(bill.getBtypeUserId());
            TallyAccount ysAccount = tallyAccountService.findOne(ta);

            tallyAccountService.updateByBill(bill,yfAccount,waterId,"还欠款","REDUCE");//应付减少
            tallyAccountService.updateByBill(bill,userXJAccount,waterId,"还欠款","REDUCE");//现金减少

            tallyAccountService.updateByBill(bill,ysAccount,btwaterId,"收欠款","REDUCE");//应收减少
            tallyAccountService.updateByBill(bill,btypeUserXJAccount,btwaterId,"收欠款","REDUCE");//现金增加
        }
        this.updatehHandleBill(bill);
    }

    private void updatehHandleBill(TallyBill bill) {
        //查询未结算账单
        Integer type = 0;
        if(102==bill.getType()){
            type=100;
        }else if(103==bill.getType()){
            type=101;
        }
        TallyBill tb = new TallyBill();
        tb.setUserId(bill.getUserId());
        tb.setBtypeUserId(bill.getBtypeUserId());
        tb.setType(type);
        tb.setStatus(100);
        tb.setAuitStatus(101);
        tb.setIsMaterial(0);
        List<TallyBill> list = tallyBillService.findList(tb);
        //按照金额大小倒序
        list = list.stream().sorted(Comparator.comparingInt(TallyBill::getId)).collect(Collectors.toList());
        BigDecimal amount = bill.getTotalPrice();//结算金额
        BigDecimal dealAmount = BigDecimal.ZERO;
        for (TallyBill tallyBill:list) {
            BigDecimal unSettledAmount = tallyBill.getTotalPrice().subtract(tallyBill.getSettleAmount());
            if(amount.compareTo(BigDecimal.ZERO)==0){
                break;
            }
            if(unSettledAmount.compareTo(amount)>0){
                TallyBill tbs = TallyBill.builder().id(tallyBill.getId()).
                        settleAmount(tallyBill.getSettleAmount().add(amount)).build();
                tallyBillMapper.updateByPrimaryKeySelective(tbs);
                //更新billDetail 部分满，部分不满
                this.updateBillDetailSettleAmount(amount,tallyBill);
                dealAmount=amount;
                this.handleRelWater(type, dealAmount, tallyBill);
                break;
            }else if(unSettledAmount.compareTo(amount)==0){
                TallyBill tbs = TallyBill.builder().id(tallyBill.getId())
                        .settleAmount(tallyBill.getSettleAmount().add(amount))
                        .status(101).build();
                tallyBillMapper.updateByPrimaryKeySelective(tbs);
                //更新 billDetail,全部满了
                tallyBillDetailMapper.updateSettledByBillId(tallyBill.getId());
                dealAmount=amount;
                this.handleRelWater(type, dealAmount, tallyBill);
                break;
            }else if(unSettledAmount.compareTo(amount)<0){
                TallyBill tbs = TallyBill.builder().id(tallyBill.getId())
                        .settleAmount(tallyBill.getSettleAmount().add(amount))
                        .status(101).build();
                tallyBillMapper.updateByPrimaryKeySelective(tbs);
                //更新 billDetail,全部满了
                tallyBillDetailMapper.updateSettledByBillId(tallyBill.getId());
                amount = amount.subtract(unSettledAmount);
                dealAmount=unSettledAmount;
                this.handleRelWater(type, dealAmount, tallyBill);
            }
        }
    }

    private void updateBillDetailSettleAmount(BigDecimal amount, TallyBill bill) {
        List<TallyBillDetail> details = tallyBillDetailMapper.findByBillId(bill.getId());
        details = details.stream().sorted(Comparator.comparing(TallyBillDetail::getAmount)).collect(Collectors.toList());
        for (TallyBillDetail detail:details) {
            if(amount.compareTo(BigDecimal.ZERO)<=0){
                break;
            }
            BigDecimal unSettleAmount = detail.getAmount().subtract(detail.getSettleAmount());
            if(unSettleAmount.compareTo(amount)>0){
                TallyBillDetail dd = TallyBillDetail.builder().id(detail.getId()).settleAmount(detail.getSettleAmount().add(amount)).build();
                tallyBillDetailMapper.updateByPrimaryKeySelective(dd);
                break;
            }else if(unSettleAmount.compareTo(amount)==0){
                TallyBillDetail dd = TallyBillDetail.builder().id(detail.getId()).settleAmount(detail.getSettleAmount().add(amount)).build();
                tallyBillDetailMapper.updateByPrimaryKeySelective(dd);
                break;
            }else if(unSettleAmount.compareTo(amount)<0){
                TallyBillDetail dd = TallyBillDetail.builder().id(detail.getId()).settleAmount(detail.getSettleAmount().add(unSettleAmount)).build();
                tallyBillDetailMapper.updateByPrimaryKeySelective(dd);
                amount = amount.subtract(unSettleAmount);
            }
        }
    }

    private void handleRelWater(Integer type, BigDecimal dealAmount, TallyBill tallyBill) {
        //更新相应的流水
        //自身的
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setBillId(tallyBill.getId());
        tallyAccountWater.setUserId(tallyBill.getUserId());
        tallyAccountWater.setType(type);
        tallyAccountWater.setTypeName(type==100?"收入挂账":"支出挂账");
        TallyAccountWater one = tallyAccountWaterService.findWater(tallyAccountWater);
        TallyAccountWater ta = new TallyAccountWater();
        ta.setId(one.getId());
        ta.setAmount(one.getAmount().subtract(dealAmount));
        tallyAccountWaterMapper.updateByPrimaryKeySelective(ta);
        //对方的
        TallyAccountWater tallyAccountWater2 = new TallyAccountWater();
        tallyAccountWater2.setBillId(tallyBill.getId());
        tallyAccountWater2.setUserId(tallyBill.getBtypeUserId());
        tallyAccountWater2.setType(type==100?101:100);
        tallyAccountWater2.setTypeName(type==100?"支出挂账":"收入挂账");
        TallyAccountWater one2 = tallyAccountWaterService.findWater(tallyAccountWater2);
        TallyAccountWater ta2 = new TallyAccountWater();
        ta2.setId(one2.getId());
        ta2.setAmount(one2.getAmount().subtract(dealAmount));
        tallyAccountWaterMapper.updateByPrimaryKeySelective(ta2);
    }

    private Integer addCollectionWater(TallyAccount account,TallyBill bill,
                                       TallyUser tallyUser, TallyUser btypeUser,Integer type) {
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setAmount(bill.getTotalPrice());
        tallyAccountWater.setBtypeUserId(btypeUser.getId());
        tallyAccountWater.setBtypeUserName(btypeUser.getName());
        tallyAccountWater.setDealTime(bill.getDealTime());
        tallyAccountWater.setRemark(bill.getRemark());
        tallyAccountWater.setUserId(tallyUser.getId());
        TallyBusinessType businessType = new TallyBusinessType();
        businessType.setType(type);
        businessType.setSubClassType(200);//收欠款
        TallyBusinessType btype = tallyBusinessTypeService.findOne(businessType);
        tallyAccountWater.setTypeId(btype.getId());
        tallyAccountWater.setTypeName(btype.getTypeName());
        tallyAccountWater.setType(btype.getType());
        tallyAccountWater.setAccountId(account.getId());//不指定账户
        tallyAccountWaterMapper.insertSelective(tallyAccountWater);
        /**
         * 保存明细
         */
        TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
        detail.setNumber(0);
        detail.setPerPrice(BigDecimal.ZERO);
        detail.setProductId(0);
        detail.setProductSpecId(0);
        detail.setInOutTypeName(btype.getTypeName());
        detail.setInOutType(btype.getType());
        detail.setProductSpecName("其他");
        detail.setAmount(tallyAccountWater.getAmount());
        detail.setRemark(tallyAccountWater.getRemark());
        detail.setWaterId(tallyAccountWater.getId());
        tallyAccountWaterDetailMapper.insertSelective(detail);
        return tallyAccountWater.getId();
    }
}