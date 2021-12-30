

package com.tally.api.tallyaccountlog;

import com.tally.api.BaseController;
import com.tally.api.inputDto.AccountLogInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccountlog.model.TallyAccountLog;
import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyaccountlog.TallyAccountLogService;
import com.tally.service.tallyaccounttype.TallyAccountTypeService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户变动日志接口
 * @author 131****2893
 * @date 2021/01/16 20:29
 */
@RestController
@RequestMapping("/api/tallyAccountLog")
@Api(tags ="交易明细")
public class TallyAccountLogController extends BaseController {

    @Autowired
    private TallyAccountLogService tallyAccountLogService;
    @Autowired
    private TallyAccountTypeService tallyAccountTypeService;
    @Autowired
    private TallyAccountService tallyAccountService;
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/16 20:29
     */
    @PostMapping("/page")
    public ApiResponse findPage (Integer page, String accountTypeCode,HttpServletRequest request) {
        PageWrap pageWrap = null;
        try {
            String userId = getUserId(request);
            TallyAccountLog log = new TallyAccountLog();
            log.setUserId(Integer.valueOf(userId));
            if(StringUtils.isNotBlank(accountTypeCode)){
                TallyAccountType type = new TallyAccountType();
                type.setUserId(Integer.valueOf(userId));
                type.setTypeCode(accountTypeCode);
                TallyAccountType accountType = tallyAccountTypeService.findOne(type);
                if(null!=accountType){
                    TallyAccount tallyAccount = new TallyAccount();
                    tallyAccount.setUserId(Integer.valueOf(userId));
                    tallyAccount.setTypeId(accountType.getId());
                    TallyAccount account = tallyAccountService.findOne(tallyAccount);
                    if(null!=account)
                        log.setAccountId(account.getId());
                }
            }
            pageWrap = new PageWrap();
            pageWrap.setModel(log);
            pageWrap.setPage(page);
            List<PageWrap.SortData> list = new ArrayList<>();
            PageWrap.SortData sortData = new PageWrap.SortData();
            sortData.setProperty("id");
            sortData.setDirection("desc");
            list.add(sortData);
            pageWrap.setSorts(list);
            return  ApiResponse.success(tallyAccountLogService.findPage(pageWrap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }

//    /**
//     * 创建
//     * @author 131****2893
//     * @date 2021/01/16 20:29
//     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyAccountLog tallyAccountLog) {
//        return ApiResponse.success(tallyAccountLogService.create(tallyAccountLog));
//    }
//
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2021/01/16 20:29
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyAccountLogService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2021/01/16 20:29
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyAccountLog tallyAccountLog) {
//        tallyAccountLogService.updateById(tallyAccountLog);
//        return ApiResponse.success(null);
//    }
//
//
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2021/01/16 20:29
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyAccountLogService.findById(id));
//    }
}