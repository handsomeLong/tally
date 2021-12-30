package com.tally.service.tallybusinesstype.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallybusinesstype.TallyBusinessTypeMapper;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.dao.tallybusinesstype.model.TallyBusinessTypeExample;
import com.tally.service.tallybusinesstype.TallyBusinessTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 业务类型表Service实现
 * @author 131****2893
 * @date 2021/03/27 19:02
 */
@Service
public class TallyBusinessTypeServiceImpl implements TallyBusinessTypeService {

    @Autowired
    private TallyBusinessTypeMapper tallyBusinessTypeMapper;

    @Override
    public Integer create(TallyBusinessType tallyBusinessType) {
        tallyBusinessTypeMapper.insertSelective(tallyBusinessType);
        return tallyBusinessType.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyBusinessTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyBusinessType tallyBusinessType) {
        tallyBusinessTypeMapper.updateByPrimaryKeySelective(tallyBusinessType);
    }

    @Override
    public void updateByIdInBatch(List<TallyBusinessType> tallyBusinessTypes) {
        if (CollectionUtils.isEmpty(tallyBusinessTypes)) return;
        for (TallyBusinessType tallyBusinessType: tallyBusinessTypes) {
            this.updateById(tallyBusinessType);
        }
    }

    @Override
    public TallyBusinessType findById(Integer id) {
        return tallyBusinessTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyBusinessType findOne(TallyBusinessType tallyBusinessType) {
        ExampleBuilder<TallyBusinessTypeExample, TallyBusinessTypeExample.Criteria> builder = ExampleBuilder.create(TallyBusinessTypeExample.class, TallyBusinessTypeExample.Criteria.class);
        List<TallyBusinessType> tallyBusinessTypes = tallyBusinessTypeMapper.selectByExample(builder.buildExamplePack(tallyBusinessType).getExample());
        if (tallyBusinessTypes.size() > 0) {
            return tallyBusinessTypes.get(0);
        }
        return null;
    }

    @Override
    public List<TallyBusinessType> findList(TallyBusinessType tallyBusinessType) {
        ExampleBuilder<TallyBusinessTypeExample, TallyBusinessTypeExample.Criteria> builder = ExampleBuilder.create(TallyBusinessTypeExample.class, TallyBusinessTypeExample.Criteria.class);
        return tallyBusinessTypeMapper.selectByExample(builder.buildExamplePack(tallyBusinessType).getExample());
    }
  
    @Override
    public PageData<TallyBusinessType> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyBusinessTypeExample, TallyBusinessTypeExample.Criteria> builder = ExampleBuilder.create(TallyBusinessTypeExample.class, TallyBusinessTypeExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyBusinessTypeExample, TallyBusinessTypeExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyBusinessTypeMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyBusinessType tallyBusinessType) {
        ExampleBuilder<TallyBusinessTypeExample, TallyBusinessTypeExample.Criteria> builder = ExampleBuilder.create(TallyBusinessTypeExample.class, TallyBusinessTypeExample.Criteria.class);
        return tallyBusinessTypeMapper.countByExample(builder.buildExamplePack(tallyBusinessType).getExample());
    }
}