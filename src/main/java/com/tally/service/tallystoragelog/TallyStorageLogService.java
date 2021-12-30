package com.tally.service.tallystoragelog;

import com.tally.api.outputDto.TallyStorageLogOutDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallystoragelog.model.TallyStorageLog;
import java.util.List;

/**
 * 库存变动日志Service定义
 * @author 131****2893
 * @date 2021/01/19 11:17
 */
public interface TallyStorageLogService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    Integer create(TallyStorageLog tallyStorageLog);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    void updateById(TallyStorageLog tallyStorageLog);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    void updateByIdInBatch(List<TallyStorageLog> tallyStorageLogs);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    TallyStorageLog findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    TallyStorageLog findOne(TallyStorageLog tallyStorageLog);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    List<TallyStorageLog> findList(TallyStorageLog tallyStorageLog);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    PageData<TallyStorageLog> findPage(PageWrap<TallyStorageLog> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    long count(TallyStorageLog tallyStorageLog);

    PageData<TallyStorageLogOutDto> findPageWithSpec(PageWrap<TallyStorageLog> pageWrap);
}