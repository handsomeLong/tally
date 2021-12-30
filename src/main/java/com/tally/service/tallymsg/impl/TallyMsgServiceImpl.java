package com.tally.service.tallymsg.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallymsg.TallyMsgMapper;
import com.tally.dao.tallymsg.model.TallyMsg;
import com.tally.dao.tallymsg.model.TallyMsgExample;
import com.tally.service.tallymsg.TallyMsgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 消息Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyMsgServiceImpl implements TallyMsgService {

    @Autowired
    private TallyMsgMapper tallyMsgMapper;

    @Override
    public Integer create(TallyMsg tallyMsg) {
        tallyMsgMapper.insertSelective(tallyMsg);
        return tallyMsg.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyMsgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyMsg tallyMsg) {
        tallyMsgMapper.updateByPrimaryKeySelective(tallyMsg);
    }

    @Override
    public void updateByIdInBatch(List<TallyMsg> tallyMsgs) {
        if (CollectionUtils.isEmpty(tallyMsgs)) return;
        for (TallyMsg tallyMsg: tallyMsgs) {
            this.updateById(tallyMsg);
        }
    }

    @Override
    public TallyMsg findById(Integer id) {
        return tallyMsgMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyMsg findOne(TallyMsg tallyMsg) {
        ExampleBuilder<TallyMsgExample, TallyMsgExample.Criteria> builder = ExampleBuilder.create(TallyMsgExample.class, TallyMsgExample.Criteria.class);
        List<TallyMsg> tallyMsgs = tallyMsgMapper.selectByExample(builder.buildExamplePack(tallyMsg).getExample());
        if (tallyMsgs.size() > 0) {
            return tallyMsgs.get(0);
        }
        return null;
    }

    @Override
    public List<TallyMsg> findList(TallyMsg tallyMsg) {
        ExampleBuilder<TallyMsgExample, TallyMsgExample.Criteria> builder = ExampleBuilder.create(TallyMsgExample.class, TallyMsgExample.Criteria.class);
        return tallyMsgMapper.selectByExample(builder.buildExamplePack(tallyMsg).getExample());
    }
  
    @Override
    public PageData<TallyMsg> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyMsgExample, TallyMsgExample.Criteria> builder = ExampleBuilder.create(TallyMsgExample.class, TallyMsgExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyMsgExample, TallyMsgExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyMsgMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyMsg tallyMsg) {
        ExampleBuilder<TallyMsgExample, TallyMsgExample.Criteria> builder = ExampleBuilder.create(TallyMsgExample.class, TallyMsgExample.Criteria.class);
        return tallyMsgMapper.countByExample(builder.buildExamplePack(tallyMsg).getExample());
    }
}