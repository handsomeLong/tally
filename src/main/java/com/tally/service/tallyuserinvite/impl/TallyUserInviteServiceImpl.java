package com.tally.service.tallyuserinvite.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyuserinvite.TallyUserInviteMapper;
import com.tally.dao.tallyuserinvite.model.TallyUserInvite;
import com.tally.dao.tallyuserinvite.model.TallyUserInviteExample;
import com.tally.service.tallyuserinvite.TallyUserInviteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户邀请好友表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyUserInviteServiceImpl implements TallyUserInviteService {

    @Autowired
    private TallyUserInviteMapper tallyUserInviteMapper;

    @Override
    public Integer create(TallyUserInvite tallyUserInvite) {
        tallyUserInviteMapper.insertSelective(tallyUserInvite);
        return tallyUserInvite.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyUserInviteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUserInvite tallyUserInvite) {
        tallyUserInviteMapper.updateByPrimaryKeySelective(tallyUserInvite);
    }

    @Override
    public void updateByIdInBatch(List<TallyUserInvite> tallyUserInvites) {
        if (CollectionUtils.isEmpty(tallyUserInvites)) return;
        for (TallyUserInvite tallyUserInvite: tallyUserInvites) {
            this.updateById(tallyUserInvite);
        }
    }

    @Override
    public TallyUserInvite findById(Integer id) {
        return tallyUserInviteMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUserInvite findOne(TallyUserInvite tallyUserInvite) {
        ExampleBuilder<TallyUserInviteExample, TallyUserInviteExample.Criteria> builder = ExampleBuilder.create(TallyUserInviteExample.class, TallyUserInviteExample.Criteria.class);
        List<TallyUserInvite> tallyUserInvites = tallyUserInviteMapper.selectByExample(builder.buildExamplePack(tallyUserInvite).getExample());
        if (tallyUserInvites.size() > 0) {
            return tallyUserInvites.get(0);
        }
        return null;
    }

    @Override
    public List<TallyUserInvite> findList(TallyUserInvite tallyUserInvite) {
        ExampleBuilder<TallyUserInviteExample, TallyUserInviteExample.Criteria> builder = ExampleBuilder.create(TallyUserInviteExample.class, TallyUserInviteExample.Criteria.class);
        return tallyUserInviteMapper.selectByExample(builder.buildExamplePack(tallyUserInvite).getExample());
    }
  
    @Override
    public PageData<TallyUserInvite> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyUserInviteExample, TallyUserInviteExample.Criteria> builder = ExampleBuilder.create(TallyUserInviteExample.class, TallyUserInviteExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyUserInviteExample, TallyUserInviteExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyUserInviteMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyUserInvite tallyUserInvite) {
        ExampleBuilder<TallyUserInviteExample, TallyUserInviteExample.Criteria> builder = ExampleBuilder.create(TallyUserInviteExample.class, TallyUserInviteExample.Criteria.class);
        return tallyUserInviteMapper.countByExample(builder.buildExamplePack(tallyUserInvite).getExample());
    }
}