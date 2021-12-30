package com.tally.service.tallyworkorder.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tally.api.inputDto.WorkOrderInputDto;
import com.tally.api.inputDto.WorkOrderProductInputDto;
import com.tally.api.outputDto.TallyWorkOrderOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.DateUtils;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyworkorder.TallyWorkOrderMapper;
import com.tally.dao.tallyworkorder.model.TallyWorkOrder;
import com.tally.dao.tallyworkorder.model.TallyWorkOrderExample;
import com.tally.dao.tallyworkorderproduct.TallyWorkOrderProductMapper;
import com.tally.dao.tallyworkorderproduct.model.TallyWorkOrderProduct;
import com.tally.service.tallyworkorder.TallyWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 生产单Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyWorkOrderServiceImpl implements TallyWorkOrderService {

    @Autowired
    private TallyWorkOrderMapper tallyWorkOrderMapper;

    @Autowired
    private TallyWorkOrderProductMapper tallyWorkOrderProductMapper;

    @Override
    public Integer create(TallyWorkOrder tallyWorkOrder) {
        tallyWorkOrderMapper.insertSelective(tallyWorkOrder);
        return tallyWorkOrder.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyWorkOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyWorkOrder tallyWorkOrder) {
        tallyWorkOrderMapper.updateByPrimaryKeySelective(tallyWorkOrder);
    }

    @Override
    public void updateByIdInBatch(List<TallyWorkOrder> tallyWorkOrders) {
        if (CollectionUtils.isEmpty(tallyWorkOrders)) return;
        for (TallyWorkOrder tallyWorkOrder: tallyWorkOrders) {
            this.updateById(tallyWorkOrder);
        }
    }

    @Override
    public TallyWorkOrder findById(Integer id) {
        return tallyWorkOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyWorkOrderOutputDto findOne(TallyWorkOrder tallyWorkOrder) {
        ExampleBuilder<TallyWorkOrderExample, TallyWorkOrderExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderExample.class, TallyWorkOrderExample.Criteria.class);
        List<TallyWorkOrderOutputDto> tallyWorkOrders = tallyWorkOrderMapper.selectByExample(builder.buildExamplePack(tallyWorkOrder).getExample());
        if (tallyWorkOrders.size() > 0) {
            return tallyWorkOrders.get(0);
        }
        return null;
    }

    @Override
    public List<TallyWorkOrderOutputDto> findList(TallyWorkOrder tallyWorkOrder) {
        ExampleBuilder<TallyWorkOrderExample, TallyWorkOrderExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderExample.class, TallyWorkOrderExample.Criteria.class);
        return tallyWorkOrderMapper.selectByExample(builder.buildExamplePack(tallyWorkOrder).getExample());
    }

    @Override
    public PageData<TallyWorkOrderOutputDto> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyWorkOrderExample, TallyWorkOrderExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderExample.class, TallyWorkOrderExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyWorkOrderExample, TallyWorkOrderExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyWorkOrderMapper.selectByExample(pack.getExample())));
    }

    @Override
    @Transactional
    public ApiResponse addOrder(WorkOrderInputDto workOrderInputDto, String userId) {
        ApiResponse  apiResponse = ApiResponse.failed("下单失败！");
        try {
            //保存 tallyWorkOrder 表
            TallyWorkOrder tallyWorkOrder = new TallyWorkOrder();
            tallyWorkOrder.setOrderId(workOrderInputDto.getOrderId());
            tallyWorkOrder.setOrderNo(workOrderInputDto.getOrderNo());
            tallyWorkOrder.setAuitStatus(100);
            Date beginDate = DateUtils.getDate(workOrderInputDto.getBeginTime(), "yyyy-MM-dd");
            Date endDate = DateUtils.getDate(workOrderInputDto.getEndTime(), "yyyy-MM-dd");
            tallyWorkOrder.setBeginTime(beginDate);
            tallyWorkOrder.setEndTime(endDate);
            int workDate = DateUtils.diffDate(endDate, beginDate);
            tallyWorkOrder.setWorkDay(workDate);
            tallyWorkOrder.setInitiator(userId);
            tallyWorkOrder.setName(workOrderInputDto.getName());
            tallyWorkOrder.setPrincipal(workOrderInputDto.getPrincipal());
            tallyWorkOrder.setStatus(100);
            tallyWorkOrder.setVersion(0);
            tallyWorkOrder.setRemark(workOrderInputDto.getRemark());
            tallyWorkOrderMapper.insertSelective(tallyWorkOrder);
            //保存 tally_work_order_product 关系表
            List<TallyWorkOrderProduct> list = new ArrayList<>();
            for (WorkOrderProductInputDto wp: workOrderInputDto.getList()) {
                TallyWorkOrderProduct twp = new TallyWorkOrderProduct();
                twp.setProductId(wp.getProductId());
                twp.setProductSpecId(wp.getProductSpecId());
                twp.setWorkOrderId(tallyWorkOrder.getId());
                twp.setProductSpecNum(wp.getProductSpecNum());
                twp.setProductName(wp.getProductName());
                twp.setProductSpecName(wp.getProductSpecName());
                list.add(twp);
            }
            if(list.size()>0)
            tallyWorkOrderProductMapper.insertBatch(list);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("下单成功!");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setMessage("下单异常--"+e.getMessage());
        }
        return apiResponse;
    }

    @Override
    public long count(TallyWorkOrder tallyWorkOrder) {
        ExampleBuilder<TallyWorkOrderExample, TallyWorkOrderExample.Criteria> builder = ExampleBuilder.create(TallyWorkOrderExample.class, TallyWorkOrderExample.Criteria.class);
        return tallyWorkOrderMapper.countByExample(builder.buildExamplePack(tallyWorkOrder).getExample());
    }
}