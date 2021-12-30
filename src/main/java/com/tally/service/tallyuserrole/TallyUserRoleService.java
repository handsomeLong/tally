package com.tally.service.tallyuserrole;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyuserrole.model.TallyUserRole;
import java.util.List;

/**
 * 用户角色关系表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyUserRoleService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyUserRole tallyUserRole);

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
    void updateById(TallyUserRole tallyUserRole);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyUserRole> tallyUserRoles);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUserRole findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyUserRole findOne(TallyUserRole tallyUserRole);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyUserRole> findList(TallyUserRole tallyUserRole);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyUserRole> findPage(PageWrap<TallyUserRole> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyUserRole tallyUserRole);
}