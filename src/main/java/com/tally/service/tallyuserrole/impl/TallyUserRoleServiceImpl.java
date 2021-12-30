package com.tally.service.tallyuserrole.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyuserrole.TallyUserRoleMapper;
import com.tally.dao.tallyuserrole.model.TallyUserRole;
import com.tally.dao.tallyuserrole.model.TallyUserRoleExample;
import com.tally.service.tallyuserrole.TallyUserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户角色关系表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyUserRoleServiceImpl implements TallyUserRoleService {

    @Autowired
    private TallyUserRoleMapper tallyUserRoleMapper;

    @Override
    public Integer create(TallyUserRole tallyUserRole) {
        tallyUserRoleMapper.insertSelective(tallyUserRole);
        return tallyUserRole.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUserRole tallyUserRole) {
        tallyUserRoleMapper.updateByPrimaryKeySelective(tallyUserRole);
    }

    @Override
    public void updateByIdInBatch(List<TallyUserRole> tallyUserRoles) {
        if (CollectionUtils.isEmpty(tallyUserRoles)) return;
        for (TallyUserRole tallyUserRole: tallyUserRoles) {
            this.updateById(tallyUserRole);
        }
    }

    @Override
    public TallyUserRole findById(Integer id) {
        return tallyUserRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUserRole findOne(TallyUserRole tallyUserRole) {
        ExampleBuilder<TallyUserRoleExample, TallyUserRoleExample.Criteria> builder = ExampleBuilder.create(TallyUserRoleExample.class, TallyUserRoleExample.Criteria.class);
        List<TallyUserRole> tallyUserRoles = tallyUserRoleMapper.selectByExample(builder.buildExamplePack(tallyUserRole).getExample());
        if (tallyUserRoles.size() > 0) {
            return tallyUserRoles.get(0);
        }
        return null;
    }

    @Override
    public List<TallyUserRole> findList(TallyUserRole tallyUserRole) {
        ExampleBuilder<TallyUserRoleExample, TallyUserRoleExample.Criteria> builder = ExampleBuilder.create(TallyUserRoleExample.class, TallyUserRoleExample.Criteria.class);
        return tallyUserRoleMapper.selectByExample(builder.buildExamplePack(tallyUserRole).getExample());
    }
  
    @Override
    public PageData<TallyUserRole> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyUserRoleExample, TallyUserRoleExample.Criteria> builder = ExampleBuilder.create(TallyUserRoleExample.class, TallyUserRoleExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyUserRoleExample, TallyUserRoleExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyUserRoleMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyUserRole tallyUserRole) {
        ExampleBuilder<TallyUserRoleExample, TallyUserRoleExample.Criteria> builder = ExampleBuilder.create(TallyUserRoleExample.class, TallyUserRoleExample.Criteria.class);
        return tallyUserRoleMapper.countByExample(builder.buildExamplePack(tallyUserRole).getExample());
    }
}