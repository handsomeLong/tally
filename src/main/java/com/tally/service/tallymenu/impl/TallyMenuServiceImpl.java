package com.tally.service.tallymenu.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallymenu.TallyMenuMapper;
import com.tally.dao.tallymenu.model.TallyMenu;
import com.tally.dao.tallymenu.model.TallyMenuExample;
import com.tally.service.tallymenu.TallyMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户菜单Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyMenuServiceImpl implements TallyMenuService {

    @Autowired
    private TallyMenuMapper tallyMenuMapper;

    @Override
    public Integer create(TallyMenu tallyMenu) {
        tallyMenuMapper.insertSelective(tallyMenu);
        return tallyMenu.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyMenuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyMenu tallyMenu) {
        tallyMenuMapper.updateByPrimaryKeySelective(tallyMenu);
    }

    @Override
    public void updateByIdInBatch(List<TallyMenu> tallyMenus) {
        if (CollectionUtils.isEmpty(tallyMenus)) return;
        for (TallyMenu tallyMenu: tallyMenus) {
            this.updateById(tallyMenu);
        }
    }

    @Override
    public TallyMenu findById(Integer id) {
        return tallyMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyMenu findOne(TallyMenu tallyMenu) {
        ExampleBuilder<TallyMenuExample, TallyMenuExample.Criteria> builder = ExampleBuilder.create(TallyMenuExample.class, TallyMenuExample.Criteria.class);
        List<TallyMenu> tallyMenus = tallyMenuMapper.selectByExample(builder.buildExamplePack(tallyMenu).getExample());
        if (tallyMenus.size() > 0) {
            return tallyMenus.get(0);
        }
        return null;
    }

    @Override
    public List<TallyMenu> findList(TallyMenu tallyMenu) {
        ExampleBuilder<TallyMenuExample, TallyMenuExample.Criteria> builder = ExampleBuilder.create(TallyMenuExample.class, TallyMenuExample.Criteria.class);
        return tallyMenuMapper.selectByExample(builder.buildExamplePack(tallyMenu).getExample());
    }
  
    @Override
    public PageData<TallyMenu> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyMenuExample, TallyMenuExample.Criteria> builder = ExampleBuilder.create(TallyMenuExample.class, TallyMenuExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyMenuExample, TallyMenuExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyMenuMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyMenu tallyMenu) {
        ExampleBuilder<TallyMenuExample, TallyMenuExample.Criteria> builder = ExampleBuilder.create(TallyMenuExample.class, TallyMenuExample.Criteria.class);
        return tallyMenuMapper.countByExample(builder.buildExamplePack(tallyMenu).getExample());
    }
}