package com.tally.service.tallyusergrade.impl;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyusergrade.TallyUserGradeMapper;
import com.tally.dao.tallyusergrade.model.TallyUserGrade;
import com.tally.dao.tallyusergrade.model.TallyUserGradeExample;
import com.tally.service.tallyusergrade.TallyUserGradeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户等级Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyUserGradeServiceImpl implements TallyUserGradeService {

    @Autowired
    private TallyUserGradeMapper tallyUserGradeMapper;

    @Override
    public Integer create(TallyUserGrade tallyUserGrade) {
        tallyUserGradeMapper.insertSelective(tallyUserGrade);
        return tallyUserGrade.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyUserGradeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyUserGrade tallyUserGrade) {
        tallyUserGradeMapper.updateByPrimaryKeySelective(tallyUserGrade);
    }

    @Override
    public void updateByIdInBatch(List<TallyUserGrade> tallyUserGrades) {
        if (CollectionUtils.isEmpty(tallyUserGrades)) return;
        for (TallyUserGrade tallyUserGrade: tallyUserGrades) {
            this.updateById(tallyUserGrade);
        }
    }

    @Override
    public TallyUserGrade findById(Integer id) {
        return tallyUserGradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyUserGrade findOne(TallyUserGrade tallyUserGrade) {
        ExampleBuilder<TallyUserGradeExample, TallyUserGradeExample.Criteria> builder = ExampleBuilder.create(TallyUserGradeExample.class, TallyUserGradeExample.Criteria.class);
        List<TallyUserGrade> tallyUserGrades = tallyUserGradeMapper.selectByExample(builder.buildExamplePack(tallyUserGrade).getExample());
        if (tallyUserGrades.size() > 0) {
            return tallyUserGrades.get(0);
        }
        return null;
    }

    @Override
    public List<TallyUserGrade> findList(TallyUserGrade tallyUserGrade) {
        ExampleBuilder<TallyUserGradeExample, TallyUserGradeExample.Criteria> builder = ExampleBuilder.create(TallyUserGradeExample.class, TallyUserGradeExample.Criteria.class);
        return tallyUserGradeMapper.selectByExample(builder.buildExamplePack(tallyUserGrade).getExample());
    }
  
    @Override
    public PageData<TallyUserGrade> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyUserGradeExample, TallyUserGradeExample.Criteria> builder = ExampleBuilder.create(TallyUserGradeExample.class, TallyUserGradeExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyUserGradeExample, TallyUserGradeExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyUserGradeMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyUserGrade tallyUserGrade) {
        ExampleBuilder<TallyUserGradeExample, TallyUserGradeExample.Criteria> builder = ExampleBuilder.create(TallyUserGradeExample.class, TallyUserGradeExample.Criteria.class);
        return tallyUserGradeMapper.countByExample(builder.buildExamplePack(tallyUserGrade).getExample());
    }
}