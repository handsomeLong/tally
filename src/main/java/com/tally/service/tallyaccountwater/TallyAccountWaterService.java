package com.tally.service.tallyaccountwater;

import com.tally.api.inputDto.*;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccountwater.model.TallyAccountWater;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 账户流水Service定义
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
public interface TallyAccountWaterService {

    /**
     * 创建
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    Integer create(TallyAccountWater tallyAccountWater);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void updateById(TallyAccountWater tallyAccountWater);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    void updateByIdInBatch(List<TallyAccountWater> tallyAccountWaters);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyAccountWater findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    TallyAccountWater findOne(TallyAccountWater tallyAccountWater);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    List<TallyAccountWater> findList(TallyAccountWater tallyAccountWater);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    PageData<TallyAccountWater> findPage(PageWrap<TallyAccountWater> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    long count(TallyAccountWater tallyAccountWater);

    void addWater(AddWaterInputDto addWaterInputDto) throws ParseException, Exception;

    PageData<TallyAccountWater> findCollectPage(PageWrap pageWrap, WaterDetailCollectInputDto inputDto);

    TallyAccountWater saveByOrder(TallyOrder tallyOrder, List<TallyOrderProduct> list);

    void addQuickAccount(AddWaterInputDto addWaterInputDto);

    void addWater(BigDecimal totalPrice, Integer suClassType, AddBillInputDto addBillInputDto, List<BillDetailInputDto> productSpecList,Integer billId);

    void saveByBill(TallyBill bill);

    void addCollection(AddCollectionInputDto addCollectionInputDto);

    PageData<TallyAccountWater> waterCollectPage(TallyAccountWater tallyAccountWater, Integer page);

    void saveCollection(TallyBill bill);

    TallyAccountWater findWater(TallyAccountWater tallyAccountWater);

    PageData<TallyAccountWater> findReportPage(BillReportInputDto billReportInputDto);

    Map billReportCount(BillReportInputDto billReportInputDto);
}