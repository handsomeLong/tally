package com.tally.service.tallystorageauit.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tally.core.enums.OperateTypeEnums;
import com.tally.core.enums.OrderTypeEnums;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.dao.tallystorageauit.TallyStorageAuitMapper;
import com.tally.dao.tallystorageauit.model.TallyStorageAuit;
import com.tally.dao.tallystorageauit.model.TallyStorageAuitExample;
import com.tally.dao.tallystoragelog.model.TallyStorageLog;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import com.tally.service.tallystorageauit.TallyStorageAuitService;
import com.tally.service.tallystoragelog.TallyStorageLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 出入库审核表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyStorageAuitServiceImpl implements TallyStorageAuitService {

    @Autowired
    private TallyStorageAuitMapper tallyStorageAuitMapper;
    @Autowired
    private TallyProductSpecService tallyProductSpecService;
    @Autowired
    private TallyStorageLogService tallyStorageLogService;

    @Override
    public Integer create(TallyStorageAuit tallyStorageAuit) {
        tallyStorageAuitMapper.insertSelective(tallyStorageAuit);
        return tallyStorageAuit.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyStorageAuitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyStorageAuit tallyStorageAuit) {
        tallyStorageAuitMapper.updateByPrimaryKeySelective(tallyStorageAuit);
    }

    @Override
    public void updateByIdInBatch(List<TallyStorageAuit> tallyStorageAuits) {
        if (CollectionUtils.isEmpty(tallyStorageAuits)) return;
        for (TallyStorageAuit tallyStorageAuit: tallyStorageAuits) {
            this.updateById(tallyStorageAuit);
        }
    }

    @Override
    public TallyStorageAuit findById(Integer id) {
        return tallyStorageAuitMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyStorageAuit findOne(TallyStorageAuit tallyStorageAuit) {
        ExampleBuilder<TallyStorageAuitExample, TallyStorageAuitExample.Criteria> builder = ExampleBuilder.create(TallyStorageAuitExample.class, TallyStorageAuitExample.Criteria.class);
        List<TallyStorageAuit> tallyStorageAuits = tallyStorageAuitMapper.selectByExample(builder.buildExamplePack(tallyStorageAuit).getExample());
        if (tallyStorageAuits.size() > 0) {
            return tallyStorageAuits.get(0);
        }
        return null;
    }

    @Override
    public List<TallyStorageAuit> findList(TallyStorageAuit tallyStorageAuit) {
        ExampleBuilder<TallyStorageAuitExample, TallyStorageAuitExample.Criteria> builder = ExampleBuilder.create(TallyStorageAuitExample.class, TallyStorageAuitExample.Criteria.class);
        return tallyStorageAuitMapper.selectByExample(builder.buildExamplePack(tallyStorageAuit).getExample());
    }
  
    @Override
    public PageData<TallyStorageAuit> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyStorageAuitExample, TallyStorageAuitExample.Criteria> builder = ExampleBuilder.create(TallyStorageAuitExample.class, TallyStorageAuitExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyStorageAuitExample, TallyStorageAuitExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyStorageAuitMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyStorageAuit tallyStorageAuit) {
        ExampleBuilder<TallyStorageAuitExample, TallyStorageAuitExample.Criteria> builder = ExampleBuilder.create(TallyStorageAuitExample.class, TallyStorageAuitExample.Criteria.class);
        return tallyStorageAuitMapper.countByExample(builder.buildExamplePack(tallyStorageAuit).getExample());
    }

    @Override
    public void saveByOrder(TallyOrder tallyOrder,List<TallyOrderProduct> list) {
        //保存出入库审核记录
        TallyStorageAuit tallyStorageAuit = new TallyStorageAuit();
        OrderTypeEnums typeEnums = OrderTypeEnums.getEnum(tallyOrder.getOrderType());
        tallyStorageAuit.setProductId(list.get(0).getProductId());
        tallyStorageAuit.setProductNo(list.get(0).getProductNo());
        tallyStorageAuit.setProductName(list.get(0).getProductName());
        tallyStorageAuit.setProductSpecIds(StringUtils.join(list.stream().map(TallyOrderProduct::getProductSpecId).toArray(),","));
        tallyStorageAuit.setProductSpecNum(StringUtils.join(list.stream().map(TallyOrderProduct::getSpecNum).toArray(),","));
        tallyStorageAuit.setOrderId(tallyOrder.getId());
        Integer num = list.stream().mapToInt(TallyOrderProduct::getSpecNum).sum();
        tallyStorageAuit.setProductNum(num);
        tallyStorageAuit.setOrderNo(tallyOrder.getOrderNo());
        if(typeEnums==OrderTypeEnums.SALES){
            tallyStorageAuit.setType(101);
        }else if(typeEnums==OrderTypeEnums.PURCHASE){
            tallyStorageAuit.setType(100);
        }else if(typeEnums==OrderTypeEnums.SALES_RETURN){
            tallyStorageAuit.setType(100);
        }else if(typeEnums==OrderTypeEnums.PURCHASE_RETURN){
            tallyStorageAuit.setType(101);
        }
        tallyStorageAuit.setStatus(100);
        this.create(tallyStorageAuit);
        //库存变动
        tallyProductSpecService.updateStorageByOrderProduct(tallyOrder,list);
    }

    /**
     * 审核通过增加库存流水，减少库存增加流水，拒绝解冻库存
     * @param ids
     * @param status
     */
    @Override
    public void updateAuit(String ids, Integer status,Integer operateUserId) {
         List<TallyStorageAuit>  list =  tallyStorageAuitMapper.findByIds(ids);
         if(101==status){//审核通过
             for (TallyStorageAuit auit:list) {
                 storageAuitSuccess(status, operateUserId, auit);
             }
         }else if(102==status){//拒绝
             for (TallyStorageAuit auit:list) {
                 String specIds = auit.getProductSpecIds();
                 String specNums = auit.getProductSpecNum();
                 List<TallyProductSpec> specList =  tallyProductSpecService.findbyIds(specIds);
                 List<String> specIdList = Arrays.asList(specIds.split(","));
                 List<String> specNumList = Arrays.asList(specNums.split(","));
                 for (TallyProductSpec spec:specList) {
                     int index = specIdList.indexOf(spec.getId()+"");
                     Integer number = Integer.valueOf(specNumList.get(index));
                     TallyProductSpec temp = new TallyProductSpec();
                     temp.setId(spec.getId());
                     if(101==auit.getType()){//出库
                         temp.setSpecStorageFreeze(spec.getSpecStorageFreeze()-number);
                         temp.setSpecStorage(spec.getSpecStorage()+number);
                         tallyProductSpecService.updateById(temp);
                     }
                 }
                 TallyStorageAuit temp = new TallyStorageAuit();
                 temp.setId(auit.getId());
                 temp.setStatus(status);
                 temp.setAuitUserId(operateUserId);
                 tallyStorageAuitMapper.updateByPrimaryKeySelective(temp);
             }
         }

    }

    @Override
    public void storageAuitSuccess(Integer status, Integer operateUserId, TallyStorageAuit auit) {
        String specIds = auit.getProductSpecIds();
        String specNums = auit.getProductSpecNum();
        List<TallyProductSpec> specList =  tallyProductSpecService.findbyIds(specIds);
        List<String> specIdList = Arrays.asList(specIds.split(","));
        List<String> specNumList = Arrays.asList(specNums.split(","));
        for (TallyProductSpec spec:specList) {
            int index = specIdList.indexOf(spec.getId()+"");
            Integer number = Integer.valueOf(specNumList.get(index));
            TallyProductSpec temp = new TallyProductSpec();
            temp.setId(spec.getId());
            OperateTypeEnums operateTypeEnums = OperateTypeEnums.MANUAL_IN;
            Integer before = 0;
            Integer after = 0;
            if(100==auit.getType()){//入库
                   before = spec.getSpecStorage();
                   after = spec.getSpecStorage()+number;
                   temp.setSpecStorage(spec.getSpecStorage()+number);
            }else if(101==auit.getType()){//出库
                  before = spec.getSpecStorage()+number;
                  after = spec.getSpecStorage();
                  temp.setSpecStorageFreeze(spec.getSpecStorageFreeze()-number);
                  operateTypeEnums = OperateTypeEnums.MANUAL_OUT;
            }
            tallyProductSpecService.updateById(temp);
            //保存日志
            this.saveStorageLog(operateTypeEnums,auit.getApplyUserId(),operateUserId,number,before,after,spec);
        }
        TallyStorageAuit temp = new TallyStorageAuit();
        temp.setId(auit.getId());
        temp.setStatus(status);
        temp.setAuitUserId(operateUserId);
        tallyStorageAuitMapper.updateByPrimaryKeySelective(temp);
    }

    private void saveStorageLog(OperateTypeEnums operateTypeEnums, Integer userId, Integer operateUserId,
                                Integer storage, Integer beforeStorage, Integer afterStorage,TallyProductSpec spec){
        TallyStorageLog log = new TallyStorageLog();
        log.setUserId(userId);
        log.setStorage(storage);
        log.setBeforeStorage(beforeStorage);
        log.setAfterStorage(afterStorage);
        log.setOperateType(operateTypeEnums.getRetCode());
        log.setOperateTypeName(operateTypeEnums.getRetMsg());
        log.setOperateUserId(operateUserId);
        log.setProductId(spec.getProductId());
        log.setProductName(spec.getSpecName());
        log.setProductNo("");
        log.setRelateId(0);
        log.setRemark("");
        log.setSpecId(spec.getId());
        tallyStorageLogService.create(log);
    }
}