package com.tally.service.tallyapplyfriends;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyapplyfriends.model.TallyApplyFriends;
import java.util.List;

/**
 * 请求添加好友Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyApplyFriendsService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyApplyFriends tallyApplyFriends);

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
    void updateById(TallyApplyFriends tallyApplyFriends);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyApplyFriends> tallyApplyFriendss);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyApplyFriends findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyApplyFriends findOne(TallyApplyFriends tallyApplyFriends);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyApplyFriends> findList(TallyApplyFriends tallyApplyFriends);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyApplyFriends> findPage(PageWrap<TallyApplyFriends> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyApplyFriends tallyApplyFriends);
}