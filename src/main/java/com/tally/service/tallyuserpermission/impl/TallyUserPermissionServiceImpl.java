package com.tally.service.tallyuserpermission.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyuserpermission.TallyUserPermissionMapper;
import com.tally.dao.tallyuserpermission.model.TallyUserPermission;
import com.tally.dao.tallyuserpermission.model.TallyUserPermissionExample;
import com.tally.service.tallyuserpermission.TallyUserPermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户权限表Service实现
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
@Service
public class TallyUserPermissionServiceImpl implements TallyUserPermissionService {

    @Autowired
    private TallyUserPermissionMapper tallyUserPermissionMapper;

    @Override
    public Long create(TallyUserPermission tallyUserPermission) {
        tallyUserPermissionMapper.insertSelective(tallyUserPermission);
        return tallyUserPermission.getId();
    }

    @Override
    public void deleteById(Long id) {
        tallyUserPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Long id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUserPermission tallyUserPermission) {
        tallyUserPermissionMapper.updateByPrimaryKeySelective(tallyUserPermission);
    }

    @Override
    public void updateByIdInBatch(List<TallyUserPermission> tallyUserPermissions) {
        if (CollectionUtils.isEmpty(tallyUserPermissions)) return;
        for (TallyUserPermission tallyUserPermission: tallyUserPermissions) {
            this.updateById(tallyUserPermission);
        }
    }

    @Override
    public TallyUserPermission findById(Long id) {
        return tallyUserPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUserPermission findOne(TallyUserPermission tallyUserPermission) {
        ExampleBuilder<TallyUserPermissionExample, TallyUserPermissionExample.Criteria> builder = ExampleBuilder.create(TallyUserPermissionExample.class, TallyUserPermissionExample.Criteria.class);
        List<TallyUserPermission> tallyUserPermissions = tallyUserPermissionMapper.selectByExample(builder.buildExamplePack(tallyUserPermission).getExample());
        if (tallyUserPermissions.size() > 0) {
            return tallyUserPermissions.get(0);
        }
        return null;
    }

    @Override
    public List<TallyUserPermission> findList(TallyUserPermission tallyUserPermission) {
        ExampleBuilder<TallyUserPermissionExample, TallyUserPermissionExample.Criteria> builder = ExampleBuilder.create(TallyUserPermissionExample.class, TallyUserPermissionExample.Criteria.class);
        return tallyUserPermissionMapper.selectByExample(builder.buildExamplePack(tallyUserPermission).getExample());
    }
  
    @Override
    public PageData<TallyUserPermission> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyUserPermissionExample, TallyUserPermissionExample.Criteria> builder = ExampleBuilder.create(TallyUserPermissionExample.class, TallyUserPermissionExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyUserPermissionExample, TallyUserPermissionExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyUserPermissionMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyUserPermission tallyUserPermission) {
        ExampleBuilder<TallyUserPermissionExample, TallyUserPermissionExample.Criteria> builder = ExampleBuilder.create(TallyUserPermissionExample.class, TallyUserPermissionExample.Criteria.class);
        return tallyUserPermissionMapper.countByExample(builder.buildExamplePack(tallyUserPermission).getExample());
    }
}
