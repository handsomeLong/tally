package com.tally.api.tallyreport;

import com.tally.api.BaseController;
import com.tally.api.inputDto.BillReportInputDto;
import com.tally.api.inputDto.ProfitsReportInputDto;
import com.tally.api.inputDto.SalesAndPurchaseReportInputDto;
import com.tally.api.outputDto.OrderReportOutputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.utils.DateUtils;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccounttype.model.TallyAccountType;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyaccounttype.TallyAccountTypeService;
import com.tally.service.tallyaccountwater.TallyAccountWaterService;
import com.tally.service.tallyaccountwaterdetail.TallyAccountWaterDetailService;
import com.tally.service.tallyorder.TallyOrderService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 *  报表
 */
@RestController
@RequestMapping("/api/tallyReport")
@Api("流水明细")
public class TallyReportController extends BaseController {

    @Autowired
    private TallyAccountWaterDetailService tallyAccountWaterDetailService;
    @Autowired
    private TallyAccountWaterService tallyAccountWaterService;
    @Autowired
    private TallyOrderService  tallyOrderService;
    @Autowired
    private TallyAccountTypeService tallyAccountTypeService;
    @Autowired
    private TallyAccountService tallyAccountService;


    /**
     * 账单分页 应收应付账单
     * @author 131****2893
     * @date 2021/01/08 14:39
     */
    @PostMapping("/billReportPage")
    public ApiResponse billReportPage (BillReportInputDto billReportInputDto, HttpServletRequest request) {
        try {
            Integer userId = Integer.valueOf(getUserId(request));
            if(StringUtils.isNotBlank(billReportInputDto.getAccountTypeCode())){
                TallyAccountType type = new TallyAccountType();
                type.setUserId(Integer.valueOf(userId));
                type.setTypeCode(billReportInputDto.getAccountTypeCode());
                TallyAccountType accountType = tallyAccountTypeService.findOne(type);
                if(null!=accountType){
                    TallyAccount tallyAccount = new TallyAccount();
                    tallyAccount.setUserId(Integer.valueOf(userId));
                    tallyAccount.setTypeId(accountType.getId());
                    TallyAccount account = tallyAccountService.findOne(tallyAccount);
                    if(null!=account)
                        billReportInputDto.setAccountId(account.getId());
                }
            }
            billReportInputDto.setUserId(userId);
            Integer interval = billReportInputDto.getInterval();
            String startDate = "";
            String endDate = "";
            if(interval==1){//1个月以内
                startDate = DateUtils.getStepDate(30,"yyyy-MM-dd HH:mm:ss");
                startDate = DateUtils.getDate(DateUtils.getDate(startDate,"yyyy-MM-dd"));
                endDate = DateUtils.getDate(new Date());
            }else if(interval==2){//1个到3个月
                startDate = DateUtils.getStepDate(90,"yyyy-MM-dd HH:mm:ss");
                startDate = DateUtils.getDate(DateUtils.getDate(startDate,"yyyy-MM-dd"));
                endDate = DateUtils.getStepDate(30,"yyyy-MM-dd HH:mm:ss");
                endDate = DateUtils.getDate(DateUtils.getDate(endDate,"yyyy-MM-dd"));
            }else if(interval==3){//3个到6个月
                startDate = DateUtils.getStepDate(180,"yyyy-MM-dd HH:mm:ss");
                startDate = DateUtils.getDate(DateUtils.getDate(startDate,"yyyy-MM-dd"));
                endDate = DateUtils.getStepDate(90,"yyyy-MM-dd HH:mm:ss");
                endDate = DateUtils.getDate(DateUtils.getDate(endDate,"yyyy-MM-dd"));
            }else if(interval==4){//6个月以上
                endDate = DateUtils.getStepDate(180,"yyyy-MM-dd HH:mm:ss");
                endDate = DateUtils.getDate(DateUtils.getDate(endDate,"yyyy-MM-dd"));
            }
            billReportInputDto.setStartDate(startDate);
            billReportInputDto.setEndDate(endDate);
            return ApiResponse.success(tallyAccountWaterService.findReportPage(billReportInputDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }

    /**
     * 应收应付 统计
     * @param billReportInputDto
     * @param request
     * @return
     */
    @PostMapping("/billReportCount")
    public ApiResponse billReportCount (BillReportInputDto billReportInputDto, HttpServletRequest request) {
        try {
            Integer userId = Integer.valueOf(getUserId(request));
            if(StringUtils.isNotBlank(billReportInputDto.getAccountTypeCode())){
                TallyAccountType type = new TallyAccountType();
                type.setUserId(Integer.valueOf(userId));
                type.setTypeCode(billReportInputDto.getAccountTypeCode());
                TallyAccountType accountType = tallyAccountTypeService.findOne(type);
                if(null!=accountType){
                    TallyAccount tallyAccount = new TallyAccount();
                    tallyAccount.setUserId(Integer.valueOf(userId));
                    tallyAccount.setTypeId(accountType.getId());
                    TallyAccount account = tallyAccountService.findOne(tallyAccount);
                    if(null!=account)
                        billReportInputDto.setAccountId(account.getId());
                }
            }
            billReportInputDto.setUserId(userId);
            Integer interval = billReportInputDto.getInterval();
            String startDate = "";
            String endDate = "";
            if(interval==1){//1个月以内
                startDate = DateUtils.getStepDate(30,"yyyy-MM-dd HH:mm:ss");
                startDate = DateUtils.getDate(DateUtils.getDate(startDate,"yyyy-MM-dd"));
                endDate = DateUtils.getDate(new Date());
            }else if(interval==2){//1个到3个月
                startDate = DateUtils.getStepDate(90,"yyyy-MM-dd HH:mm:ss");
                startDate = DateUtils.getDate(DateUtils.getDate(startDate,"yyyy-MM-dd"));
                endDate = DateUtils.getStepDate(30,"yyyy-MM-dd HH:mm:ss");
                endDate = DateUtils.getDate(DateUtils.getDate(endDate,"yyyy-MM-dd"));
            }else if(interval==3){//3个到6个月
                startDate = DateUtils.getStepDate(180,"yyyy-MM-dd HH:mm:ss");
                startDate = DateUtils.getDate(DateUtils.getDate(startDate,"yyyy-MM-dd"));
                endDate = DateUtils.getStepDate(90,"yyyy-MM-dd HH:mm:ss");
                endDate = DateUtils.getDate(DateUtils.getDate(endDate,"yyyy-MM-dd"));
            }else if(interval==4){//6个月以上
                endDate = DateUtils.getStepDate(180,"yyyy-MM-dd HH:mm:ss");
                endDate = DateUtils.getDate(DateUtils.getDate(endDate,"yyyy-MM-dd"));
            }
            billReportInputDto.setStartDate(startDate);
            billReportInputDto.setEndDate(endDate);
            Map map = tallyAccountWaterService.billReportCount(billReportInputDto);
            return ApiResponse.success(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }


    /**
     * 利润统计
     * @param profitsReportInputDto
     * @param request
     * @return
     */
    @PostMapping("/profitsReport")
    public ApiResponse profitsReport(ProfitsReportInputDto profitsReportInputDto, HttpServletRequest request) {
        try {
            Integer userId = Integer.valueOf(getUserId(request));
            profitsReportInputDto.setUserId(userId);
            return ApiResponse.success(tallyOrderService.profitsReport(profitsReportInputDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }

    /**
     * 产品销量排行 采购统计排行
     * @param salesAndPurchaseReportInputDto
     * @param request
     * @return
     */
    @PostMapping("/salesAndPurchaseReportPage")
    public ApiResponse salesAndPurchaseReportPage(SalesAndPurchaseReportInputDto salesAndPurchaseReportInputDto, HttpServletRequest request) {
        try {
            Integer userId = Integer.valueOf(getUserId(request));
            salesAndPurchaseReportInputDto.setUserId(userId);
            PageData<OrderReportOutputDto> pda = tallyOrderService.salesAndPurchaseReportPage(salesAndPurchaseReportInputDto);
            return ApiResponse.success(pda);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }

    /**
     * 客户贡献排行
     * @param inputDto
     * @param request
     * @return
     */
    @PostMapping("/cusContributeReport")
    public ApiResponse cusContributeReport(SalesAndPurchaseReportInputDto inputDto, HttpServletRequest request) {
        try {
            Integer userId = Integer.valueOf(getUserId(request));
            inputDto.setUserId(userId);
            return ApiResponse.success(tallyOrderService.cusContributeReport(inputDto));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }

}