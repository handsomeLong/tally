package com.tally.service.tallyrolemenu;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyrolemenu.model.TallyRoleMenu;
import java.util.List;

/**
 * 角色菜单关系表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyRoleMenuService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyRoleMenu tallyRoleMenu);

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
    void updateById(TallyRoleMenu tallyRoleMenu);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyRoleMenu> tallyRoleMenus);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyRoleMenu findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyRoleMenu findOne(TallyRoleMenu tallyRoleMenu);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyRoleMenu> findList(TallyRoleMenu tallyRoleMenu);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyRoleMenu> findPage(PageWrap<TallyRoleMenu> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyRoleMenu tallyRoleMenu);
}