package com.tally.service.tallyaccounttype.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyaccounttype.TallyAccountTypeMapper;
import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import com.tally.dao.tallyaccounttype.model.TallyAccountTypeExample;
import com.tally.service.tallyaccounttype.TallyAccountTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 账户类型表Service实现
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Service
public class TallyAccountTypeServiceImpl implements TallyAccountTypeService {

    @Autowired
    private TallyAccountTypeMapper tallyAccountTypeMapper;

    @Override
    public Integer create(TallyAccountType tallyAccountType) {
        tallyAccountTypeMapper.insertSelective(tallyAccountType);
        return tallyAccountType.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyAccountTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyAccountType tallyAccountType) {
        tallyAccountTypeMapper.updateByPrimaryKeySelective(tallyAccountType);
    }

    @Override
    public void updateByIdInBatch(List<TallyAccountType> tallyAccountTypes) {
        if (CollectionUtils.isEmpty(tallyAccountTypes)) return;
        for (TallyAccountType tallyAccountType: tallyAccountTypes) {
            this.updateById(tallyAccountType);
        }
    }

    @Override
    public TallyAccountType findById(Integer id) {
        return tallyAccountTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyAccountType findOne(TallyAccountType tallyAccountType) {
        ExampleBuilder<TallyAccountTypeExample, TallyAccountTypeExample.Criteria> builder = ExampleBuilder.create(TallyAccountTypeExample.class, TallyAccountTypeExample.Criteria.class);
        List<TallyAccountType> tallyAccountTypes = tallyAccountTypeMapper.selectByExample(builder.buildExamplePack(tallyAccountType).getExample());
        if (tallyAccountTypes.size() > 0) {
            return tallyAccountTypes.get(0);
        }
        return null;
    }

    @Override
    public List<TallyAccountType> findList(TallyAccountType tallyAccountType) {
        ExampleBuilder<TallyAccountTypeExample, TallyAccountTypeExample.Criteria> builder = ExampleBuilder.create(TallyAccountTypeExample.class, TallyAccountTypeExample.Criteria.class);
        return tallyAccountTypeMapper.selectByExample(builder.buildExamplePack(tallyAccountType).getExample());
    }
  
    @Override
    public PageData<TallyAccountType> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyAccountTypeExample, TallyAccountTypeExample.Criteria> builder = ExampleBuilder.create(TallyAccountTypeExample.class, TallyAccountTypeExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyAccountTypeExample, TallyAccountTypeExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyAccountTypeMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyAccountType tallyAccountType) {
        ExampleBuilder<TallyAccountTypeExample, TallyAccountTypeExample.Criteria> builder = ExampleBuilder.create(TallyAccountTypeExample.class, TallyAccountTypeExample.Criteria.class);
        return tallyAccountTypeMapper.countByExample(builder.buildExamplePack(tallyAccountType).getExample());
    }
}