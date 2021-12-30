package com.tally.service.tallyproduct;

import com.tally.api.inputDto.*;
import com.tally.api.outputDto.ProductOutputDto;
import com.tally.api.outputDto.TallyOrderOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyproduct.model.TallyProduct;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品表Service定义
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
public interface TallyProductService {

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    Integer create(TallyProduct tallyProduct);

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
    void updateById(TallyProduct tallyProduct);

    /**
     * 批量主键更新
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    void updateByIdInBatch(List<TallyProduct> tallyProducts);

    /**
     * 主键查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    ProductOutputDto findById(Integer id);

    /**
     * 条件查询单条记录
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    ProductOutputDto findOne(TallyProduct tallyProduct);

    /**
     * 条件查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    List<ProductOutputDto> findList(TallyProduct tallyProduct);
  
    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    PageData<ProductOutputDto> findPage(PageWrap<ProductInputDto> pageWrap);

    /**
     * 条件统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    long count(TallyProduct tallyProduct);

    /**
     * 添加产品
     * @param addProductInputDto
     * @param userId
     * @return
     */
    ApiResponse addProduct(AddProductInputDto addProductInputDto, String userId);

    /**
     * 产品添加规格
     * @param addProductSpecInputDto
     * @param userId
     * @return
     */
    ApiResponse addProductSpec(AddProductSpecInputDto addProductSpecInputDto, String userId);

    /**
     * 产权出入库
     * @param productOutAndInInputDto
     * @param userId
     * @return
     */
    ApiResponse productOutAndIn(ProductOutAndInInputDto productOutAndInInputDto, String userId);

    BigDecimal getStockBalance(String userId);

    AddProductInputDto addProductPlus(AddProductInputDto build, String userId);
}