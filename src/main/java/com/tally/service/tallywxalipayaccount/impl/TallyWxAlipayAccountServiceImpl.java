package com.tally.service.tallywxalipayaccount.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallywxalipayaccount.TallyWxAlipayAccountMapper;
import com.tally.dao.tallywxalipayaccount.model.TallyWxAlipayAccount;
import com.tally.dao.tallywxalipayaccount.model.TallyWxAlipayAccountExample;
import com.tally.service.tallywxalipayaccount.TallyWxAlipayAccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 微信支付宝账号表Service实现
 * @author 131****2893
 * @date 2020/10/28 15:18
 */
@Service
public class TallyWxAlipayAccountServiceImpl implements TallyWxAlipayAccountService {

    @Autowired
    private TallyWxAlipayAccountMapper tallyWxAlipayAccountMapper;

    @Override
    public Integer create(TallyWxAlipayAccount tallyWxAlipayAccount) {
        tallyWxAlipayAccountMapper.insertSelective(tallyWxAlipayAccount);
        return tallyWxAlipayAccount.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyWxAlipayAccountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyWxAlipayAccount tallyWxAlipayAccount) {
        tallyWxAlipayAccountMapper.updateByPrimaryKeySelective(tallyWxAlipayAccount);
    }

    @Override
    public void updateByIdInBatch(List<TallyWxAlipayAccount> tallyWxAlipayAccounts) {
        if (CollectionUtils.isEmpty(tallyWxAlipayAccounts)) return;
        for (TallyWxAlipayAccount tallyWxAlipayAccount: tallyWxAlipayAccounts) {
            this.updateById(tallyWxAlipayAccount);
        }
    }

    @Override
    public TallyWxAlipayAccount findById(Integer id) {
        return tallyWxAlipayAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyWxAlipayAccount findOne(TallyWxAlipayAccount tallyWxAlipayAccount) {
        ExampleBuilder<TallyWxAlipayAccountExample, TallyWxAlipayAccountExample.Criteria> builder = ExampleBuilder.create(TallyWxAlipayAccountExample.class, TallyWxAlipayAccountExample.Criteria.class);
        List<TallyWxAlipayAccount> tallyWxAlipayAccounts = tallyWxAlipayAccountMapper.selectByExample(builder.buildExamplePack(tallyWxAlipayAccount).getExample());
        if (tallyWxAlipayAccounts.size() > 0) {
            return tallyWxAlipayAccounts.get(0);
        }
        return null;
    }

    @Override
    public List<TallyWxAlipayAccount> findList(TallyWxAlipayAccount tallyWxAlipayAccount) {
        ExampleBuilder<TallyWxAlipayAccountExample, TallyWxAlipayAccountExample.Criteria> builder = ExampleBuilder.create(TallyWxAlipayAccountExample.class, TallyWxAlipayAccountExample.Criteria.class);
        return tallyWxAlipayAccountMapper.selectByExample(builder.buildExamplePack(tallyWxAlipayAccount).getExample());
    }
  
    @Override
    public PageData<TallyWxAlipayAccount> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyWxAlipayAccountExample, TallyWxAlipayAccountExample.Criteria> builder = ExampleBuilder.create(TallyWxAlipayAccountExample.class, TallyWxAlipayAccountExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyWxAlipayAccountExample, TallyWxAlipayAccountExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyWxAlipayAccountMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyWxAlipayAccount tallyWxAlipayAccount) {
        ExampleBuilder<TallyWxAlipayAccountExample, TallyWxAlipayAccountExample.Criteria> builder = ExampleBuilder.create(TallyWxAlipayAccountExample.class, TallyWxAlipayAccountExample.Criteria.class);
        return tallyWxAlipayAccountMapper.countByExample(builder.buildExamplePack(tallyWxAlipayAccount).getExample());
    }
}