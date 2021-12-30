package com.tally.service.tallybillreceivable.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallybillreceivable.TallyBillReceivableMapper;
import com.tally.dao.tallybillreceivable.model.TallyBillReceivable;
import com.tally.dao.tallybillreceivable.model.TallyBillReceivableExample;
import com.tally.service.tallybillreceivable.TallyBillReceivableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 应收账单Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyBillReceivableServiceImpl implements TallyBillReceivableService {

    @Autowired
    private TallyBillReceivableMapper tallyBillReceivableMapper;

    @Override
    public Integer create(TallyBillReceivable tallyBillReceivable) {
        tallyBillReceivableMapper.insertSelective(tallyBillReceivable);
        return tallyBillReceivable.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyBillReceivableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyBillReceivable tallyBillReceivable) {
        tallyBillReceivableMapper.updateByPrimaryKeySelective(tallyBillReceivable);
    }

    @Override
    public void updateByIdInBatch(List<TallyBillReceivable> tallyBillReceivables) {
        if (CollectionUtils.isEmpty(tallyBillReceivables)) return;
        for (TallyBillReceivable tallyBillReceivable: tallyBillReceivables) {
            this.updateById(tallyBillReceivable);
        }
    }

    @Override
    public TallyBillReceivable findById(Integer id) {
        return tallyBillReceivableMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyBillReceivable findOne(TallyBillReceivable tallyBillReceivable) {
        ExampleBuilder<TallyBillReceivableExample, TallyBillReceivableExample.Criteria> builder = ExampleBuilder.create(TallyBillReceivableExample.class, TallyBillReceivableExample.Criteria.class);
        List<TallyBillReceivable> tallyBillReceivables = tallyBillReceivableMapper.selectByExample(builder.buildExamplePack(tallyBillReceivable).getExample());
        if (tallyBillReceivables.size() > 0) {
            return tallyBillReceivables.get(0);
        }
        return null;
    }

    @Override
    public List<TallyBillReceivable> findList(TallyBillReceivable tallyBillReceivable) {
        ExampleBuilder<TallyBillReceivableExample, TallyBillReceivableExample.Criteria> builder = ExampleBuilder.create(TallyBillReceivableExample.class, TallyBillReceivableExample.Criteria.class);
        return tallyBillReceivableMapper.selectByExample(builder.buildExamplePack(tallyBillReceivable).getExample());
    }
  
    @Override
    public PageData<TallyBillReceivable> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyBillReceivableExample, TallyBillReceivableExample.Criteria> builder = ExampleBuilder.create(TallyBillReceivableExample.class, TallyBillReceivableExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyBillReceivableExample, TallyBillReceivableExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyBillReceivableMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyBillReceivable tallyBillReceivable) {
        ExampleBuilder<TallyBillReceivableExample, TallyBillReceivableExample.Criteria> builder = ExampleBuilder.create(TallyBillReceivableExample.class, TallyBillReceivableExample.Criteria.class);
        return tallyBillReceivableMapper.countByExample(builder.buildExamplePack(tallyBillReceivable).getExample());
    }
}