package com.tally.service.tallyproductspec.impl;

import com.tally.api.inputDto.ProductOutAndInDetailDto;
import com.tally.api.inputDto.ProductOutAndInInputDto;
import com.tally.api.inputDto.ProductSpecInputDto;
import com.tally.api.outputDto.ProductSpecOutputDto;
import com.tally.core.enums.OperateTypeEnums;
import com.tally.core.enums.OrderTypeEnums;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyproductspec.TallyProductSpecMapper;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.dao.tallyproductspec.model.TallyProductSpecExample;
import com.tally.dao.tallystoragelog.model.TallyStorageLog;
import com.tally.service.tallybilldetail.TallyBillDetailService;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tally.service.tallystoragelog.TallyStorageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品规格表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyProductSpecServiceImpl implements TallyProductSpecService {

    @Autowired
    private TallyProductSpecMapper tallyProductSpecMapper;
    @Autowired
    private TallyStorageLogService tallyStorageLogService;
    @Autowired
    private TallyBillDetailService tallyBillDetailService;

    @Override
    public Integer create(TallyProductSpec tallyProductSpec) {
        tallyProductSpecMapper.insertSelective(tallyProductSpec);
        return tallyProductSpec.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyProductSpecMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyProductSpec tallyProductSpec) {
        tallyProductSpecMapper.updateByPrimaryKeySelective(tallyProductSpec);
    }

    @Override
    public void updateByIdInBatch(List<TallyProductSpec> tallyProductSpecs) {
        if (CollectionUtils.isEmpty(tallyProductSpecs)) return;
        for (TallyProductSpec tallyProductSpec: tallyProductSpecs) {
            this.updateById(tallyProductSpec);
        }
    }

    @Override
    public TallyProductSpec findById(Integer id) {
        return tallyProductSpecMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyProductSpec findOne(TallyProductSpec tallyProductSpec) {
        ExampleBuilder<TallyProductSpecExample, TallyProductSpecExample.Criteria> builder = ExampleBuilder.create(TallyProductSpecExample.class, TallyProductSpecExample.Criteria.class);
        List<TallyProductSpec> tallyProductSpecs = tallyProductSpecMapper.selectByExample(builder.buildExamplePack(tallyProductSpec).getExample());
        if (tallyProductSpecs.size() > 0) {
            return tallyProductSpecs.get(0);
        }
        return null;
    }

    @Override
    public List<TallyProductSpec> findList(TallyProductSpec tallyProductSpec) {
        ExampleBuilder<TallyProductSpecExample, TallyProductSpecExample.Criteria> builder = ExampleBuilder.create(TallyProductSpecExample.class, TallyProductSpecExample.Criteria.class);
        return tallyProductSpecMapper.selectByExample(builder.buildExamplePack(tallyProductSpec).getExample());
    }
  
    @Override
    public PageData<TallyProductSpec> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyProductSpecExample, TallyProductSpecExample.Criteria> builder = ExampleBuilder.create(TallyProductSpecExample.class, TallyProductSpecExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyProductSpecExample, TallyProductSpecExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyProductSpecMapper.selectByExample(pack.getExample())));
    }

    @Override
    public PageData<ProductSpecOutputDto> findPageWithProduct(PageWrap pageWrap, List userIdList) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        List<ProductSpecOutputDto> list =  tallyProductSpecMapper.findWithProduct(userIdList);
        return PageData.from(new PageInfo<>(list));
    }

    @Override
    public List<TallyProductSpec> findbyIds(String productSpecIds) {
        List<TallyProductSpec> list =  tallyProductSpecMapper.findbyIds(productSpecIds);
        return list;
    }

    @Override
    public void updateStorageByMaterialBill(String userId, TallyBill bill) {
        if(bill.getIsMaterial()==0){
            return;
        }
        Integer type = bill.getType();
        TallyBillDetail bt = new TallyBillDetail();
        bt.setBillId(bill.getId());
        List<TallyBillDetail> list = tallyBillDetailService.findList(bt);
        OperateTypeEnums operateTypeEnums = OperateTypeEnums.MATERIAL_OUT;
        if(type==101){
            operateTypeEnums = OperateTypeEnums.MATERIAL_IN;
        }
        for (TallyBillDetail detail:list) {
            TallyProductSpec tallyProductSpec = tallyProductSpecMapper.selectByPrimaryKey(detail.getProductSpecId());
            TallyProductSpec newTallyProductSpec = new TallyProductSpec();
            newTallyProductSpec.setId(tallyProductSpec.getId());
            if(type==100){
                newTallyProductSpec.setSpecStorage(tallyProductSpec.getSpecStorage()-detail.getNumber());
            }else if(type==101){
                newTallyProductSpec.setSpecStorage(tallyProductSpec.getSpecStorage()+detail.getNumber());
            }
            tallyProductSpecMapper.updateByPrimaryKeySelective(newTallyProductSpec);
            this.saveStorageLog(operateTypeEnums,bill.getUserId(),Integer.valueOf(userId),
                    detail.getNumber(),tallyProductSpec.getSpecStorage(),newTallyProductSpec.getSpecStorage(),
                    detail.getProductId(),detail.getProductSpecName(),detail.getProductId()+"",
                    detail.getProductSpecId(),bill.getRemark(),detail.getId());
        }
    }

    @Override
    public TallyProductSpec findByUserId(Integer userId, TallyProductSpec spec) {
        List<TallyProductSpec> list = tallyProductSpecMapper.findByUserId(userId,spec);
        if(list.size()>0){
            return  list.get(0);
        }
        return null;
    }

    @Override
    public long count(TallyProductSpec tallyProductSpec) {
        ExampleBuilder<TallyProductSpecExample, TallyProductSpecExample.Criteria> builder = ExampleBuilder.create(TallyProductSpecExample.class, TallyProductSpecExample.Criteria.class);
        return tallyProductSpecMapper.countByExample(builder.buildExamplePack(tallyProductSpec).getExample());
    }

    @Override
    public void updateFreezeStorage(ProductOutAndInInputDto productOutAndInInputDto) {
        if(null!=productOutAndInInputDto&&!CollectionUtils.isEmpty(productOutAndInInputDto.getList())){
            for (ProductOutAndInDetailDto dto :productOutAndInInputDto.getList()) {
                Integer specId = Integer.valueOf(dto.getSpecId());
                TallyProductSpec productSpec = tallyProductSpecMapper.selectByPrimaryKey(specId);
                Integer freezeNum = Integer.valueOf(dto.getNumber());
                TallyProductSpec tallyProductSpec = new TallyProductSpec();
                tallyProductSpec.setId(specId);
                tallyProductSpec.setSpecStorage(productSpec.getSpecStorage()-freezeNum);
                tallyProductSpec.setSpecStorageFreeze(productSpec.getSpecStorageFreeze()+freezeNum);
                tallyProductSpecMapper.updateByPrimaryKeySelective(tallyProductSpec);
            }
        }
    }

    @Override
    public void saveBatch(List<ProductSpecInputDto> specList, Integer productId) {
            if(!CollectionUtils.isEmpty(specList)){
                List<TallyProductSpec> list = new ArrayList<TallyProductSpec>();
                for (ProductSpecInputDto in:specList) {
                     TallyProductSpec spec = new TallyProductSpec();
                     spec.setProductId(productId);
                     spec.setSpecStorage(in.getSpecStorage());
                     spec.setSpecName(in.getSpecName());
                     spec.setSpecSerial(in.getSpecSerial());
                     spec.setSpecImages(in.getSpecImages());
                     spec.setSpecCostPrice(in.getSpecCostPrice());
                     spec.setSpecPrice(in.getSpecPrice());
                     spec.setSpecStockPrice(in.getSpecStockPrice());
                     spec.setRemark(in.getRemark());
                     spec.setSpecUnit(in.getSpecUnit());
                     list.add(spec);
                }
                tallyProductSpecMapper.insertBatch(list);
            }
    }

    @Override
    public void updateStorageByOrderProduct(TallyOrder tallyOrder, List<TallyOrderProduct> list) {
        OrderTypeEnums typeEnums = OrderTypeEnums.getEnum(tallyOrder.getOrderType());
        OperateTypeEnums operateTypeEnums = OperateTypeEnums.SALES;
        for (TallyOrderProduct orderProduct:list) {
            TallyProductSpec tallyProductSpec = tallyProductSpecMapper.selectByPrimaryKey(orderProduct.getProductSpecId());
            TallyProductSpec newTallyProductSpec = new TallyProductSpec();
            newTallyProductSpec.setId(tallyProductSpec.getId());
            if(typeEnums==OrderTypeEnums.SALES){
                newTallyProductSpec.setSpecStorage(tallyProductSpec.getSpecStorage()-orderProduct.getSpecNum());
            }else if(typeEnums==OrderTypeEnums.PURCHASE_RETURN){
                newTallyProductSpec.setSpecStorage(tallyProductSpec.getSpecStorage()-orderProduct.getSpecNum());
                operateTypeEnums=OperateTypeEnums.PURCHASE_RETURN;
            }else if(typeEnums==OrderTypeEnums.PURCHASE){
                newTallyProductSpec.setSpecStorage(tallyProductSpec.getSpecStorage()+orderProduct.getSpecNum());
                operateTypeEnums = OperateTypeEnums.PURCHASE;
            }else if(typeEnums==OrderTypeEnums.SALES_RETURN){
                newTallyProductSpec.setSpecStorage(tallyProductSpec.getSpecStorage()+orderProduct.getSpecNum());
                operateTypeEnums=OperateTypeEnums.SALES_RETURN;
            }
            tallyProductSpecMapper.updateByPrimaryKeySelective(newTallyProductSpec);
            this.saveStorageLog(operateTypeEnums,tallyOrder.getUserId(),tallyOrder.getUserId(),
                    orderProduct.getSpecNum(),tallyProductSpec.getSpecStorage(),newTallyProductSpec.getSpecStorage(),
                    orderProduct.getProductId(),orderProduct.getProductName(),orderProduct.getProductNo(),
                    orderProduct.getProductSpecId(),tallyOrder.getRemark(),tallyOrder.getId());
        }

    }
    private void saveStorageLog(OperateTypeEnums operateTypeEnums,Integer userId,Integer operateUserId,
                                       Integer storage,Integer beforeStorage,Integer afterStorage,Integer productId,
                                       String productName,String productNo,Integer specId,String remark,Integer relateId){
        TallyStorageLog log = new TallyStorageLog();
        log.setUserId(userId);
        log.setStorage(storage);
        log.setBeforeStorage(beforeStorage);
        log.setAfterStorage(afterStorage);
        log.setOperateType(operateTypeEnums.getRetCode());
        log.setOperateTypeName(operateTypeEnums.getRetMsg());
        log.setOperateUserId(operateUserId);
        log.setProductId(productId);
        log.setProductName(productName);
        log.setProductNo(productNo);
        log.setRelateId(relateId);
        log.setRemark(remark);
        log.setSpecId(specId);
        tallyStorageLogService.create(log);
    }
}