package com.tally.service.tallystoragecheck.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallystoragecheck.TallyStorageCheckMapper;
import com.tally.dao.tallystoragecheck.model.TallyStorageCheck;
import com.tally.dao.tallystoragecheck.model.TallyStorageCheckExample;
import com.tally.service.tallystoragecheck.TallyStorageCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 库存盘点Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyStorageCheckServiceImpl implements TallyStorageCheckService {

    @Autowired
    private TallyStorageCheckMapper tallyStorageCheckMapper;

    @Override
    public Integer create(TallyStorageCheck tallyStorageCheck) {
        tallyStorageCheckMapper.insertSelective(tallyStorageCheck);
        return tallyStorageCheck.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyStorageCheckMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyStorageCheck tallyStorageCheck) {
        tallyStorageCheckMapper.updateByPrimaryKeySelective(tallyStorageCheck);
    }

    @Override
    public void updateByIdInBatch(List<TallyStorageCheck> tallyStorageChecks) {
        if (CollectionUtils.isEmpty(tallyStorageChecks)) return;
        for (TallyStorageCheck tallyStorageCheck: tallyStorageChecks) {
            this.updateById(tallyStorageCheck);
        }
    }

    @Override
    public TallyStorageCheck findById(Integer id) {
        return tallyStorageCheckMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyStorageCheck findOne(TallyStorageCheck tallyStorageCheck) {
        ExampleBuilder<TallyStorageCheckExample, TallyStorageCheckExample.Criteria> builder = ExampleBuilder.create(TallyStorageCheckExample.class, TallyStorageCheckExample.Criteria.class);
        List<TallyStorageCheck> tallyStorageChecks = tallyStorageCheckMapper.selectByExample(builder.buildExamplePack(tallyStorageCheck).getExample());
        if (tallyStorageChecks.size() > 0) {
            return tallyStorageChecks.get(0);
        }
        return null;
    }

    @Override
    public List<TallyStorageCheck> findList(TallyStorageCheck tallyStorageCheck) {
        ExampleBuilder<TallyStorageCheckExample, TallyStorageCheckExample.Criteria> builder = ExampleBuilder.create(TallyStorageCheckExample.class, TallyStorageCheckExample.Criteria.class);
        return tallyStorageCheckMapper.selectByExample(builder.buildExamplePack(tallyStorageCheck).getExample());
    }
  
    @Override
    public PageData<TallyStorageCheck> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyStorageCheckExample, TallyStorageCheckExample.Criteria> builder = ExampleBuilder.create(TallyStorageCheckExample.class, TallyStorageCheckExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyStorageCheckExample, TallyStorageCheckExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyStorageCheckMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyStorageCheck tallyStorageCheck) {
        ExampleBuilder<TallyStorageCheckExample, TallyStorageCheckExample.Criteria> builder = ExampleBuilder.create(TallyStorageCheckExample.class, TallyStorageCheckExample.Criteria.class);
        return tallyStorageCheckMapper.countByExample(builder.buildExamplePack(tallyStorageCheck).getExample());
    }
}