package com.tally.service.tallybilldetail.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybilldetail.TallyBillDetailMapper;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.dao.tallybilldetail.model.TallyBillDetailExample;
import com.tally.service.tallybilldetail.TallyBillDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 账单明细Service实现
 * @author 131****2893
 * @date 2021/04/13 19:31
 */
@Service
public class TallyBillDetailServiceImpl implements TallyBillDetailService {

    @Autowired
    private TallyBillDetailMapper tallyBillDetailMapper;

    @Override
    public Integer create(TallyBillDetail tallyBillDetail) {
        tallyBillDetailMapper.insertSelective(tallyBillDetail);
        return tallyBillDetail.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyBillDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyBillDetail tallyBillDetail) {
        tallyBillDetailMapper.updateByPrimaryKeySelective(tallyBillDetail);
    }

    @Override
    public void updateByIdInBatch(List<TallyBillDetail> tallyBillDetails) {
        if (CollectionUtils.isEmpty(tallyBillDetails)) return;
        for (TallyBillDetail tallyBillDetail: tallyBillDetails) {
            this.updateById(tallyBillDetail);
        }
    }

    @Override
    public TallyBillDetail findById(Integer id) {
        return tallyBillDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyBillDetail findOne(TallyBillDetail tallyBillDetail) {
        ExampleBuilder<TallyBillDetailExample, TallyBillDetailExample.Criteria> builder = ExampleBuilder.create(TallyBillDetailExample.class, TallyBillDetailExample.Criteria.class);
        List<TallyBillDetail> tallyBillDetails = tallyBillDetailMapper.selectByExample(builder.buildExamplePack(tallyBillDetail).getExample());
        if (tallyBillDetails.size() > 0) {
            return tallyBillDetails.get(0);
        }
        return null;
    }

    @Override
    public List<TallyBillDetail> findList(TallyBillDetail tallyBillDetail) {
        ExampleBuilder<TallyBillDetailExample, TallyBillDetailExample.Criteria> builder = ExampleBuilder.create(TallyBillDetailExample.class, TallyBillDetailExample.Criteria.class);
        return tallyBillDetailMapper.selectByExample(builder.buildExamplePack(tallyBillDetail).getExample());
    }
  
    @Override
    public PageData<TallyBillDetail> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyBillDetailExample, TallyBillDetailExample.Criteria> builder = ExampleBuilder.create(TallyBillDetailExample.class, TallyBillDetailExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyBillDetailExample, TallyBillDetailExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyBillDetailMapper.selectByExample(pack.getExample())));
    }

    @Override
    public PageData<TallyBillDetail> findCollectPage(Integer page, List<TallyBill> bills) {
        PageHelper.startPage(page, 10);
        List<Integer> billIds = bills.stream().map(TallyBill::getId).collect(Collectors.toList());
        return PageData.from(new PageInfo<>(tallyBillDetailMapper.findCollectLList(billIds)));
    }

    @Override
    public long count(TallyBillDetail tallyBillDetail) {
        ExampleBuilder<TallyBillDetailExample, TallyBillDetailExample.Criteria> builder = ExampleBuilder.create(TallyBillDetailExample.class, TallyBillDetailExample.Criteria.class);
        return tallyBillDetailMapper.countByExample(builder.buildExamplePack(tallyBillDetail).getExample());
    }
}