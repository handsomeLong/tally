package com.tally.service.tallyproductspec;

import com.tally.api.inputDto.ProductOutAndInInputDto;
import com.tally.api.inputDto.ProductSpecInputDto;
import com.tally.api.outputDto.ProductSpecOutputDto;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import java.util.List;

/**
 * 产品规格表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyProductSpecService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyProductSpec tallyProductSpec);

    /**
     * 主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteById(Integer id);

    /**
     * 批量主键删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void deleteByIdInBatch(List<Integer> ids);

    /**
     * 主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateById(TallyProductSpec tallyProductSpec);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyProductSpec> tallyProductSpecs);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyProductSpec findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    TallyProductSpec findOne(TallyProductSpec tallyProductSpec);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<TallyProductSpec> findList(TallyProductSpec tallyProductSpec);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<TallyProductSpec> findPage(PageWrap<TallyProductSpec> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyProductSpec tallyProductSpec);

    void updateFreezeStorage(ProductOutAndInInputDto productOutAndInInputDto);

    void saveBatch(List<ProductSpecInputDto> specList, Integer productId);

    void updateStorageByOrderProduct(TallyOrder tallyOrder, List<TallyOrderProduct> list);

    PageData<ProductSpecOutputDto> findPageWithProduct(PageWrap pageWrap, List userId);

    List<TallyProductSpec> findbyIds(String productSpecIds);

    void updateStorageByMaterialBill(String userId, TallyBill bill);

    TallyProductSpec findByUserId(Integer userId, TallyProductSpec build);
}