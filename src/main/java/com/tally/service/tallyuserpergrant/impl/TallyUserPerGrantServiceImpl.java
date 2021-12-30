package com.tally.service.tallyuserpergrant.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.dao.tallyuserpergrant.TallyUserPerGrantMapper;
import com.tally.dao.tallyuserpergrant.model.TallyUserPerGrant;
import com.tally.dao.tallyuserpergrant.model.TallyUserPerGrantExample;
import com.tally.service.tallyuser.TallyUserService;
import com.tally.service.tallyuserpergrant.TallyUserPerGrantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用户权限授权表Service实现
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
@Service
public class TallyUserPerGrantServiceImpl implements TallyUserPerGrantService {

    @Autowired
    private TallyUserPerGrantMapper tallyUserPerGrantMapper;
    @Autowired
    private TallyUserService tallyUserService;

    @Override
    public Integer create(TallyUserPerGrant tallyUserPerGrant) {
        tallyUserPerGrantMapper.insertSelective(tallyUserPerGrant);
        return tallyUserPerGrant.getId();
    }

    @Override
    public void deleteById(Long id) {
        tallyUserPerGrantMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Long id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUserPerGrant tallyUserPerGrant) {
        tallyUserPerGrantMapper.updateByPrimaryKeySelective(tallyUserPerGrant);
    }

    @Override
    public void updateByIdInBatch(List<TallyUserPerGrant> tallyUserPerGrants) {
        if (CollectionUtils.isEmpty(tallyUserPerGrants)) return;
        for (TallyUserPerGrant tallyUserPerGrant: tallyUserPerGrants) {
            this.updateById(tallyUserPerGrant);
        }
    }

    @Override
    public TallyUserPerGrant findById(Long id) {
        return tallyUserPerGrantMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUserPerGrant findOne(TallyUserPerGrant tallyUserPerGrant) {
        ExampleBuilder<TallyUserPerGrantExample, TallyUserPerGrantExample.Criteria> builder = ExampleBuilder.create(TallyUserPerGrantExample.class, TallyUserPerGrantExample.Criteria.class);
        List<TallyUserPerGrant> tallyUserPerGrants = tallyUserPerGrantMapper.selectByExample(builder.buildExamplePack(tallyUserPerGrant).getExample());
        if (tallyUserPerGrants.size() > 0) {
            return tallyUserPerGrants.get(0);
        }
        return null;
    }

    @Override
    public List<TallyUserPerGrant> findList(TallyUserPerGrant tallyUserPerGrant) {
        ExampleBuilder<TallyUserPerGrantExample, TallyUserPerGrantExample.Criteria> builder = ExampleBuilder.create(TallyUserPerGrantExample.class, TallyUserPerGrantExample.Criteria.class);
        return tallyUserPerGrantMapper.selectByExample(builder.buildExamplePack(tallyUserPerGrant).getExample());
    }
  
    @Override
    public PageData<TallyUserPerGrant> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyUserPerGrantExample, TallyUserPerGrantExample.Criteria> builder = ExampleBuilder.create(TallyUserPerGrantExample.class, TallyUserPerGrantExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyUserPerGrantExample, TallyUserPerGrantExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyUserPerGrantMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyUserPerGrant tallyUserPerGrant) {
        ExampleBuilder<TallyUserPerGrantExample, TallyUserPerGrantExample.Criteria> builder = ExampleBuilder.create(TallyUserPerGrantExample.class, TallyUserPerGrantExample.Criteria.class);
        return tallyUserPerGrantMapper.countByExample(builder.buildExamplePack(tallyUserPerGrant).getExample());
    }

    @Override
    public Map<String,List> getGrantUserIds(String userId, String code) {
       List<TallyUserPerGrant>  list = tallyUserPerGrantMapper.findGrantList(userId,code);
        List<Integer> userList = list.stream().map(TallyUserPerGrant::getUseId).collect(Collectors.toList());
        List<String> userMobileList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(userList)){
            userMobileList = tallyUserService.findByIds(userList).stream().map(TallyUser::getMobile).collect(Collectors.toList());
        }
        Map<String,List> map  = new HashMap<>();
        map.put("userIdList",userList);
        map.put("userMobileList",userMobileList);
        return map;
    }
}
