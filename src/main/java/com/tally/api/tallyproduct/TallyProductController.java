package com.tally.api.tallyproduct;

import com.tally.api.BaseController;
import com.tally.api.inputDto.AddProductInputDto;
import com.tally.api.inputDto.AddProductSpecInputDto;
import com.tally.api.inputDto.ProductInputDto;
import com.tally.api.inputDto.ProductOutAndInInputDto;
import com.tally.config.FileConfig;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyproduct.model.TallyProduct;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.service.tallyproduct.TallyProductService;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 产品表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyProduct")
@Api(tags = "产品接口")
public class TallyProductController extends BaseController {

    @Autowired
    private TallyProductService tallyProductService;
    @Autowired
    private TallyProductSpecService tallyProductSpecService;
    @Autowired
    private FileConfig fileConfig;

    /**
     * 添加产品
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/addProduct")
    @ApiOperation("添加产品")
    public ApiResponse addProduct(@RequestBody AddProductInputDto addProductInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        return tallyProductService.addProduct(addProductInputDto,userId);
    }
    /**
     * 给产品添加规格
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/addProductSpec")
    @ApiOperation("产品添加规格")
    public ApiResponse addProductSpec(@RequestBody AddProductSpecInputDto addProductSpecInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        return tallyProductService.addProductSpec(addProductSpecInputDto,userId);
    }
    /**
     * 产品列表
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/productList")
    @ApiOperation("产品列表")
    public ApiResponse productList (@RequestBody PageWrap<ProductInputDto> pageWrap, ProductInputDto productInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        productInputDto.setUserId(Integer.valueOf(userId));
        pageWrap.setModel(productInputDto);
        List<PageWrap.SortData> list = new ArrayList<>();
        PageWrap.SortData sortData = new PageWrap.SortData();
        sortData.setProperty("id");
        sortData.setDirection("desc");
        list.add(sortData);
        pageWrap.setSorts(list);
        return ApiResponse.success(tallyProductService.findPage(pageWrap));
    }
    /**
     * 产品规格列表
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/productSpecList")
    @ApiOperation("产品规格列表")
    public ApiResponse productSpecList (@RequestBody PageWrap<TallyProductSpec> pageWrap,TallyProductSpec tallyProductSpec) {
        pageWrap.setModel(tallyProductSpec);
        return ApiResponse.success(tallyProductSpecService.findPage(pageWrap));
    }
    /**
     * 产品出入库
     * @author 131****2893
            * @date 2020/10/27 16:52
            */
    @PostMapping("/productOutAndIn")
    @ApiOperation("产品出入库")
    public ApiResponse productOutAndIn (@RequestBody ProductOutAndInInputDto  productOutAndInInputDto, HttpServletRequest request) {
        String userId = getUserId(request);
        return  tallyProductService.productOutAndIn(productOutAndInInputDto,userId);
    }
    /**
     * 产品统计
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/productStatistics")
    @ApiOperation("产品统计")
    public ApiResponse productStatistics (HttpServletRequest request) {
        String userId = getUserId(request);
        ApiResponse apiResponse =ApiResponse.failed("查询失败！");
        try {
            //查询库存余额
            BigDecimal stockBalance = tallyProductService.getStockBalance(userId);
            apiResponse.setData(stockBalance);
            apiResponse.setMessage("查询成功");
            apiResponse.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResponse;
    }
    /**
     * 添加产品
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/uploadImage")
    @ApiOperation("上传产品图片")
    public ApiResponse uploadImage(MultipartFile image, HttpServletRequest request) {
        ApiResponse apiResponse = ApiResponse.failed("上传失败！");
        String userId = getUserId(request);
        if(image!=null&&!image.isEmpty()){
            try {
                String product_path =fileConfig.getFilepath()+fileConfig.getUpload_product_path();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String datePath = sdf.format(new Date());
                String suffix="/"+userId+"/"+datePath+".png";
                File dir = new File(product_path +"/"+userId+"/");
                if(!dir.exists()){
                    dir.mkdirs();
                }
                File file = new File(product_path +suffix);
                if (!file.exists()){
                    file.createNewFile();
                }
                image.transferTo(file);
                apiResponse.setSuccess(true);
                apiResponse.setMessage("上传成功！");
                apiResponse.setData(fileConfig.getDomain_path()+fileConfig.getUpload_product_path() +suffix);
            }catch (Exception e){
                apiResponse.setMessage("上传图片异常！");
            }
        }
            return apiResponse;
    }
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyProductService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyProduct tallyProduct) {
//        tallyProductService.updateById(tallyProduct);
//        return ApiResponse.success(null);
//    }
    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/findById")
    public ApiResponse finById(@RequestBody TallyProduct tallyProduct, HttpServletRequest request) {
        String userId = getUserId(request);
        tallyProduct.setUserId(Integer.valueOf(userId));
        return ApiResponse.success(tallyProductService.findOne(tallyProduct));
    }
}