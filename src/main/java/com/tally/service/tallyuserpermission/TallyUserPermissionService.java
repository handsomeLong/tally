package com.tally.service.tallyuserpermission;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserpermission.model.TallyUserPermission;
import java.util.List;

/**
 * 用户权限表Service定义
 * @author 我是传奇
 * @date 2021/07/21 10:16
 */
public interface TallyUserPermissionService {

    /**
     * 创建
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    Long create(TallyUserPermission tallyUserPermission);

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
    void updateById(TallyUserPermission tallyUserPermission);

    /**
     * 批量主键更新
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    void updateByIdInBatch(List<TallyUserPermission> tallyUserPermissions);

    /**
     * 主键查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    TallyUserPermission findById(Long id);

    /**
     * 条件查询单条记录
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    TallyUserPermission findOne(TallyUserPermission tallyUserPermission);

    /**
     * 条件查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    List<TallyUserPermission> findList(TallyUserPermission tallyUserPermission);
  
    /**
     * 分页查询
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    PageData<TallyUserPermission> findPage(PageWrap<TallyUserPermission> pageWrap);

    /**
     * 条件统计
     * @author 我是传奇
     * @date 2021/07/21 10:16
     */
    long count(TallyUserPermission tallyUserPermission);
}
