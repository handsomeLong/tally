package com.tally.service.tallyuserinvite;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserinvite.model.TallyUserInvite;
import java.util.List;

/**
 * 用户邀请好友表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyUserInviteService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyUserInvite tallyUserInvite);

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
    void updateById(TallyUserInvite tallyUserInvite);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyUserInvite> tallyUserInvites);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUserInvite findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUserInvite findOne(TallyUserInvite tallyUserInvite);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyUserInvite> findList(TallyUserInvite tallyUserInvite);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyUserInvite> findPage(PageWrap<TallyUserInvite> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyUserInvite tallyUserInvite);
}