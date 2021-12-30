package com.tally.service.tallyusercredit.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyusercredit.TallyUserCreditMapper;
import com.tally.dao.tallyusercredit.model.TallyUserCredit;
import com.tally.dao.tallyusercredit.model.TallyUserCreditExample;
import com.tally.service.tallyusercredit.TallyUserCreditService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户信誉表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyUserCreditServiceImpl implements TallyUserCreditService {

    @Autowired
    private TallyUserCreditMapper tallyUserCreditMapper;

    @Override
    public Integer create(TallyUserCredit tallyUserCredit) {
        tallyUserCreditMapper.insertSelective(tallyUserCredit);
        return tallyUserCredit.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyUserCreditMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUserCredit tallyUserCredit) {
        tallyUserCreditMapper.updateByPrimaryKeySelective(tallyUserCredit);
    }

    @Override
    public void updateByIdInBatch(List<TallyUserCredit> tallyUserCredits) {
        if (CollectionUtils.isEmpty(tallyUserCredits)) return;
        for (TallyUserCredit tallyUserCredit: tallyUserCredits) {
            this.updateById(tallyUserCredit);
        }
    }

    @Override
    public TallyUserCredit findById(Integer id) {
        return tallyUserCreditMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUserCredit findOne(TallyUserCredit tallyUserCredit) {
        ExampleBuilder<TallyUserCreditExample, TallyUserCreditExample.Criteria> builder = ExampleBuilder.create(TallyUserCreditExample.class, TallyUserCreditExample.Criteria.class);
        List<TallyUserCredit> tallyUserCredits = tallyUserCreditMapper.selectByExample(builder.buildExamplePack(tallyUserCredit).getExample());
        if (tallyUserCredits.size() > 0) {
            return tallyUserCredits.get(0);
        }
        return null;
    }

    @Override
    public List<TallyUserCredit> findList(TallyUserCredit tallyUserCredit) {
        ExampleBuilder<TallyUserCreditExample, TallyUserCreditExample.Criteria> builder = ExampleBuilder.create(TallyUserCreditExample.class, TallyUserCreditExample.Criteria.class);
        return tallyUserCreditMapper.selectByExample(builder.buildExamplePack(tallyUserCredit).getExample());
    }
  
    @Override
    public PageData<TallyUserCredit> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyUserCreditExample, TallyUserCreditExample.Criteria> builder = ExampleBuilder.create(TallyUserCreditExample.class, TallyUserCreditExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyUserCreditExample, TallyUserCreditExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyUserCreditMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyUserCredit tallyUserCredit) {
        ExampleBuilder<TallyUserCreditExample, TallyUserCreditExample.Criteria> builder = ExampleBuilder.create(TallyUserCreditExample.class, TallyUserCreditExample.Criteria.class);
        return tallyUserCreditMapper.countByExample(builder.buildExamplePack(tallyUserCredit).getExample());
    }
}