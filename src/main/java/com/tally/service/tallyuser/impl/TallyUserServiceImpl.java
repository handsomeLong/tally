package com.tally.service.tallyuser.impl;

import com.tally.api.inputDto.ApplyFriendsInputDto;
import com.tally.api.inputDto.WxAuthLoginInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.core.utils.JwtTokenUtils;
import com.tally.dao.tallyapplyfriends.model.TallyApplyFriends;
import com.tally.dao.tallyuser.TallyUserMapper;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.dao.tallyuser.model.TallyUserExample;
import com.tally.dao.tallyuserfriends.TallyUserFriendsMapper;
import com.tally.dao.tallyuserfriends.model.TallyUserFriends;
import com.tally.oauth.model.UserDetail;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyapplyfriends.TallyApplyFriendsService;
import com.tally.service.tallyuser.TallyUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyUserServiceImpl implements TallyUserService {

    @Autowired
    private TallyUserMapper tallyUserMapper;
    @Autowired
    private TallyUserFriendsMapper tallyUserFriendsMapper;
    @Autowired
    private TallyApplyFriendsService tallyApplyFriendsService;
    @Autowired
    private TallyAccountService tallyAccountService;

    @Override
    public Integer create(TallyUser tallyUser) {
        tallyUserMapper.insertSelective(tallyUser);
        return tallyUser.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUser tallyUser) {
        tallyUserMapper.updateByPrimaryKeySelective(tallyUser);
    }

    @Override
    public void updateByIdInBatch(List<TallyUser> tallyUsers) {
        if (CollectionUtils.isEmpty(tallyUsers)) return;
        for (TallyUser tallyUser: tallyUsers) {
            this.updateById(tallyUser);
        }
    }

    @Override
    public TallyUser findById(Integer id) {
        return tallyUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUser findOne(TallyUser tallyUser) {
        ExampleBuilder<TallyUserExample, TallyUserExample.Criteria> builder = ExampleBuilder.create(TallyUserExample.class, TallyUserExample.Criteria.class);
        List<TallyUser> tallyUsers = tallyUserMapper.selectByExample(builder.buildExamplePack(tallyUser).getExample());
        if (tallyUsers.size() > 0) {
            return tallyUsers.get(0);
        }
        return null;
    }

    @Override
    public List<TallyUser> findList(TallyUser tallyUser) {
        ExampleBuilder<TallyUserExample, TallyUserExample.Criteria> builder = ExampleBuilder.create(TallyUserExample.class, TallyUserExample.Criteria.class);
        return tallyUserMapper.selectByExample(builder.buildExamplePack(tallyUser).getExample());
    }
  
    @Override
    public PageData<TallyUser> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyUserExample, TallyUserExample.Criteria> builder = ExampleBuilder.create(TallyUserExample.class, TallyUserExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyUserExample, TallyUserExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyUserMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyUser tallyUser) {
        ExampleBuilder<TallyUserExample, TallyUserExample.Criteria> builder = ExampleBuilder.create(TallyUserExample.class, TallyUserExample.Criteria.class);
        return tallyUserMapper.countByExample(builder.buildExamplePack(tallyUser).getExample());
    }

    @Override
    public TallyUser saveWxAuthRegisterUser(WxAuthLoginInputDto wxAuthLoginInputDto, String mobile) {
        TallyUser tallyUser = new TallyUser();
        tallyUser.setMobile(mobile);
        tallyUser.setUserStatus(100);
        tallyUser.setUserType(100);
        tallyUserMapper.insertSelective(tallyUser);
        //创建默认账户
        tallyAccountService.createNewUserAccount(tallyUser);
        return tallyUser;
    }
    @Override
    public TallyUser saveUser(String name, String mobile) {
        TallyUser tallyUser = new TallyUser();
        tallyUser.setMobile(mobile);
        tallyUser.setName(name);
        tallyUser.setUserStatus(100);
        tallyUser.setUserType(100);
        tallyUserMapper.insertSelective(tallyUser);
//        String token = JwtTokenUtils.createToken(tallyUser.getId().toString());
//        tallyUser.setDeviceToken(token);
//        tallyUserMapper.updateByPrimaryKeySelective(tallyUser);
        //创建默认账户
        tallyAccountService.createNewUserAccount(tallyUser);
        return tallyUser;
    }
    @Override
    public ApiResponse addFriendsRequest(ApplyFriendsInputDto applyFriendsInputDto, String userId) {
        ApiResponse apiResponse = ApiResponse.failed("处理失败！");
        try {
            TallyApplyFriends tallyApplyFriends = new TallyApplyFriends();
            tallyApplyFriends.setApplyUserId(Integer.valueOf(userId));
            tallyApplyFriends.setApplyUserId(applyFriendsInputDto.getApplyUserId());
            tallyApplyFriends.setApplyType(applyFriendsInputDto.getApplyType());
            tallyApplyFriends.setRemark(applyFriendsInputDto.getRemark());
            tallyApplyFriends.setStatus(100);
            tallyApplyFriendsService.create(tallyApplyFriends);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("受理成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setMessage("处理异常");
        }
        return apiResponse;
    }

    @Override
    public ApiResponse addFriendsDirect(ApplyFriendsInputDto applyFriendsInputDto) {
        ApiResponse apiResponse = ApiResponse.failed("处理失败！");
        try {
            TallyUserFriends tallyUserFriends = new TallyUserFriends();
            tallyUserFriends.setUserId(applyFriendsInputDto.getApplyUserId());
            tallyUserFriends.setFriendsId(applyFriendsInputDto.getUserId());
            tallyUserFriends.setSettleWay(100);
            tallyUserFriends.setType(100);
            tallyUserFriends.setFriendsUserName(applyFriendsInputDto.getFriendsUserName());
            tallyUserFriendsMapper.insertSelective(tallyUserFriends);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setMessage("处理异常");
        }
        return apiResponse;
    }

    @Override
    public List<TallyUser> findByIds(List<Integer> userIdList) {
        return  tallyUserMapper.findByIds(userIdList);
    }
}