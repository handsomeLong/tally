package com.tally.service.tallystoragelog.impl;

import com.tally.api.outputDto.TallyStorageLogOutDto;
import com.tally.core.enums.OrderTypeEnums;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallystoragelog.TallyStorageLogMapper;
import com.tally.dao.tallystoragelog.model.TallyStorageLog;
import com.tally.dao.tallystoragelog.model.TallyStorageLogExample;
import com.tally.service.tallystoragelog.TallyStorageLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 库存变动日志Service实现
 * @author 131****2893
 * @date 2021/01/19 11:17
 */
@Service
public class TallyStorageLogServiceImpl implements TallyStorageLogService {

    @Autowired
    private TallyStorageLogMapper tallyStorageLogMapper;

    @Override
    public Integer create(TallyStorageLog tallyStorageLog) {
        tallyStorageLogMapper.insertSelective(tallyStorageLog);
        return tallyStorageLog.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyStorageLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyStorageLog tallyStorageLog) {
        tallyStorageLogMapper.updateByPrimaryKeySelective(tallyStorageLog);
    }

    @Override
    public void updateByIdInBatch(List<TallyStorageLog> tallyStorageLogs) {
        if (CollectionUtils.isEmpty(tallyStorageLogs)) return;
        for (TallyStorageLog tallyStorageLog: tallyStorageLogs) {
            this.updateById(tallyStorageLog);
        }
    }

    @Override
    public TallyStorageLog findById(Integer id) {
        return tallyStorageLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyStorageLog findOne(TallyStorageLog tallyStorageLog) {
        ExampleBuilder<TallyStorageLogExample, TallyStorageLogExample.Criteria> builder = ExampleBuilder.create(TallyStorageLogExample.class, TallyStorageLogExample.Criteria.class);
        List<TallyStorageLog> tallyStorageLogs = tallyStorageLogMapper.selectByExample(builder.buildExamplePack(tallyStorageLog).getExample());
        if (tallyStorageLogs.size() > 0) {
            return tallyStorageLogs.get(0);
        }
        return null;
    }

    @Override
    public List<TallyStorageLog> findList(TallyStorageLog tallyStorageLog) {
        ExampleBuilder<TallyStorageLogExample, TallyStorageLogExample.Criteria> builder = ExampleBuilder.create(TallyStorageLogExample.class, TallyStorageLogExample.Criteria.class);
        return tallyStorageLogMapper.selectByExample(builder.buildExamplePack(tallyStorageLog).getExample());
    }
  
    @Override
    public PageData<TallyStorageLog> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyStorageLogExample, TallyStorageLogExample.Criteria> builder = ExampleBuilder.create(TallyStorageLogExample.class, TallyStorageLogExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyStorageLogExample, TallyStorageLogExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyStorageLogMapper.selectByExample(pack.getExample())));
    }
    @Override
    public PageData<TallyStorageLogOutDto> findPageWithSpec(PageWrap<TallyStorageLog> pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        List<TallyStorageLogOutDto>  list =  tallyStorageLogMapper.findPageWithSpec(pageWrap.getModel().getUserId(),pageWrap.getModel().getSpecId());
        return PageData.from(new PageInfo<>(list));
    }
    @Override
    public long count(TallyStorageLog tallyStorageLog) {
        ExampleBuilder<TallyStorageLogExample, TallyStorageLogExample.Criteria> builder = ExampleBuilder.create(TallyStorageLogExample.class, TallyStorageLogExample.Criteria.class);
        return tallyStorageLogMapper.countByExample(builder.buildExamplePack(tallyStorageLog).getExample());
    }


}