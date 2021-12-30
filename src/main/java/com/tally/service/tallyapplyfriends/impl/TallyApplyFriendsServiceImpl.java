package com.tally.service.tallyapplyfriends.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyapplyfriends.TallyApplyFriendsMapper;
import com.tally.dao.tallyapplyfriends.model.TallyApplyFriends;
import com.tally.dao.tallyapplyfriends.model.TallyApplyFriendsExample;
import com.tally.service.tallyapplyfriends.TallyApplyFriendsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 请求添加好友Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyApplyFriendsServiceImpl implements TallyApplyFriendsService {

    @Autowired
    private TallyApplyFriendsMapper tallyApplyFriendsMapper;

    @Override
    public Integer create(TallyApplyFriends tallyApplyFriends) {
        tallyApplyFriendsMapper.insertSelective(tallyApplyFriends);
        return tallyApplyFriends.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyApplyFriendsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyApplyFriends tallyApplyFriends) {
        tallyApplyFriendsMapper.updateByPrimaryKeySelective(tallyApplyFriends);
    }

    @Override
    public void updateByIdInBatch(List<TallyApplyFriends> tallyApplyFriendss) {
        if (CollectionUtils.isEmpty(tallyApplyFriendss)) return;
        for (TallyApplyFriends tallyApplyFriends: tallyApplyFriendss) {
            this.updateById(tallyApplyFriends);
        }
    }

    @Override
    public TallyApplyFriends findById(Integer id) {
        return tallyApplyFriendsMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyApplyFriends findOne(TallyApplyFriends tallyApplyFriends) {
        ExampleBuilder<TallyApplyFriendsExample, TallyApplyFriendsExample.Criteria> builder = ExampleBuilder.create(TallyApplyFriendsExample.class, TallyApplyFriendsExample.Criteria.class);
        List<TallyApplyFriends> tallyApplyFriendss = tallyApplyFriendsMapper.selectByExample(builder.buildExamplePack(tallyApplyFriends).getExample());
        if (tallyApplyFriendss.size() > 0) {
            return tallyApplyFriendss.get(0);
        }
        return null;
    }

    @Override
    public List<TallyApplyFriends> findList(TallyApplyFriends tallyApplyFriends) {
        ExampleBuilder<TallyApplyFriendsExample, TallyApplyFriendsExample.Criteria> builder = ExampleBuilder.create(TallyApplyFriendsExample.class, TallyApplyFriendsExample.Criteria.class);
        return tallyApplyFriendsMapper.selectByExample(builder.buildExamplePack(tallyApplyFriends).getExample());
    }
  
    @Override
    public PageData<TallyApplyFriends> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyApplyFriendsExample, TallyApplyFriendsExample.Criteria> builder = ExampleBuilder.create(TallyApplyFriendsExample.class, TallyApplyFriendsExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyApplyFriendsExample, TallyApplyFriendsExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyApplyFriendsMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyApplyFriends tallyApplyFriends) {
        ExampleBuilder<TallyApplyFriendsExample, TallyApplyFriendsExample.Criteria> builder = ExampleBuilder.create(TallyApplyFriendsExample.class, TallyApplyFriendsExample.Criteria.class);
        return tallyApplyFriendsMapper.countByExample(builder.buildExamplePack(tallyApplyFriends).getExample());
    }
}