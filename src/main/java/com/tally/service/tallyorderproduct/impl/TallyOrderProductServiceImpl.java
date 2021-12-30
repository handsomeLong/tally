package com.tally.service.tallyorderproduct.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyorderproduct.TallyOrderProductMapper;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyorderproduct.model.TallyOrderProductExample;
import com.tally.service.tallyorderproduct.TallyOrderProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 订单产品规格关系表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyOrderProductServiceImpl implements TallyOrderProductService {

    @Autowired
    private TallyOrderProductMapper tallyOrderProductMapper;

    @Override
    public Integer create(TallyOrderProduct tallyOrderProduct) {
        tallyOrderProductMapper.insertSelective(tallyOrderProduct);
        return tallyOrderProduct.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyOrderProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyOrderProduct tallyOrderProduct) {
        tallyOrderProductMapper.updateByPrimaryKeySelective(tallyOrderProduct);
    }

    @Override
    public void updateByIdInBatch(List<TallyOrderProduct> tallyOrderProducts) {
        if (CollectionUtils.isEmpty(tallyOrderProducts)) return;
        for (TallyOrderProduct tallyOrderProduct: tallyOrderProducts) {
            this.updateById(tallyOrderProduct);
        }
    }

    @Override
    public TallyOrderProduct findById(Integer id) {
        return tallyOrderProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyOrderProduct findOne(TallyOrderProduct tallyOrderProduct) {
        ExampleBuilder<TallyOrderProductExample, TallyOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyOrderProductExample.class, TallyOrderProductExample.Criteria.class);
        List<TallyOrderProduct> tallyOrderProducts = tallyOrderProductMapper.selectByExample(builder.buildExamplePack(tallyOrderProduct).getExample());
        if (tallyOrderProducts.size() > 0) {
            return tallyOrderProducts.get(0);
        }
        return null;
    }

    @Override
    public List<TallyOrderProduct> findList(TallyOrderProduct tallyOrderProduct) {
        ExampleBuilder<TallyOrderProductExample, TallyOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyOrderProductExample.class, TallyOrderProductExample.Criteria.class);
        return tallyOrderProductMapper.selectByExample(builder.buildExamplePack(tallyOrderProduct).getExample());
    }
  
    @Override
    public PageData<TallyOrderProduct> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyOrderProductExample, TallyOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyOrderProductExample.class, TallyOrderProductExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyOrderProductExample, TallyOrderProductExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyOrderProductMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyOrderProduct tallyOrderProduct) {
        ExampleBuilder<TallyOrderProductExample, TallyOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyOrderProductExample.class, TallyOrderProductExample.Criteria.class);
        return tallyOrderProductMapper.countByExample(builder.buildExamplePack(tallyOrderProduct).getExample());
    }
}