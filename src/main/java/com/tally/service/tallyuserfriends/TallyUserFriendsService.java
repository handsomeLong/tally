package com.tally.service.tallyuserfriends;

import com.tally.api.outputDto.TallyUserFriendsInputDto;
import com.tally.api.outputDto.TallyUserFriendsOutDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserfriends.model.TallyUserFriends;
import java.util.List;

/**
 * 用户好友关系表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyUserFriendsService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyUserFriends tallyUserFriends);

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
    void updateById(TallyUserFriends tallyUserFriends);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyUserFriends> tallyUserFriendss);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUserFriends findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUserFriendsOutDto findOne(TallyUserFriends tallyUserFriends);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyUserFriendsOutDto> findPage(PageWrap<TallyUserFriendsInputDto> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyUserFriends tallyUserFriends);
}