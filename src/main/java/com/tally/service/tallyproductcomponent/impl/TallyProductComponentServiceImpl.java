package com.tally.service.tallyproductcomponent.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyproductcomponent.TallyProductComponentMapper;
import com.tally.dao.tallyproductcomponent.model.TallyProductComponent;
import com.tally.dao.tallyproductcomponent.model.TallyProductComponentExample;
import com.tally.service.tallyproductcomponent.TallyProductComponentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 产品组成表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyProductComponentServiceImpl implements TallyProductComponentService {

    @Autowired
    private TallyProductComponentMapper tallyProductComponentMapper;

    @Override
    public Integer create(TallyProductComponent tallyProductComponent) {
        tallyProductComponentMapper.insertSelective(tallyProductComponent);
        return tallyProductComponent.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyProductComponentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyProductComponent tallyProductComponent) {
        tallyProductComponentMapper.updateByPrimaryKeySelective(tallyProductComponent);
    }

    @Override
    public void updateByIdInBatch(List<TallyProductComponent> tallyProductComponents) {
        if (CollectionUtils.isEmpty(tallyProductComponents)) return;
        for (TallyProductComponent tallyProductComponent: tallyProductComponents) {
            this.updateById(tallyProductComponent);
        }
    }

    @Override
    public TallyProductComponent findById(Integer id) {
        return tallyProductComponentMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyProductComponent findOne(TallyProductComponent tallyProductComponent) {
        ExampleBuilder<TallyProductComponentExample, TallyProductComponentExample.Criteria> builder = ExampleBuilder.create(TallyProductComponentExample.class, TallyProductComponentExample.Criteria.class);
        List<TallyProductComponent> tallyProductComponents = tallyProductComponentMapper.selectByExample(builder.buildExamplePack(tallyProductComponent).getExample());
        if (tallyProductComponents.size() > 0) {
            return tallyProductComponents.get(0);
        }
        return null;
    }

    @Override
    public List<TallyProductComponent> findList(TallyProductComponent tallyProductComponent) {
        ExampleBuilder<TallyProductComponentExample, TallyProductComponentExample.Criteria> builder = ExampleBuilder.create(TallyProductComponentExample.class, TallyProductComponentExample.Criteria.class);
        return tallyProductComponentMapper.selectByExample(builder.buildExamplePack(tallyProductComponent).getExample());
    }
  
    @Override
    public PageData<TallyProductComponent> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyProductComponentExample, TallyProductComponentExample.Criteria> builder = ExampleBuilder.create(TallyProductComponentExample.class, TallyProductComponentExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyProductComponentExample, TallyProductComponentExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyProductComponentMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyProductComponent tallyProductComponent) {
        ExampleBuilder<TallyProductComponentExample, TallyProductComponentExample.Criteria> builder = ExampleBuilder.create(TallyProductComponentExample.class, TallyProductComponentExample.Criteria.class);
        return tallyProductComponentMapper.countByExample(builder.buildExamplePack(tallyProductComponent).getExample());
    }
}