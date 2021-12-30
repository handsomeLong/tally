package com.tally.api.tallyaccountwaterdetail;

import com.tally.api.BaseController;
import com.tally.api.inputDto.OrderInputDto;
import com.tally.api.inputDto.WaterDetailCollectInputDto;
import com.tally.api.inputDto.WaterDetailInputDto;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetail;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyaccounttype.TallyAccountTypeService;
import com.tally.service.tallyaccountwater.TallyAccountWaterService;
import com.tally.service.tallyaccountwaterdetail.TallyAccountWaterDetailService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户流水明细接口
 * @author 131****2893
 * @date 2021/01/08 14:39
 */
@RestController
@RequestMapping("/api/tallyAccountWaterDetail")
@Api("流水明细")
public class TallyAccountWaterDetailController extends BaseController {

    @Autowired
    private TallyAccountWaterDetailService tallyAccountWaterDetailService;
    @Autowired
    private TallyAccountWaterService tallyAccountWaterService;
    @Autowired
    private TallyAccountTypeService tallyAccountTypeService;
    @Autowired
    private TallyAccountService tallyAccountService;


    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    @PostMapping("/page")
    public ApiResponse findPage (WaterDetailInputDto inputDto, Integer page, String accountTypeCode, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            inputDto.setUserId(Integer.valueOf(userId));
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
                    inputDto.setAccountId(account.getId());
                }
            }
            PageWrap pageWrap = new PageWrap();
            pageWrap.setModel(inputDto);
            pageWrap.setPage(page);
            List<PageWrap.SortData> list = new ArrayList<>();
            PageWrap.SortData sortData = new PageWrap.SortData();
            sortData.setProperty("w.create_time");
            sortData.setDirection("desc");
            list.add(sortData);
            pageWrap.setSorts(list);
            return ApiResponse.success(tallyAccountWaterDetailService.findPage(pageWrap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    @PostMapping("/collectPage")
    public ApiResponse findCollectPage (WaterDetailCollectInputDto inputDto,
                                        Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            inputDto.setUserId(Integer.valueOf(userId));
            PageWrap pageWrap = new PageWrap();
            pageWrap.setPage(page);
            return ApiResponse.success(tallyAccountWaterService.findCollectPage(pageWrap,inputDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }

    @PostMapping("/getSum")
    public ApiResponse getSum (WaterDetailInputDto inputDto, Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
            detail.setUserId(Integer.valueOf(userId));
            Double amount = new Double(0);
            if(null==inputDto.getType()){
                detail.setType(100);
                List<WaterDetailOutputDto> list1 = tallyAccountWaterDetailService.findList(detail,null,null);
                Double amount1 = list1.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
                detail.setType(101);
                List<WaterDetailOutputDto> list2 = tallyAccountWaterDetailService.findList(detail,null,null);
                Double amount2 = list2.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
                amount = amount1 - amount2;
            }else{
                detail.setType(inputDto.getType());
                List<WaterDetailOutputDto> list = tallyAccountWaterDetailService.findList(detail,null,null);
                 amount = list.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            }
            return ApiResponse.success(amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }

    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyAccountWaterDetailService.findById(id));
    }
    

    /**
     * 修改用户
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyAccountWaterDetail tallyAccountWaterDetail) {
//        tallyAccountWaterDetailService.updateById(tallyAccountWaterDetail);
//        return ApiResponse.success(null);
//    }


}