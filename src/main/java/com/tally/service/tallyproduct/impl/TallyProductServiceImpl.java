package com.tally.service.tallyproduct.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tally.api.inputDto.*;
import com.tally.api.outputDto.ProductOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyproduct.TallyProductMapper;
import com.tally.dao.tallyproduct.model.TallyProduct;
import com.tally.dao.tallyproduct.model.TallyProductExample;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.dao.tallystorageauit.TallyStorageAuitMapper;
import com.tally.dao.tallystorageauit.model.TallyStorageAuit;
import com.tally.service.tallyproduct.TallyProductService;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import com.tally.service.tallystorageauit.TallyStorageAuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 产品表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyProductServiceImpl implements TallyProductService {

    @Autowired
    private TallyProductMapper tallyProductMapper;
    @Autowired
    private TallyStorageAuitMapper tallyStorageAuitMapper;
    @Autowired
    private TallyStorageAuitService tallyStorageAuitService;
    @Autowired
    private TallyProductSpecService tallyProductSpecService;

    @Override
    public Integer create(TallyProduct tallyProduct) {
        tallyProductMapper.insertSelective(tallyProduct);
        return tallyProduct.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyProduct tallyProduct) {
        tallyProductMapper.updateByPrimaryKeySelective(tallyProduct);
    }

    @Override
    public void updateByIdInBatch(List<TallyProduct> tallyProducts) {
        if (CollectionUtils.isEmpty(tallyProducts)) return;
        for (TallyProduct tallyProduct: tallyProducts) {
            this.updateById(tallyProduct);
        }
    }

    @Override
    public ProductOutputDto findById(Integer id) {
        return tallyProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public ProductOutputDto findOne(TallyProduct tallyProduct) {
        ExampleBuilder<TallyProductExample, TallyProductExample.Criteria> builder = ExampleBuilder.create(TallyProductExample.class, TallyProductExample.Criteria.class);
        List<ProductOutputDto> tallyProducts = tallyProductMapper.selectByExample(builder.buildExamplePack(tallyProduct).getExample());
        if (tallyProducts.size() > 0) {
            return tallyProducts.get(0);
        }
        return null;
    }

    @Override
    public List<ProductOutputDto> findList(TallyProduct tallyProduct) {
        ExampleBuilder<TallyProductExample, TallyProductExample.Criteria> builder = ExampleBuilder.create(TallyProductExample.class, TallyProductExample.Criteria.class);
        return tallyProductMapper.selectByExample(builder.buildExamplePack(tallyProduct).getExample());
    }
  
    @Override
    public PageData<ProductOutputDto> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyProductExample, TallyProductExample.Criteria> builder = ExampleBuilder.create(TallyProductExample.class, TallyProductExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyProductExample, TallyProductExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyProductMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyProduct tallyProduct) {
        ExampleBuilder<TallyProductExample, TallyProductExample.Criteria> builder = ExampleBuilder.create(TallyProductExample.class, TallyProductExample.Criteria.class);
        return tallyProductMapper.countByExample(builder.buildExamplePack(tallyProduct).getExample());
    }

    @Override
    public ApiResponse addProduct(AddProductInputDto addProductInputDto, String userId) {
        ApiResponse apiResponse = ApiResponse.failed("添加失败！");
        try {
            // 保存产品
            TallyProduct tallyProduct = new TallyProduct();
            tallyProduct.setUserId(Integer.valueOf(userId));
            tallyProduct.setName(addProductInputDto.getName());
            tallyProduct.setProductDescription(addProductInputDto.getProductDescription());
            tallyProduct.setProductImages(addProductInputDto.getProductImages());
            tallyProduct.setProductNo(addProductInputDto.getProductNo());
            tallyProduct.setRemark(addProductInputDto.getRemark());
            tallyProductMapper.insertSelective(tallyProduct);
            addProductInputDto.setProductId(tallyProduct.getId());
            //保存规格
            for (ProductSpecInputDto specInputDto:addProductInputDto.getSpecList()) {
                TallyProductSpec tallyProductSpec = new TallyProductSpec();
                tallyProductSpec.setProductId(tallyProduct.getId());
                tallyProductSpec.setSpecName(specInputDto.getSpecName());
                tallyProductSpec.setSpecPrice(specInputDto.getSpecPrice());
                tallyProductSpec.setSpecSerial(specInputDto.getSpecSerial());
                tallyProductSpec.setSpecImages(specInputDto.getSpecImages());
                tallyProductSpec.setRemark(specInputDto.getRemark());
                tallyProductSpec.setSpecStorage(specInputDto.getSpecStorage());
                tallyProductSpec.setSpecCostPrice(specInputDto.getSpecCostPrice());
                tallyProductSpec.setSpecStockPrice(specInputDto.getSpecStockPrice());
                tallyProductSpecService.create(tallyProductSpec);
                specInputDto.setSpecId(tallyProductSpec.getId());
            }
//            tallyProductSpecService.saveBatch(addProductInputDto.getSpecList(),tallyProduct.getId());
            apiResponse.setData(addProductInputDto);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setMessage("添加异常！");
        }
        return apiResponse;
    }
    @Override
    public AddProductInputDto addProductPlus(AddProductInputDto addProductInputDto, String userId) {

        try {
            // 保存产品
            TallyProduct tallyProduct = new TallyProduct();
            tallyProduct.setUserId(Integer.valueOf(userId));
            tallyProduct.setName(addProductInputDto.getName());
            tallyProduct.setProductDescription(addProductInputDto.getProductDescription());
            tallyProduct.setProductImages(addProductInputDto.getProductImages());
            tallyProduct.setProductNo(addProductInputDto.getProductNo());
            tallyProduct.setRemark(addProductInputDto.getRemark());
            tallyProductMapper.insertSelective(tallyProduct);
            addProductInputDto.setProductId(tallyProduct.getId());
            //保存规格
            for (ProductSpecInputDto specInputDto:addProductInputDto.getSpecList()) {
                TallyProductSpec tallyProductSpec = new TallyProductSpec();
                tallyProductSpec.setProductId(tallyProduct.getId());
                tallyProductSpec.setSpecName(specInputDto.getSpecName());
                tallyProductSpec.setSpecPrice(specInputDto.getSpecPrice());
                tallyProductSpec.setSpecSerial(specInputDto.getSpecSerial());
                tallyProductSpec.setSpecImages(specInputDto.getSpecImages());
                tallyProductSpec.setRemark(specInputDto.getRemark());
                tallyProductSpec.setSpecStorage(specInputDto.getSpecStorage());
                tallyProductSpec.setSpecCostPrice(specInputDto.getSpecCostPrice());
                tallyProductSpec.setSpecStockPrice(specInputDto.getSpecStockPrice());
                tallyProductSpecService.create(tallyProductSpec);
                specInputDto.setSpecId(tallyProductSpec.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addProductInputDto;
    }

    @Override
    public ApiResponse addProductSpec(AddProductSpecInputDto addProductSpecInputDto, String userId) {
        return null;
    }

    @Override
    public ApiResponse productOutAndIn(ProductOutAndInInputDto productOutAndInInputDto, String userId) {
        ApiResponse apiResponse = ApiResponse.failed();
        try {
            //插入出入库审核表
            TallyStorageAuit tallyStorageAuit = new TallyStorageAuit();
            tallyStorageAuit.setProductId(productOutAndInInputDto.getProductId());
            tallyStorageAuit.setProductName(productOutAndInInputDto.getProductName());
            tallyStorageAuit.setProductNo(productOutAndInInputDto.getProductNo());
            List<ProductOutAndInDetailDto> list = productOutAndInInputDto.getList();
            String specIds = list.stream().map(ProductOutAndInDetailDto::getSpecId).collect(Collectors.joining(","));
            String numbers = list.stream().map(ProductOutAndInDetailDto::getNumber).collect(Collectors.joining(","));
            tallyStorageAuit.setProductSpecIds(specIds);
            tallyStorageAuit.setProductSpecNum(numbers);
            tallyStorageAuit.setProductNum(productOutAndInInputDto.getProductNum());
            tallyStorageAuit.setType(productOutAndInInputDto.getType());
            tallyStorageAuit.setStatus(100);
            tallyStorageAuit.setApplyUserId(Integer.valueOf(userId));
            //如果是出库，则冻结产品库存
            if(101==productOutAndInInputDto.getType()){//出库,冻结库存
                tallyProductSpecService.updateFreezeStorage(productOutAndInInputDto);
            }
            tallyStorageAuitMapper.insertSelective(tallyStorageAuit);
            tallyStorageAuitService.storageAuitSuccess(101,Integer.valueOf(userId),tallyStorageAuit);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("处理成功！");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setMessage("处理异常！");
        }
        return apiResponse;
    }

    @Override
    public BigDecimal getStockBalance(String userId) {
        return tallyProductMapper.getStockBalance(userId);
    }
}