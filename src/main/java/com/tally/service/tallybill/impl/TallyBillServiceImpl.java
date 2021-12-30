package com.tally.service.tallybill.impl;

import com.tally.api.inputDto.AddBillInputDto;
import com.tally.api.inputDto.AddCollectionInputDto;
import com.tally.api.inputDto.AddCollectionShInputDto;
import com.tally.api.inputDto.BillDetailInputDto;
import com.tally.api.outputDto.TallyBillOutputDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallybill.TallyBillMapper;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybill.model.TallyBillExample;
import com.tally.dao.tallybilldetail.TallyBillDetailMapper;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.service.tallyaccountwater.TallyAccountWaterService;
import com.tally.service.tallybill.TallyBillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tally.service.tallyorder.TallyOrderService;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import com.tally.service.tallyuser.TallyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * 账单表Service实现
 * @author 131****2893
 * @date 2021/04/12 13:43
 */
@Service
public class TallyBillServiceImpl implements TallyBillService {

    @Autowired
    private TallyBillMapper tallyBillMapper;
     @Autowired
    private TallyBillDetailMapper tallyBillDetailMapper;
    @Autowired
    private TallyUserService tallyUserService;
    @Autowired
    private TallyAccountWaterService tallyAccountWaterService;
    @Autowired
    private TallyOrderService tallyOrderService;
    @Autowired
    private TallyProductSpecService tallyProductSpecService;


    @Override
    public Integer create(TallyBill tallyBill) {
        tallyBillMapper.insertSelective(tallyBill);
        return tallyBill.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyBill tallyBill) {
        tallyBillMapper.updateByPrimaryKeySelective(tallyBill);
    }

    @Override
    public void updateByIdInBatch(List<TallyBill> tallyBills) {
        if (CollectionUtils.isEmpty(tallyBills)) return;
        for (TallyBill tallyBill: tallyBills) {
            this.updateById(tallyBill);
        }
    }

    @Override
    public TallyBill findById(Integer id) {
        return tallyBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyBill findOne(TallyBill tallyBill) {
        ExampleBuilder<TallyBillExample, TallyBillExample.Criteria> builder = ExampleBuilder.create(TallyBillExample.class, TallyBillExample.Criteria.class);
        List<TallyBill> tallyBills = tallyBillMapper.selectByExample(builder.buildExamplePack(tallyBill).getExample());
        if (tallyBills.size() > 0) {
            return tallyBills.get(0);
        }
        return null;
    }

    @Override
    public List<TallyBill> findList(TallyBill tallyBill) {
        ExampleBuilder<TallyBillExample, TallyBillExample.Criteria> builder = ExampleBuilder.create(TallyBillExample.class, TallyBillExample.Criteria.class);
        return tallyBillMapper.selectByExample(builder.buildExamplePack(tallyBill).getExample());
    }
  
    @Override
    public PageData<TallyBill> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyBillExample, TallyBillExample.Criteria> builder = ExampleBuilder.create(TallyBillExample.class, TallyBillExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyBillExample, TallyBillExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyBillMapper.selectByExample(pack.getExample())));
    }
    @Override
    public PageData<TallyBill> findPage(List userIdList, List btypeUserMobileList, TallyBill bill, Integer page) {
        PageHelper.startPage(page,10);
        List<TallyBill> list = tallyBillMapper.findList(bill,userIdList,btypeUserMobileList);
        return PageData.from(new PageInfo<>(list));
    }

    @Override
    public PageData<TallyBill> billCollectPage(TallyBill bill, Integer page) {
        PageHelper.startPage(page,10);
        List<TallyBill> list = tallyBillMapper.billCollectList(bill);
        return PageData.from(new PageInfo<>(list));
    }

    @Override
    public Integer updateByVersion(TallyBill bill) {
        return tallyBillMapper.updateByVersion(bill);
    }

    @Override
    public long count(TallyBill tallyBill) {
        ExampleBuilder<TallyBillExample, TallyBillExample.Criteria> builder = ExampleBuilder.create(TallyBillExample.class, TallyBillExample.Criteria.class);
        return tallyBillMapper.countByExample(builder.buildExamplePack(tallyBill).getExample());
    }

    @Override
    public Integer addBill(AddBillInputDto addBillInputDto) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        if(addBillInputDto.getIsMaterial()==0){
                   totalPrice = addBillInputDto.getProductSpecList().stream().map(BillDetailInputDto::getAmount).reduce(BigDecimal::add).get();
        }
        Integer totalNumber = addBillInputDto.getProductSpecList().stream().map(BillDetailInputDto::getNumber).reduce(0, (a, b) -> a + b);
        //保存账单表数据
        TallyBill bill = new TallyBill();
        bill.setBtypeUserId(addBillInputDto.getBtypeUserId());
        bill.setBtypeUserName(addBillInputDto.getBtypeUserName());
        bill.setDealTime(addBillInputDto.getDealTime());
        bill.setSettleAmount(addBillInputDto.getTotalSettleAmount());
        bill.setTotalPrice(totalPrice);
        bill.setRemark(addBillInputDto.getRemark());
        bill.setUserId(addBillInputDto.getUserId());
        bill.setType(addBillInputDto.getType());
        bill.setBtypeMobile(addBillInputDto.getBtypeMobile());
        bill.setIsMaterial(addBillInputDto.getIsMaterial()!=null?addBillInputDto.getIsMaterial():0);
        bill.setTotalNumber(totalNumber);
        TallyUser user = tallyUserService.findById(addBillInputDto.getUserId());
        bill.setUserMobile(user.getMobile());
        bill.setUserName(StringUtils.isEmpty(user.getName())?user.getMobile():user.getName());
        tallyBillMapper.insertSelective(bill);
        if(!CollectionUtils.isEmpty(addBillInputDto.getProductSpecList())){
            List batchList = new ArrayList<TallyBillDetail>();
            for (BillDetailInputDto in:addBillInputDto.getProductSpecList()) {
                TallyBillDetail detail = new TallyBillDetail();
                detail.setNumber(in.getNumber());
                detail.setSettleNumber(0);
                detail.setPerPrice(in.getSpecPrice());
                detail.setProductId(in.getProductId());
                detail.setProductSpecId(in.getSpecId());
                detail.setProductSpecName(in.getName());
                detail.setAmount(in.getAmount());
                detail.setSettleAmount(in.getSettledAmount());
                detail.setInOutType(addBillInputDto.getType());
                detail.setInOutTypeId(0);
                detail.setInOutTypeName(addBillInputDto.getType().equals(100)?"收入":"支出");
                detail.setBillId(bill.getId());
                batchList.add(detail);
            }
            if(!CollectionUtils.isEmpty(batchList))
                tallyBillDetailMapper.insertBatch(batchList);
        }
        return bill.getId();
    }

    @Override
    public Integer addCollection(AddCollectionInputDto addBillInputDto) {
        //保存账单表数据
        TallyBill bill = new TallyBill();
        bill.setBtypeUserId(addBillInputDto.getBtypeUserId());
        bill.setBtypeUserName(addBillInputDto.getBtypeUserName());
        bill.setDealTime(addBillInputDto.getDealTime());
        bill.setSettleAmount(BigDecimal.ZERO);
        bill.setTotalPrice(addBillInputDto.getAmount());
        bill.setRemark(addBillInputDto.getRemark());
        bill.setUserId(addBillInputDto.getUserId());
        bill.setType(addBillInputDto.getType());
        TallyUser bTypeUser = tallyUserService.findById(addBillInputDto.getBtypeUserId());
        bill.setBtypeMobile(bTypeUser.getMobile());
        if(StringUtils.isEmpty(bill.getBtypeUserName())){
            if(StringUtils.isEmpty(bTypeUser.getName())){
                bill.setBtypeUserName(bTypeUser.getMobile());
            }else{
                bill.setBtypeUserName(bTypeUser.getName());
            }
        }
        bill.setIsMaterial(addBillInputDto.getIsMaterial());
        bill.setTotalNumber(0);
        TallyUser user = tallyUserService.findById(addBillInputDto.getUserId());
        bill.setUserMobile(user.getMobile());
        bill.setUserName(StringUtils.isEmpty(user.getName())?user.getMobile():user.getName());
        tallyBillMapper.insertSelective(bill);
        return bill.getId();
    }

    @Override
    public Integer addCollectionSh(AddCollectionShInputDto addBillInputDto) {
        //保存账单表数据
        TallyBill bill = new TallyBill();
        bill.setBtypeUserId(addBillInputDto.getBtypeUserId());
        bill.setBtypeUserName(addBillInputDto.getBtypeUserName());
        bill.setDealTime(addBillInputDto.getDealTime());
        bill.setSettleAmount(BigDecimal.ZERO);
        bill.setTotalPrice(addBillInputDto.getAmount());
        bill.setRemark(addBillInputDto.getRemark());
        bill.setUserId(addBillInputDto.getUserId());
        bill.setType(addBillInputDto.getType());
        bill.setTotalNumber(addBillInputDto.getNumber());
        bill.setSettleNumber(0);
        TallyUser bTypeUser = tallyUserService.findById(addBillInputDto.getBtypeUserId());
        bill.setBtypeMobile(bTypeUser.getMobile());
        if(StringUtils.isEmpty(bill.getBtypeUserName())){
            if(StringUtils.isEmpty(bTypeUser.getName())){
                bill.setBtypeUserName(bTypeUser.getMobile());
            }else{
                bill.setBtypeUserName(bTypeUser.getName());
            }
        }
        bill.setIsMaterial(addBillInputDto.getIsMaterial());
        TallyUser user = tallyUserService.findById(addBillInputDto.getUserId());
        bill.setUserMobile(user.getMobile());
        bill.setUserName(StringUtils.isEmpty(user.getName())?user.getMobile():user.getName());
        tallyBillMapper.insertSelective(bill);
        //明细
        TallyBillDetail tallyBillDetail = new TallyBillDetail();
        tallyBillDetail.setBillId(bill.getId());
        tallyBillDetail.setNumber(addBillInputDto.getNumber());
        tallyBillDetail.setSettleNumber(0);
        tallyBillDetail.setInOutType(0);
        tallyBillDetail.setInOutTypeId(0);
        tallyBillDetail.setInOutTypeName("其他");
        tallyBillDetail.setProductId(addBillInputDto.getProductId());
        tallyBillDetail.setProductSpecId(addBillInputDto.getProductSpecId());
        tallyBillDetail.setProductSpecName(addBillInputDto.getProductSpecName());
        tallyBillDetailMapper.insert(tallyBillDetail);
        return bill.getId();
    }

    @Override
    public PageData<TallyBill> findMaterialPage(Integer page, String userId, Integer status, Integer type, Integer btypeUserId) {
        PageHelper.startPage(page,10);
        List<TallyBill> list = getMaterialTallyBills(userId, status, type, btypeUserId);
        return PageData.from(new PageInfo<>(list));
    }

    @Override
    public List<TallyBill> getMaterialTallyBills(String userId, Integer status, Integer type, Integer btypeUserId) {
        Integer type1 = null;
        Integer type2 = null;
        if(null!=type && type==100){
            type1 = 100;
            type2 = 101;
        }else if(null!=type && type==101){
            type1 = 101;
            type2 = 100;
        }
        return tallyBillMapper.findMaterialList(userId,type1,type2,status,btypeUserId);
    }

    @Override
    public PageData<TallyBill> findMaterialCollectPage(Integer page, String userId, Integer status, Integer type) {
        PageHelper.startPage(page,10);
        Integer type1 = null;
        Integer type2 = null;
        if(null!=type && type==100){
            type1 = 100;
            type2 = 101;
        }else if(null!=type && type==101){
            type1 = 101;
            type2 = 100;
        }
        List<TallyBill> list = tallyBillMapper.findMaterialCollectList(userId,type1,type2,status);
        return PageData.from(new PageInfo<>(list));
    }

    @Override
    public TallyBillOutputDto findBill(TallyBill tallyBill) {
        TallyBill bill = tallyBillMapper.selectByPrimaryKey(tallyBill.getId());
        TallyBillOutputDto dto = new TallyBillOutputDto();
        dto.setId(bill.getId());
        dto.setAuitStatus(bill.getAuitStatus());
        dto.setBtypeUserId(bill.getBtypeUserId());
        dto.setBtypeUserName(bill.getBtypeUserName());
        dto.setDealTime(bill.getDealTime());
        dto.setRemark(bill.getRemark());
        dto.setStatus(bill.getStatus());
        dto.setTotalPrice(bill.getTotalPrice());
        dto.setSettleAmount(bill.getSettleAmount());
        dto.setUserId(bill.getUserId());
        dto.setType(bill.getType());
        dto.setUserName(bill.getUserName());
        dto.setIsMaterial(bill.getIsMaterial());
        dto.setTotalNumber(bill.getTotalNumber());
        dto.setSettleNumber(bill.getSettleNumber());
        dto.setCreateTime(bill.getCreateTime());
        if(null!=bill.getOperator()){
            TallyUser user = tallyUserService.findById(bill.getOperator());
            String operator = user.getMobile();
            if(!StringUtils.isEmpty(user.getName())){
                operator = user.getName();
            }
            dto.setOperator(operator);
        }
        //如果当前客户和bill订单的userId不一致，用户信息反转
//        if(bill.getUserId()!=tallyBill.getUserId()){
//            TallyUser user = tallyUserService.findById(bill.getUserId());
//            TallyUser btUser = tallyUserService.findById(tallyBill.getUserId());
//            dto.setUserMobile(btUser.getMobile());
//            dto.setBtypeUserName(StringUtils.isEmpty(user.getName())?user.getMobile():user.getName());
//        }
        List<TallyBillDetail> list = tallyBillDetailMapper.findByBillId(bill.getId());
        dto.setDetailList(list);
        return dto;
    }

    @Override
    public List<TallyBill> findListByIds( String ids,String userId) {
        List<String> list =  Arrays.asList(ids.split(","));
        return tallyBillMapper.findListByIds(list,userId);
    }

    @Override
    @Transactional
    public void auitBill(String userId, Integer status, String ids) throws Exception {
        List<String> list =  Arrays.asList(ids.split(","));
        if(list.size()==0)
            return;

        // 如果账单确认则生成账单流水以及明细
        if(status==101){//确认通过
            for (String id: list) {
                TallyBill bill = this.findById(Integer.valueOf(id));
                if(bill.getUserId().equals(Integer.valueOf(userId))){
                    throw new Exception("不能审核自己的订单！");
                }
                if(bill.getAuitStatus()!=100){
                    continue;
                }
                TallyBill b = new TallyBill();
                b.setId(bill.getId());
                b.setAuitStatus(status);
                //如果结算金额等于总金额，那么结算完成
                if(bill.getTotalPrice().compareTo(bill.getSettleAmount())==0&&bill.getIsMaterial()==0){
                    b.setStatus(101);
                }
                if(bill.getTotalNumber()>0&&bill.getTotalNumber().equals(bill.getSettleNumber())&&bill.getIsMaterial()==1){
                    b.setStatus(101);
                }
                b.setOperator(Integer.valueOf(userId));
                b.setVersion(bill.getVersion());
                Integer ver = this.updateByVersion(b);
                if(ver==0){
                    continue;
                }
                //根据账单和账单明细生成账单流水
                Integer type = bill.getType();
                if(bill.getIsMaterial()==0){//非物料
                    if(100==type||101==type){//买入卖出
                        //保存流水
                        tallyAccountWaterService.saveByBill(bill);
                        //保存对应订单
                        Integer type1 = 100;
                        Integer type2 = 102;
                        if(bill.getType()==101){
                            type1=102;
                            type2=100;
                        }
                        tallyOrderService.saveByBill(bill,bill.getUserId(),bill.getBtypeUserId(),bill.getBtypeUserName(),type1,false);
//                        //创建对方相反订单
                        tallyOrderService.saveByBill(bill,bill.getBtypeUserId(),bill.getUserId(),bill.getUserName(),type2,true);
                    }else if(102==type||103==type){//收款还款
                        tallyAccountWaterService.saveCollection(bill);
                    }
                }else if(bill.getIsMaterial()==1){//物料
                    if(100==type||101==type){//借入借出
                        //出入库
//                        tallyProductSpecService.updateStorageByMaterialBill(userId,bill);
                    }else if(102==type||103==type){//物料收还
                        //出入库
//                        tallyProductSpecService.updateStorageByMaterialBill(userId,bill);
                          //变更账单
                          this.updateMaterialSettled(bill);
                    }
                }
            }
        }else{//审核不通过
            for (String id:list) {
                TallyBill bill = this.findById(Integer.valueOf(id));
                if(bill.getStatus()!=100){
                    continue;
                }
                TallyBill b = new TallyBill();
                b.setId(bill.getId());
                b.setAuitStatus(status);
                b.setOperator(Integer.valueOf(userId));
                tallyBillMapper.updateByPrimaryKeySelective(b);
            }
        }
    }

    private void updateMaterialSettled(TallyBill bill) {
        Integer number = bill.getTotalNumber();
        TallyBillDetail detail = tallyBillDetailMapper.findByBillId(bill.getId()).get(0);
        List<TallyBillDetail> details =  tallyBillDetailMapper.getToSettleDeatials(bill.getUserId(),detail.getProductSpecId());
        for (TallyBillDetail tb :details) {
             Integer unSettleNumber = tb.getNumber()-tb.getSettleNumber();
             if(number>unSettleNumber){
                 number=number-unSettleNumber;
                 handelStroge(tb, unSettleNumber);
             }else if(number<=unSettleNumber){
                 handelStroge(tb, number);
                 break;
             }
        }
    }

    private void handelStroge(TallyBillDetail tb, Integer unSettleNumber) {
        TallyBillDetail b = TallyBillDetail.builder().id(tb.getId()).settleNumber(tb.getSettleNumber() + unSettleNumber).build();
        tallyBillDetailMapper.updateByPrimaryKeySelective(b);
        TallyBill bb = tallyBillMapper.selectByPrimaryKey(tb.getBillId());
        TallyBill bb2 = TallyBill.builder().id(bb.getId()).settleNumber(bb.getSettleNumber() + unSettleNumber).build();
        tallyBillMapper.updateByPrimaryKeySelective(bb2);
    }


    @Override
    public Map<String, String> materialCount(TallyBill bill) {
        Map map = tallyBillMapper.materialCount(bill);
        return map;
    }

    @Override
    public Map<String, String> sfCount(TallyBill bill) {
        Map map = tallyBillMapper.sfCount(bill);
        //应收
        BigDecimal ys = tallyBillMapper.sfCountplus(bill.getUserId(), bill.getBtypeUserId(), 100);
        BigDecimal ysd = tallyBillMapper.sfCountplus(bill.getBtypeUserId(), bill.getUserId(), 101);
        //应付
        BigDecimal yf = tallyBillMapper.sfCountplus(bill.getUserId(), bill.getBtypeUserId(), 101);
        BigDecimal yfd = tallyBillMapper.sfCountplus(bill.getBtypeUserId(), bill.getUserId(), 100);
        map.put("ys",ys.add(ysd));
        map.put("yf",yf.add(yfd));
        return map;
    }
}