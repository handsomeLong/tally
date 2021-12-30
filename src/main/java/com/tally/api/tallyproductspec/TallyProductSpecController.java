package com.tally.api.tallyproductspec;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import com.tally.service.tallyuserpergrant.TallyUserPerGrantService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 产品规格表接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyProductSpec")
@Api(tags = "产品规格接口")
public class TallyProductSpecController extends BaseController {

    @Autowired
    private TallyProductSpecService tallyProductSpecService;
    @Autowired
    private TallyUserPerGrantService tallyUserPerGrantService;

    /**
     * 库存余额接口
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (Integer page,HttpServletRequest request) {
        PageWrap pageWrap = null;
        try {
            String userId = getUserId(request);
            TallyProductSpec tallyProductSpec = new TallyProductSpec();
            Map<String, List> map = tallyUserPerGrantService.getGrantUserIds(userId, "ADD_BILL");
            List userIdList = map.get("userIdList");
            userIdList.add(Integer.valueOf(userId));
            pageWrap = new PageWrap();
            pageWrap.setPage(page);
            pageWrap.setModel(tallyProductSpec);
            PageData pageData = tallyProductSpecService.findPageWithProduct(pageWrap,userIdList);
            return ApiResponse.success(pageData);
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
//    public ApiResponse create(@RequestBody TallyProductSpec tallyProductSpec) {
//        return ApiResponse.success(tallyProductSpecService.create(tallyProductSpec));
//    }
//
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyProductSpecService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2020/10/27 16:52
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyProductSpec tallyProductSpec) {
//        tallyProductSpecService.updateById(tallyProductSpec);
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
//        return ApiResponse.success(tallyProductSpecService.findById(id));
//    }
}