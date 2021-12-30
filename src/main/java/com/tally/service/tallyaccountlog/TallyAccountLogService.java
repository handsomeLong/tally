package com.tally.service.tallyaccountlog;

import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccountlog.model.TallyAccountLog;
import java.util.List;

/**
 * 账户变动日志Service定义
 * @author 131****2893
 * @date 2021/01/18 20:49
 */
public interface TallyAccountLogService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    Integer create(TallyAccountLog tallyAccountLog);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    void updateById(TallyAccountLog tallyAccountLog);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    void updateByIdInBatch(List<TallyAccountLog> tallyAccountLogs);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    TallyAccountLog findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    TallyAccountLog findOne(TallyAccountLog tallyAccountLog);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    List<TallyAccountLog> findList(TallyAccountLog tallyAccountLog);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    PageData<TallyAccountLog> findPage(PageWrap<TallyAccountLog> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/01/18 20:49
     */
    long count(TallyAccountLog tallyAccountLog);
}