package com.tally.service.tallymemberfeesorder.impl;

import com.tally.api.inputDto.MemberfeesOrderInputDto;
import com.tally.api.inputDto.MiniPayInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallymemberfeesorder.TallyMemberfeesOrderMapper;
import com.tally.dao.tallymemberfeesorder.model.TallyMemberfeesOrder;
import com.tally.dao.tallymemberfeesorder.model.TallyMemberfeesOrderExample;
import com.tally.service.tallymemberfeesorder.TallyMemberfeesOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 会员缴费订单Service实现
 * @author 131****2893
 * @date 2020/10/31 21:47
 */
@Service
public class TallyMemberfeesOrderServiceImpl implements TallyMemberfeesOrderService {

    @Autowired
    private TallyMemberfeesOrderMapper tallyMemberfeesOrderMapper;

    @Override
    public Integer create(TallyMemberfeesOrder tallyMemberfeesOrder) {
        tallyMemberfeesOrderMapper.insertSelective(tallyMemberfeesOrder);
        return tallyMemberfeesOrder.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyMemberfeesOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyMemberfeesOrder tallyMemberfeesOrder) {
        tallyMemberfeesOrderMapper.updateByPrimaryKeySelective(tallyMemberfeesOrder);
    }

    @Override
    public void updateByIdInBatch(List<TallyMemberfeesOrder> tallyMemberfeesOrders) {
        if (CollectionUtils.isEmpty(tallyMemberfeesOrders)) return;
        for (TallyMemberfeesOrder tallyMemberfeesOrder: tallyMemberfeesOrders) {
            this.updateById(tallyMemberfeesOrder);
        }
    }

    @Override
    public TallyMemberfeesOrder findById(Integer id) {
        return tallyMemberfeesOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyMemberfeesOrder findOne(TallyMemberfeesOrder tallyMemberfeesOrder) {
        ExampleBuilder<TallyMemberfeesOrderExample, TallyMemberfeesOrderExample.Criteria> builder = ExampleBuilder.create(TallyMemberfeesOrderExample.class, TallyMemberfeesOrderExample.Criteria.class);
        List<TallyMemberfeesOrder> tallyMemberfeesOrders = tallyMemberfeesOrderMapper.selectByExample(builder.buildExamplePack(tallyMemberfeesOrder).getExample());
        if (tallyMemberfeesOrders.size() > 0) {
            return tallyMemberfeesOrders.get(0);
        }
        return null;
    }

    @Override
    public List<TallyMemberfeesOrder> findList(TallyMemberfeesOrder tallyMemberfeesOrder) {
        ExampleBuilder<TallyMemberfeesOrderExample, TallyMemberfeesOrderExample.Criteria> builder = ExampleBuilder.create(TallyMemberfeesOrderExample.class, TallyMemberfeesOrderExample.Criteria.class);
        return tallyMemberfeesOrderMapper.selectByExample(builder.buildExamplePack(tallyMemberfeesOrder).getExample());
    }
  
    @Override
    public PageData<TallyMemberfeesOrder> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyMemberfeesOrderExample, TallyMemberfeesOrderExample.Criteria> builder = ExampleBuilder.create(TallyMemberfeesOrderExample.class, TallyMemberfeesOrderExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyMemberfeesOrderExample, TallyMemberfeesOrderExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyMemberfeesOrderMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyMemberfeesOrder tallyMemberfeesOrder) {
        ExampleBuilder<TallyMemberfeesOrderExample, TallyMemberfeesOrderExample.Criteria> builder = ExampleBuilder.create(TallyMemberfeesOrderExample.class, TallyMemberfeesOrderExample.Criteria.class);
        return tallyMemberfeesOrderMapper.countByExample(builder.buildExamplePack(tallyMemberfeesOrder).getExample());
    }

    @Override
    public ApiResponse addOrder(MemberfeesOrderInputDto memberfeesOrderInputDto, String userId) {
//        tallyMemberfeesOrderMapper.insertSelective(tallyMemberfeesOrder);
        return ApiResponse.success(null);
    }

    @Override
    public ApiResponse saveMiniPay(MiniPayInputDto miniPayInputDto, String userId) {
        return null;
    }
}