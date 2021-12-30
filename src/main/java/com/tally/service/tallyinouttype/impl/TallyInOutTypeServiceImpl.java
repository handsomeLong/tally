package com.tally.service.tallyinouttype.impl;

import com.tally.api.outputDto.TallyTypeOutputDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallybusinesstype.TallyBusinessTypeMapper;
import com.tally.dao.tallybusinesstype.model.TallyBusinessType;
import com.tally.dao.tallyinouttype.TallyInOutTypeMapper;
import com.tally.dao.tallyinouttype.model.TallyInOutType;
import com.tally.dao.tallyinouttype.model.TallyInOutTypeExample;
import com.tally.service.tallyinouttype.TallyInOutTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 收支类型Service实现
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@Service
public class TallyInOutTypeServiceImpl implements TallyInOutTypeService {

    @Autowired
    private TallyInOutTypeMapper tallyInOutTypeMapper;
    @Autowired
    private TallyBusinessTypeMapper tallyBusinessTypeMapper;

    @Override
    public Integer create(TallyInOutType tallyInOutType) {
        tallyInOutTypeMapper.insertSelective(tallyInOutType);
        return tallyInOutType.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyInOutTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyInOutType tallyInOutType) {
        tallyInOutTypeMapper.updateByPrimaryKeySelective(tallyInOutType);
    }

    @Override
    public void updateByIdInBatch(List<TallyInOutType> tallyInOutTypes) {
        if (CollectionUtils.isEmpty(tallyInOutTypes)) return;
        for (TallyInOutType tallyInOutType: tallyInOutTypes) {
            this.updateById(tallyInOutType);
        }
    }

    @Override
    public TallyInOutType findById(Integer id) {
        return tallyInOutTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyInOutType findOne(TallyInOutType tallyInOutType) {
        ExampleBuilder<TallyInOutTypeExample, TallyInOutTypeExample.Criteria> builder = ExampleBuilder.create(TallyInOutTypeExample.class, TallyInOutTypeExample.Criteria.class);
        List<TallyInOutType> tallyInOutTypes = tallyInOutTypeMapper.selectByExample(builder.buildExamplePack(tallyInOutType).getExample());
        if (tallyInOutTypes.size() > 0) {
            return tallyInOutTypes.get(0);
        }
        return null;
    }

    @Override
    public List<TallyInOutType> findList(TallyInOutType tallyInOutType) {
        ExampleBuilder<TallyInOutTypeExample, TallyInOutTypeExample.Criteria> builder = ExampleBuilder.create(TallyInOutTypeExample.class, TallyInOutTypeExample.Criteria.class);
        return tallyInOutTypeMapper.selectByExample(builder.buildExamplePack(tallyInOutType).getExample());
    }
  
    @Override
    public PageData<TallyInOutType> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyInOutTypeExample, TallyInOutTypeExample.Criteria> builder = ExampleBuilder.create(TallyInOutTypeExample.class, TallyInOutTypeExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyInOutTypeExample, TallyInOutTypeExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyInOutTypeMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyInOutType tallyInOutType) {
        ExampleBuilder<TallyInOutTypeExample, TallyInOutTypeExample.Criteria> builder = ExampleBuilder.create(TallyInOutTypeExample.class, TallyInOutTypeExample.Criteria.class);
        return tallyInOutTypeMapper.countByExample(builder.buildExamplePack(tallyInOutType).getExample());
    }

    @Override
    public TallyTypeOutputDto save(TallyInOutType tallyInOutType) {
        tallyInOutType.setBooksId(0);
        tallyInOutTypeMapper.insertSelective(tallyInOutType);
        TallyTypeOutputDto tallyTypeOutputDto = new TallyTypeOutputDto();
        TallyBusinessType btype = tallyBusinessTypeMapper.findByType(tallyInOutType.getType());
        tallyTypeOutputDto.setTypeId(btype.getId());
        tallyTypeOutputDto.setType(btype.getType());
        tallyTypeOutputDto.setTypeName(btype.getTypeName());
        tallyTypeOutputDto.setTypeCode(btype.getTypeCode());
        tallyTypeOutputDto.setSubClassType(btype.getSubClassType());
        tallyTypeOutputDto.setInOutTypeId(tallyInOutType.getId());
        tallyTypeOutputDto.setInOutTypeName(tallyInOutType.getTypeName());
        tallyTypeOutputDto.setCollectTypeName(btype.getTypeName()+"-"+tallyInOutType.getTypeName());
        return tallyTypeOutputDto;
    }
}