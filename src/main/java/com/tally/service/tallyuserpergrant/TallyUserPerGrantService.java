package com.tally.service.tallyuserpergrant;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserpergrant.model.TallyUserPerGrant;
import java.util.List;
import java.util.Map;

/**
 * 用户权限授权表Service定义
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
public interface TallyUserPerGrantService {

    /**
     * 创建
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    Integer create(TallyUserPerGrant tallyUserPerGrant);

    /**
     * 主键删除
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    void deleteById(Long id);

    /**
     * 批量主键删除
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    void deleteByIdInBatch(List<Long> ids);

    /**
     * 主键更新
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    void updateById(TallyUserPerGrant tallyUserPerGrant);

    /**
     * 批量主键更新
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    void updateByIdInBatch(List<TallyUserPerGrant> tallyUserPerGrants);

    /**
     * 主键查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    TallyUserPerGrant findById(Long id);

    /**
     * 条件查询单条记录
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    TallyUserPerGrant findOne(TallyUserPerGrant tallyUserPerGrant);

    /**
     * 条件查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    List<TallyUserPerGrant> findList(TallyUserPerGrant tallyUserPerGrant);
  
    /**
     * 分页查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    PageData<TallyUserPerGrant> findPage(PageWrap<TallyUserPerGrant> pageWrap);

    /**
     * 条件统计
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    long count(TallyUserPerGrant tallyUserPerGrant);

    Map<String,List> getGrantUserIds(String userId, String code);
}
