package com.tally.api.tallystoragecheck;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallystoragecheck.model.TallyStorageCheck;
import com.tally.service.tallystoragecheck.TallyStorageCheckService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 库存盘点接口
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@RestController
@RequestMapping("/api/tallyStorageCheck")
//@Api(tags = "库存盘点接口")
public class TallyStorageCheckController extends BaseController {

    @Autowired
    private TallyStorageCheckService tallyStorageCheckService;

    /**
     * 创建
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/create")
    public ApiResponse create(@RequestBody TallyStorageCheck tallyStorageCheck) {
        return ApiResponse.success(tallyStorageCheckService.create(tallyStorageCheck));
    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyStorageCheckService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyStorageCheck tallyStorageCheck) {
        tallyStorageCheckService.updateById(tallyStorageCheck);
        return ApiResponse.success(null);
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @PostMapping("/page")
    public ApiResponse findPage (@RequestBody PageWrap<TallyStorageCheck> pageWrap) {
        return ApiResponse.success(tallyStorageCheckService.findPage(pageWrap));
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2020/10/27 16:52
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyStorageCheckService.findById(id));
    }
}