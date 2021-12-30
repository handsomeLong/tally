package com.tally.service.tallyrolemenu.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyrolemenu.TallyRoleMenuMapper;
import com.tally.dao.tallyrolemenu.model.TallyRoleMenu;
import com.tally.dao.tallyrolemenu.model.TallyRoleMenuExample;
import com.tally.service.tallyrolemenu.TallyRoleMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 角色菜单关系表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyRoleMenuServiceImpl implements TallyRoleMenuService {

    @Autowired
    private TallyRoleMenuMapper tallyRoleMenuMapper;

    @Override
    public Integer create(TallyRoleMenu tallyRoleMenu) {
        tallyRoleMenuMapper.insertSelective(tallyRoleMenu);
        return tallyRoleMenu.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyRoleMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyRoleMenu tallyRoleMenu) {
        tallyRoleMenuMapper.updateByPrimaryKeySelective(tallyRoleMenu);
    }

    @Override
    public void updateByIdInBatch(List<TallyRoleMenu> tallyRoleMenus) {
        if (CollectionUtils.isEmpty(tallyRoleMenus)) return;
        for (TallyRoleMenu tallyRoleMenu: tallyRoleMenus) {
            this.updateById(tallyRoleMenu);
        }
    }

    @Override
    public TallyRoleMenu findById(Integer id) {
        return tallyRoleMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyRoleMenu findOne(TallyRoleMenu tallyRoleMenu) {
        ExampleBuilder<TallyRoleMenuExample, TallyRoleMenuExample.Criteria> builder = ExampleBuilder.create(TallyRoleMenuExample.class, TallyRoleMenuExample.Criteria.class);
        List<TallyRoleMenu> tallyRoleMenus = tallyRoleMenuMapper.selectByExample(builder.buildExamplePack(tallyRoleMenu).getExample());
        if (tallyRoleMenus.size() > 0) {
            return tallyRoleMenus.get(0);
        }
        return null;
    }

    @Override
    public List<TallyRoleMenu> findList(TallyRoleMenu tallyRoleMenu) {
        ExampleBuilder<TallyRoleMenuExample, TallyRoleMenuExample.Criteria> builder = ExampleBuilder.create(TallyRoleMenuExample.class, TallyRoleMenuExample.Criteria.class);
        return tallyRoleMenuMapper.selectByExample(builder.buildExamplePack(tallyRoleMenu).getExample());
    }
  
    @Override
    public PageData<TallyRoleMenu> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyRoleMenuExample, TallyRoleMenuExample.Criteria> builder = ExampleBuilder.create(TallyRoleMenuExample.class, TallyRoleMenuExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyRoleMenuExample, TallyRoleMenuExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyRoleMenuMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyRoleMenu tallyRoleMenu) {
        ExampleBuilder<TallyRoleMenuExample, TallyRoleMenuExample.Criteria> builder = ExampleBuilder.create(TallyRoleMenuExample.class, TallyRoleMenuExample.Criteria.class);
        return tallyRoleMenuMapper.countByExample(builder.buildExamplePack(tallyRoleMenu).getExample());
    }
}