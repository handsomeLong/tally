package com.tally.api.tallystorageauit;

import com.tally.api.BaseController;
import com.tally.api.outputDto.TallyStorageAuitOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.dao.tallystorageauit.model.TallyStorageAuit;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import com.tally.service.tallystorageauit.TallyStorageAuitService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 出入库审核表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyStorageAuit")
@Api(tags = "出入库审核接口")
public class TallyStorageAuitController extends BaseController {

    @Autowired
    private TallyStorageAuitService tallyStorageAuitService;
    @Autowired
    private TallyProductSpecService tallyProductSpecService;

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (Integer page,Integer status, HttpServletRequest request) {
        PageWrap pageWrap;
        try {
            TallyStorageAuit tallyStorageAuit = new TallyStorageAuit();
            tallyStorageAuit.setStatus(status);
//            String userId = getUserId(request);
//            tallyStorageAuit.setAuitUserId(Integer.valueOf(userId));
            pageWrap = new PageWrap();
            pageWrap.setPage(page);
            pageWrap.setModel(tallyStorageAuit);
            PageWrap.SortData sortData = new PageWrap.SortData();
            sortData.setProperty("id");
            sortData.setDirection("desc");
            List<PageWrap.SortData> list = new ArrayList<>();
            list.add(sortData);
            pageWrap.setSorts(list);
            PageData pageData = tallyStorageAuitService.findPage(pageWrap);
            return ApiResponse.success(pageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }
    @PostMapping("/findById")
    public ApiResponse findById (Integer id, HttpServletRequest request) {
        try {
            TallyStorageAuit storageAuit = tallyStorageAuitService.findById(id);
            List<TallyProductSpec> list =  tallyProductSpecService.findbyIds(storageAuit.getProductSpecIds());
            List<String> specIds = Arrays.asList(storageAuit.getProductSpecIds().split(","));
            List<String> specNums = Arrays.asList(storageAuit.getProductSpecNum().split(","));
            for (TallyProductSpec spec:list) {
                int index = specIds.indexOf(spec.getId()+"");
                String number = specNums.get(index);
                spec.setSpecStorage(Integer.valueOf(number));
            }
            TallyStorageAuitOutputDto outputDto = new TallyStorageAuitOutputDto();
            BeanUtils.copyProperties(storageAuit,outputDto);
            outputDto.setList(list);
            return ApiResponse.success(outputDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }
    @PostMapping("/auit")
    public ApiResponse auit (String ids,Integer status, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            tallyStorageAuitService.updateAuit(ids,status,Integer.valueOf(userId));
            return ApiResponse.success(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }
//    /**
//     * 创建
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyStorageAuit tallyStorageAuit) {
//        return ApiResponse.success(tallyStorageAuitService.create(tallyStorageAuit));
//    }
//
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyStorageAuitService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyStorageAuit tallyStorageAuit) {
//        tallyStorageAuitService.updateById(tallyStorageAuit);
//        return ApiResponse.success(null);
//    }
//
//
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyStorageAuitService.findById(id));
//    }
}