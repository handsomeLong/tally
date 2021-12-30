package com.tally.service.tallyuser;

import com.tally.api.inputDto.ApplyFriendsInputDto;
import com.tally.api.inputDto.WxAuthLoginInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuser.model.TallyUser;
import com.tally.oauth.model.UserDetail;

import java.util.BitSet;
import java.util.List;

/**
 * 用户表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyUserService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyUser tallyUser);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateById(TallyUser tallyUser);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyUser> tallyUsers);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUser findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUser findOne(TallyUser tallyUser);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyUser> findList(TallyUser tallyUser);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyUser> findPage(PageWrap<TallyUser> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyUser tallyUser);

    TallyUser saveWxAuthRegisterUser(WxAuthLoginInputDto wxAuthLoginInputDto, String mobile);


    TallyUser saveUser(String name, String mobile);

    /**
     * 添加好友
     * @param applyFriendsInputDto
     * @param userId
     * @return
     */
    ApiResponse addFriendsRequest(ApplyFriendsInputDto applyFriendsInputDto, String userId);

    /**
     * 直接添加为好友
     * @param applyFriendsInputDto
     * @return
     */
    ApiResponse addFriendsDirect(ApplyFriendsInputDto applyFriendsInputDto);

    List<TallyUser> findByIds(List<Integer> userList);
}