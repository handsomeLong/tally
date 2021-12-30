package com.tally.service.tallyaccountlog.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyaccountlog.TallyAccountLogMapper;
import com.tally.dao.tallyaccountlog.model.TallyAccountLog;
import com.tally.dao.tallyaccountlog.model.TallyAccountLogExample;
import com.tally.service.tallyaccountlog.TallyAccountLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 账户变动日志Service实现
 * @author 131****2893
 * @date 2021/01/18 20:49
 */
@Service
public class TallyAccountLogServiceImpl implements TallyAccountLogService {

    @Autowired
    private TallyAccountLogMapper tallyAccountLogMapper;

    @Override
    public Integer create(TallyAccountLog tallyAccountLog) {
        tallyAccountLogMapper.insertSelective(tallyAccountLog);
        return tallyAccountLog.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyAccountLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyAccountLog tallyAccountLog) {
        tallyAccountLogMapper.updateByPrimaryKeySelective(tallyAccountLog);
    }

    @Override
    public void updateByIdInBatch(List<TallyAccountLog> tallyAccountLogs) {
        if (CollectionUtils.isEmpty(tallyAccountLogs)) return;
        for (TallyAccountLog tallyAccountLog: tallyAccountLogs) {
            this.updateById(tallyAccountLog);
        }
    }

    @Override
    public TallyAccountLog findById(Integer id) {
        return tallyAccountLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyAccountLog findOne(TallyAccountLog tallyAccountLog) {
        ExampleBuilder<TallyAccountLogExample, TallyAccountLogExample.Criteria> builder = ExampleBuilder.create(TallyAccountLogExample.class, TallyAccountLogExample.Criteria.class);
        List<TallyAccountLog> tallyAccountLogs = tallyAccountLogMapper.selectByExample(builder.buildExamplePack(tallyAccountLog).getExample());
        if (tallyAccountLogs.size() > 0) {
            return tallyAccountLogs.get(0);
        }
        return null;
    }

    @Override
    public List<TallyAccountLog> findList(TallyAccountLog tallyAccountLog) {
        ExampleBuilder<TallyAccountLogExample, TallyAccountLogExample.Criteria> builder = ExampleBuilder.create(TallyAccountLogExample.class, TallyAccountLogExample.Criteria.class);
        return tallyAccountLogMapper.selectByExample(builder.buildExamplePack(tallyAccountLog).getExample());
    }
  
    @Override
    public PageData<TallyAccountLog> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyAccountLogExample, TallyAccountLogExample.Criteria> builder = ExampleBuilder.create(TallyAccountLogExample.class, TallyAccountLogExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyAccountLogExample, TallyAccountLogExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyAccountLogMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyAccountLog tallyAccountLog) {
        ExampleBuilder<TallyAccountLogExample, TallyAccountLogExample.Criteria> builder = ExampleBuilder.create(TallyAccountLogExample.class, TallyAccountLogExample.Criteria.class);
        return tallyAccountLogMapper.countByExample(builder.buildExamplePack(tallyAccountLog).getExample());
    }
}