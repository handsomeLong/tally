package com.tally.service.tallyaccountwaterdetail.impl;

import com.tally.api.inputDto.BillReportInputDto;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyaccountwaterdetail.TallyAccountWaterDetailMapper;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetail;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetailExample;
import com.tally.service.tallyaccountwaterdetail.TallyAccountWaterDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账户流水明细Service实现
 * @author 131****2893
 * @date 2021/01/08 14:39
 */
@Service
public class TallyAccountWaterDetailServiceImpl implements TallyAccountWaterDetailService {

    @Autowired
    private TallyAccountWaterDetailMapper tallyAccountWaterDetailMapper;

    @Override
    public Integer create(TallyAccountWaterDetail tallyAccountWaterDetail) {
        tallyAccountWaterDetailMapper.insertSelective(tallyAccountWaterDetail);
        return tallyAccountWaterDetail.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyAccountWaterDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyAccountWaterDetail tallyAccountWaterDetail) {
        tallyAccountWaterDetailMapper.updateByPrimaryKeySelective(tallyAccountWaterDetail);
    }

    @Override
    public void updateByIdInBatch(List<TallyAccountWaterDetail> tallyAccountWaterDetails) {
        if (CollectionUtils.isEmpty(tallyAccountWaterDetails)) return;
        for (TallyAccountWaterDetail tallyAccountWaterDetail: tallyAccountWaterDetails) {
            this.updateById(tallyAccountWaterDetail);
        }
    }

    @Override
    public TallyAccountWaterDetail findById(Integer id) {
        return tallyAccountWaterDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public WaterDetailOutputDto findOne(TallyAccountWaterDetail tallyAccountWaterDetail) {
        ExampleBuilder<TallyAccountWaterDetailExample, TallyAccountWaterDetailExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterDetailExample.class, TallyAccountWaterDetailExample.Criteria.class);
        List<WaterDetailOutputDto> tallyAccountWaterDetails = tallyAccountWaterDetailMapper.selectByExample(builder.buildExamplePack(tallyAccountWaterDetail).getExample());
        if (tallyAccountWaterDetails.size() > 0) {
            return tallyAccountWaterDetails.get(0);
        }
        return null;
    }

    @Override
    public List<WaterDetailOutputDto> findList(TallyAccountWaterDetail tallyAccountWaterDetail,Date startTime,Date endTime) {
        ExampleBuilder<TallyAccountWaterDetailExample, TallyAccountWaterDetailExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterDetailExample.class, TallyAccountWaterDetailExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyAccountWaterDetailExample, TallyAccountWaterDetailExample.Criteria> pack = builder.buildExamplePack(tallyAccountWaterDetail);
        if(null!=startTime){
            pack.getCriteria().andDealTimeBetween(startTime,endTime);
        }
        return tallyAccountWaterDetailMapper.selectByExample(pack.getExample());}
  
    @Override
    public PageData<WaterDetailOutputDto> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyAccountWaterDetailExample, TallyAccountWaterDetailExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterDetailExample.class, TallyAccountWaterDetailExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyAccountWaterDetailExample, TallyAccountWaterDetailExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyAccountWaterDetailMapper.selectByExample(pack.getExample())));
    }

    @Override
    public PageData<WaterDetailOutputDto> findReportPage(BillReportInputDto inputDto) {
        PageHelper.startPage(inputDto.getPage(), inputDto.getCapacity());
        return PageData.from(new PageInfo<>(tallyAccountWaterDetailMapper.findReport(inputDto)));
    }

    @Override
    public Map<String, BigDecimal> billReportCount(BillReportInputDto inputDto) {
        List<WaterDetailOutputDto> list = tallyAccountWaterDetailMapper.findReport(inputDto);
        Map<String,BigDecimal> map = new HashMap<>();
        BigDecimal amount = BigDecimal.ZERO;
        if(list.size()>0)
            amount = new BigDecimal(list.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get());
        map.put("amount",amount);
        return map;
    }

    @Override
    public long count(TallyAccountWaterDetail tallyAccountWaterDetail) {
        ExampleBuilder<TallyAccountWaterDetailExample, TallyAccountWaterDetailExample.Criteria> builder = ExampleBuilder.create(TallyAccountWaterDetailExample.class, TallyAccountWaterDetailExample.Criteria.class);
        return tallyAccountWaterDetailMapper.countByExample(builder.buildExamplePack(tallyAccountWaterDetail).getExample());
    }

    @Override
    public List<TallyAccountWaterDetail> findDetailByBillId(Integer id) {
        return tallyAccountWaterDetailMapper.findDetailByBillId(id);
    }
}