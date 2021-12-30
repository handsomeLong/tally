package com.tally.service.tallyworkorderproduct.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyworkorderproduct.TallyWorkOrderProductMapper;
import com.tally.dao.tallyworkorderproduct.model.TallyWorkOrderProduct;
import com.tally.dao.tallyworkorderproduct.model.TallyWorkOrderProductExample;
import com.tally.service.tallyworkorderproduct.TallyWorkOrderProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 任务单Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyWorkOrderProductServiceImpl implements TallyWorkOrderProductService {

    @Autowired
    private TallyWorkOrderProductMapper tallyWorkOrderProductMapper;

    @Override
    public Integer create(TallyWorkOrderProduct tallyWorkOrderProduct) {
        tallyWorkOrderProductMapper.insertSelective(tallyWorkOrderProduct);
        return tallyWorkOrderProduct.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyWorkOrderProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyWorkOrderProduct tallyWorkOrderProduct) {
        tallyWorkOrderProductMapper.updateByPrimaryKeySelective(tallyWorkOrderProduct);
    }

    @Override
    public void updateByIdInBatch(List<TallyWorkOrderProduct> tallyWorkOrderProducts) {
        if (CollectionUtils.isEmpty(tallyWorkOrderProducts)) return;
        for (TallyWorkOrderProduct tallyWorkOrderProduct: tallyWorkOrderProducts) {
            this.updateById(tallyWorkOrderProduct);
        }
    }

    @Override
    public TallyWorkOrderProduct findById(Integer id) {
        return tallyWorkOrderProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyWorkOrderProduct findOne(TallyWorkOrderProduct tallyWorkOrderProduct) {
        ExampleBuilder<TallyWorkOrderProductExample, TallyWorkOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderProductExample.class, TallyWorkOrderProductExample.Criteria.class);
        List<TallyWorkOrderProduct> tallyWorkOrderProducts = tallyWorkOrderProductMapper.selectByExample(builder.buildExamplePack(tallyWorkOrderProduct).getExample());
        if (tallyWorkOrderProducts.size() > 0) {
            return tallyWorkOrderProducts.get(0);
        }
        return null;
    }

    @Override
    public List<TallyWorkOrderProduct> findList(TallyWorkOrderProduct tallyWorkOrderProduct) {
        ExampleBuilder<TallyWorkOrderProductExample, TallyWorkOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderProductExample.class, TallyWorkOrderProductExample.Criteria.class);
        return tallyWorkOrderProductMapper.selectByExample(builder.buildExamplePack(tallyWorkOrderProduct).getExample());
    }
  
    @Override
    public PageData<TallyWorkOrderProduct> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyWorkOrderProductExample, TallyWorkOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderProductExample.class, TallyWorkOrderProductExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyWorkOrderProductExample, TallyWorkOrderProductExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyWorkOrderProductMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyWorkOrderProduct tallyWorkOrderProduct) {
        ExampleBuilder<TallyWorkOrderProductExample, TallyWorkOrderProductExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderProductExample.class, TallyWorkOrderProductExample.Criteria.class);
        return tallyWorkOrderProductMapper.countByExample(builder.buildExamplePack(tallyWorkOrderProduct).getExample());
    }
}