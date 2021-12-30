package com.tally.api.tallystoragelog;

import com.tally.api.BaseController;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.dao.tallystoragelog.model.TallyStorageLog;
import com.tally.service.tallystoragelog.TallyStorageLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 库存变动日志接口
 * @author 131****2893
 * @date 2021/01/19 11:17
 */
@RestController
@RequestMapping("/api/tallyStorageLog")
@Api(tags="库存流水")
public class TallyStorageLogController extends BaseController {

    @Autowired
    private TallyStorageLogService tallyStorageLogService;

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/19 11:17
     */
    @PostMapping("/page")
    public ApiResponse findPage (Integer page,Integer specId, HttpServletRequest request) {
        PageWrap pageWrap = null;
        try {
            String userId = getUserId(request);
            TallyStorageLog tallyStorageLog = new TallyStorageLog();
            tallyStorageLog.setUserId(Integer.valueOf(userId));
            tallyStorageLog.setSpecId(specId);
            pageWrap = new PageWrap();
            pageWrap.setPage(page);
            pageWrap.setModel(tallyStorageLog);
            PageData pageData = tallyStorageLogService.findPageWithSpec(pageWrap);
            return ApiResponse.success(pageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }


//    /**
//     * 创建
//     * @author 131****2893
//     * @date 2021/01/19 11:17
//     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyStorageLog tallyStorageLog) {
//        return ApiResponse.success(tallyStorageLogService.create(tallyStorageLog));
//    }
//
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2021/01/19 11:17
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyStorageLogService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2021/01/19 11:17
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyStorageLog tallyStorageLog) {
//        tallyStorageLogService.updateById(tallyStorageLog);
//        return ApiResponse.success(null);
//    }
//
//
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2021/01/19 11:17
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyStorageLogService.findById(id));
//    }
}