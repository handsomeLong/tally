package com.tally.service.tallyuserfriends.impl;

import com.tally.api.outputDto.TallyUserFriendsInputDto;
import com.tally.api.outputDto.TallyUserFriendsOutDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyuserfriends.TallyUserFriendsMapper;
import com.tally.dao.tallyuserfriends.model.TallyUserFriends;
import com.tally.dao.tallyuserfriends.model.TallyUserFriendsExample;
import com.tally.service.tallyuserfriends.TallyUserFriendsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户好友关系表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyUserFriendsServiceImpl implements TallyUserFriendsService {

    @Autowired
    private TallyUserFriendsMapper tallyUserFriendsMapper;

    @Override
    public Integer create(TallyUserFriends tallyUserFriends) {
        tallyUserFriendsMapper.insertSelective(tallyUserFriends);
        return tallyUserFriends.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyUserFriendsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUserFriends tallyUserFriends) {
        tallyUserFriendsMapper.updateByPrimaryKeySelective(tallyUserFriends);
    }

    @Override
    public void updateByIdInBatch(List<TallyUserFriends> tallyUserFriendss) {
        if (CollectionUtils.isEmpty(tallyUserFriendss)) return;
        for (TallyUserFriends tallyUserFriends: tallyUserFriendss) {
            this.updateById(tallyUserFriends);
        }
    }

    @Override
    public TallyUserFriends findById(Integer id) {
        return tallyUserFriendsMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUserFriendsOutDto findOne(TallyUserFriends tallyUserFriends) {
        ExampleBuilder<TallyUserFriendsExample, TallyUserFriendsExample.Criteria> builder = ExampleBuilder.create(TallyUserFriendsExample.class, TallyUserFriendsExample.Criteria.class);
        List<TallyUserFriendsOutDto> tallyUserFriendss = tallyUserFriendsMapper.selectByExample(builder.buildExamplePack(tallyUserFriends).getExample());
        if (tallyUserFriendss.size() > 0) {
            return tallyUserFriendss.get(0);
        }
        return null;
    }
  
    @Override
    public PageData<TallyUserFriendsOutDto> findPage(PageWrap<TallyUserFriendsInputDto> pageWrap) {
        try {
            PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
            TallyUserFriendsInputDto model = pageWrap.getModel();
            return PageData.from(new PageInfo<>(tallyUserFriendsMapper.findList(model)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long count(TallyUserFriends tallyUserFriends) {
        ExampleBuilder<TallyUserFriendsExample, TallyUserFriendsExample.Criteria> builder = ExampleBuilder.create(TallyUserFriendsExample.class, TallyUserFriendsExample.Criteria.class);
        return tallyUserFriendsMapper.countByExample(builder.buildExamplePack(tallyUserFriends).getExample());
    }
}