package com.tally.service.tallyrole.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyrole.TallyRoleMapper;
import com.tally.dao.tallyrole.model.TallyRole;
import com.tally.dao.tallyrole.model.TallyRoleExample;
import com.tally.service.tallyrole.TallyRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 角色表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyRoleServiceImpl implements TallyRoleService {

    @Autowired
    private TallyRoleMapper tallyRoleMapper;

    @Override
    public Integer create(TallyRole tallyRole) {
        tallyRoleMapper.insertSelective(tallyRole);
        return tallyRole.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyRole tallyRole) {
        tallyRoleMapper.updateByPrimaryKeySelective(tallyRole);
    }

    @Override
    public void updateByIdInBatch(List<TallyRole> tallyRoles) {
        if (CollectionUtils.isEmpty(tallyRoles)) return;
        for (TallyRole tallyRole: tallyRoles) {
            this.updateById(tallyRole);
        }
    }

    @Override
    public TallyRole findById(Integer id) {
        return tallyRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyRole findOne(TallyRole tallyRole) {
        ExampleBuilder<TallyRoleExample, TallyRoleExample.Criteria> builder = ExampleBuilder.create(TallyRoleExample.class, TallyRoleExample.Criteria.class);
        List<TallyRole> tallyRoles = tallyRoleMapper.selectByExample(builder.buildExamplePack(tallyRole).getExample());
        if (tallyRoles.size() > 0) {
            return tallyRoles.get(0);
        }
        return null;
    }

    @Override
    public List<TallyRole> findList(TallyRole tallyRole) {
        ExampleBuilder<TallyRoleExample, TallyRoleExample.Criteria> builder = ExampleBuilder.create(TallyRoleExample.class, TallyRoleExample.Criteria.class);
        return tallyRoleMapper.selectByExample(builder.buildExamplePack(tallyRole).getExample());
    }
  
    @Override
    public PageData<TallyRole> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyRoleExample, TallyRoleExample.Criteria> builder = ExampleBuilder.create(TallyRoleExample.class, TallyRoleExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyRoleExample, TallyRoleExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyRoleMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyRole tallyRole) {
        ExampleBuilder<TallyRoleExample, TallyRoleExample.Criteria> builder = ExampleBuilder.create(TallyRoleExample.class, TallyRoleExample.Criteria.class);
        return tallyRoleMapper.countByExample(builder.buildExamplePack(tallyRole).getExample());
    }
}