package com.tally.service.tallybillpayable.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallybillpayable.TallyBillPayableMapper;
import com.tally.dao.tallybillpayable.model.TallyBillPayable;
import com.tally.dao.tallybillpayable.model.TallyBillPayableExample;
import com.tally.service.tallybillpayable.TallyBillPayableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 应付账单Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyBillPayableServiceImpl implements TallyBillPayableService {

    @Autowired
    private TallyBillPayableMapper tallyBillPayableMapper;

    @Override
    public Integer create(TallyBillPayable tallyBillPayable) {
        tallyBillPayableMapper.insertSelective(tallyBillPayable);
        return tallyBillPayable.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyBillPayableMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyBillPayable tallyBillPayable) {
        tallyBillPayableMapper.updateByPrimaryKeySelective(tallyBillPayable);
    }

    @Override
    public void updateByIdInBatch(List<TallyBillPayable> tallyBillPayables) {
        if (CollectionUtils.isEmpty(tallyBillPayables)) return;
        for (TallyBillPayable tallyBillPayable: tallyBillPayables) {
            this.updateById(tallyBillPayable);
        }
    }

    @Override
    public TallyBillPayable findById(Integer id) {
        return tallyBillPayableMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyBillPayable findOne(TallyBillPayable tallyBillPayable) {
        ExampleBuilder<TallyBillPayableExample, TallyBillPayableExample.Criteria> builder = ExampleBuilder.create(TallyBillPayableExample.class, TallyBillPayableExample.Criteria.class);
        List<TallyBillPayable> tallyBillPayables = tallyBillPayableMapper.selectByExample(builder.buildExamplePack(tallyBillPayable).getExample());
        if (tallyBillPayables.size() > 0) {
            return tallyBillPayables.get(0);
        }
        return null;
    }

    @Override
    public List<TallyBillPayable> findList(TallyBillPayable tallyBillPayable) {
        ExampleBuilder<TallyBillPayableExample, TallyBillPayableExample.Criteria> builder = ExampleBuilder.create(TallyBillPayableExample.class, TallyBillPayableExample.Criteria.class);
        return tallyBillPayableMapper.selectByExample(builder.buildExamplePack(tallyBillPayable).getExample());
    }
  
    @Override
    public PageData<TallyBillPayable> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyBillPayableExample, TallyBillPayableExample.Criteria> builder = ExampleBuilder.create(TallyBillPayableExample.class, TallyBillPayableExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyBillPayableExample, TallyBillPayableExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyBillPayableMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyBillPayable tallyBillPayable) {
        ExampleBuilder<TallyBillPayableExample, TallyBillPayableExample.Criteria> builder = ExampleBuilder.create(TallyBillPayableExample.class, TallyBillPayableExample.Criteria.class);
        return tallyBillPayableMapper.countByExample(builder.buildExamplePack(tallyBillPayable).getExample());
    }
}