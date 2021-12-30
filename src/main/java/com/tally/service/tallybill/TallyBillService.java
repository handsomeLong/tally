package com.tally.service.tallybill;

import com.tally.api.inputDto.AddBillInputDto;
import com.tally.api.inputDto.AddCollectionInputDto;
import com.tally.api.inputDto.AddCollectionShInputDto;
import com.tally.api.outputDto.TallyBillOutputDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybill.model.TallyBill;

import java.util.List;
import java.util.Map;

/**
 * 账单表Service定义
 * @author 131****2893
 * @date 2021/04/12 13:43
 */
public interface TallyBillService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    Integer create(TallyBill tallyBill);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    void updateById(TallyBill tallyBill);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    void updateByIdInBatch(List<TallyBill> tallyBills);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    TallyBill findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    TallyBill findOne(TallyBill tallyBill);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    List<TallyBill> findList(TallyBill tallyBill);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    PageData<TallyBill> findPage(PageWrap<TallyBill> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    long count(TallyBill tallyBill);

    /**
     * 新增账单
     * @param addBillInputDto
     * @return
     */
    Integer addBill(AddBillInputDto addBillInputDto);

    TallyBillOutputDto findBill(TallyBill tallyBill);

    List<TallyBill> findListByIds(String ids, String userId);

    void auitBill(String userId, Integer status, String ids) throws Exception;

    /**
     * 物料统计
     * @param bill
     * @return
     */
    Map<String,String> materialCount(TallyBill bill);

    PageData<TallyBill> findPage(List userIdList, List btypeUserIdList, TallyBill bill, Integer page);

    Map<String,String> sfCount(TallyBill bill);

    PageData<TallyBill> billCollectPage(TallyBill bill, Integer page);

    Integer addCollection(AddCollectionInputDto dto);

    PageData<TallyBill> findMaterialPage(Integer page, String userId, Integer status, Integer type, Integer btypeUserId);

    Integer updateByVersion(TallyBill b);

    PageData<TallyBill> findMaterialCollectPage(Integer page, String userId, Integer status, Integer type);

     List<TallyBill> getMaterialTallyBills(String userId, Integer status, Integer type,Integer btypeUserId);

    Integer addCollectionSh(AddCollectionShInputDto dto);
}