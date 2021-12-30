package com.tally.api.tallyaccount;

import com.google.common.collect.Maps;
import com.tally.api.BaseController;
import com.tally.api.inputDto.WaterDetailInputDto;
import com.tally.api.outputDto.TallyOrderOutputDto;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.core.enums.AccountTypeEnums;
import com.tally.core.enums.OrderTypeEnums;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.DateUtils;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetail;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyaccountwaterdetail.TallyAccountWaterDetailService;
import com.tally.service.tallybill.TallyBillService;
import com.tally.service.tallyorder.TallyOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 账户流水接口
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@RestController
@RequestMapping("/api/tallyAccount")
@Api(tags = "账户管理")
public class TallyAccountController extends BaseController {

    @Autowired
    private TallyAccountService tallyAccountService;
    @Autowired
    private TallyAccountWaterDetailService tallyAccountWaterDetailService;
    @Autowired
    private TallyOrderService tallyOrderService;
    @Autowired
    private TallyBillService tallyBillService;

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/list")
    @ApiOperation("账户列表")
    public ApiResponse findPage (@RequestBody PageWrap<TallyAccount> pageWrap, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(Integer.valueOf(userId));
            List<TallyAccount> records = tallyAccountService.findList(tallyAccount);
            Map<String,Object> map = new HashMap<>();
            List<TallyAccount> assetsAccountList = records.stream().filter(s -> s.getAssetClass().equals("100")).collect(Collectors.toList());
            List<TallyAccount> debtAccountList = records.stream().filter(s -> s.getAssetClass().equals("101")).collect(Collectors.toList());
            Double amount1 = assetsAccountList.stream().map(e -> e.getAmout().doubleValue()).reduce(Double::sum).get();
            Double amount2 = debtAccountList.stream().map(e -> e.getAmout().doubleValue()).reduce(Double::sum).get();
            double amount = amount1 - amount2;
            map.put("amount", Arrays.asList(amount));
            map.put("assetsAccountList", assetsAccountList);
            map.put("debtAccountList", debtAccountList);
            return ApiResponse.success(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/tradingList")
    @ApiOperation("交易账户列表")
    public ApiResponse tradingList (HttpServletRequest request,
                                    @Param("orderType") Integer orderType) {
        try {
            String userId = getUserId(request);
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(Integer.valueOf(userId));
            List<TallyAccount> list = tallyAccountService.findList(tallyAccount);
            //销售开单展示 现金 支付宝 微信 银行 应收款
            List resultlist = new ArrayList<TallyAccount>();
             if(OrderTypeEnums.SALES.equals(OrderTypeEnums.getEnum(orderType))){
                 for (TallyAccount account:list) {
                        if(account.getTypeCode().equals(AccountTypeEnums.XJ.getRetCode())||
                           account.getTypeCode().equals(AccountTypeEnums.YH.getRetCode())||
                           account.getTypeCode().equals(AccountTypeEnums.ZFB.getRetCode())||
                           account.getTypeCode().equals(AccountTypeEnums.WX.getRetCode())
//                                ||account.getTypeCode().equals(AccountTypeEnums.YS.getRetCode())
                            ){
                          resultlist.add(account);
                      }
                 }
             }else if(OrderTypeEnums.PURCHASE.equals(OrderTypeEnums.getEnum(orderType))){
                 for (TallyAccount account:list) {
                         if(account.getTypeCode().equals(AccountTypeEnums.XJ.getRetCode())||
                                 account.getTypeCode().equals(AccountTypeEnums.YH.getRetCode())||
                                 account.getTypeCode().equals(AccountTypeEnums.ZFB.getRetCode())||
                                 account.getTypeCode().equals(AccountTypeEnums.WX.getRetCode())
//                                 ||account.getTypeCode().equals(AccountTypeEnums.YF.getRetCode())
                                 ){
                             resultlist.add(account);
                         }
                 }
             }else{
                 for (TallyAccount account:list) {
                     if(account.getTypeCode().equals(AccountTypeEnums.XJ.getRetCode())||
                             account.getTypeCode().equals(AccountTypeEnums.YH.getRetCode())||
                             account.getTypeCode().equals(AccountTypeEnums.ZFB.getRetCode())||
                             account.getTypeCode().equals(AccountTypeEnums.WX.getRetCode())
                             ){
                         resultlist.add(account);
                     }
                 }
             }
            //采购显示 现金 支付宝 微信 银行 应付款
            return ApiResponse.success(resultlist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }
    @PostMapping("/getStatistics")
    @ApiOperation("账户统计")
    public ApiResponse getStatistics (HttpServletRequest request) {
        try {
            Map map = Maps.newHashMap();
            String userId = getUserId(request);
            TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
            detail.setUserId(Integer.valueOf(userId));
            //总收入
            detail.setType(100);
            List<WaterDetailOutputDto> list1 = tallyAccountWaterDetailService.findList(detail,null,null);
            Double income = new Double(0);
            if(list1.size()>0)
                 income = list1.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            map.put("income",new BigDecimal(income).setScale(2,RoundingMode.HALF_DOWN));

            //总支出
            detail.setType(101);
            List<WaterDetailOutputDto> list2 = tallyAccountWaterDetailService.findList(detail,null,null);
            Double outcome = new Double(0);
            if(list2.size()>0)
                outcome = list2.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            map.put("outcome",new BigDecimal(outcome).setScale(2,RoundingMode.HALF_DOWN));
            //总利润
            Double profits = income - outcome;
            map.put("profits",new BigDecimal(profits).setScale(2,RoundingMode.HALF_DOWN));

            TallyAccount temp = new TallyAccount();
            temp.setUserId(Integer.valueOf(userId));
            temp.setTypeCode("XJ");
            TallyAccount xjAccount = tallyAccountService.findOne(temp);

            //本月 现金流 收入 支出
            Date now = new Date();
            String lastDayStr =  DateUtils.getLastDayOfMonth(now,"yyyy-MM-dd");
            now = DateUtils.getDate(lastDayStr+" 23:59:59","yyyy-MM-dd HH:mm:ss");
            Date startTime = DateUtils.get1thOfMonth(now);
            startTime = DateUtils.getDate(DateUtils.getDate(startTime),"yyyy-MM-dd");
            detail.setAccountId(xjAccount.getId());
            detail.setType(100);
            List<WaterDetailOutputDto> list3 = tallyAccountWaterDetailService.findList(detail,startTime,now);
            Double income_current_month = new Double(0);
            if(list3.size()>0)
              income_current_month = list3.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            map.put("income_current_month",new BigDecimal(income_current_month).setScale(2,RoundingMode.HALF_DOWN));
            detail.setAccountId(xjAccount.getId());
            detail.setType(101);

            List<WaterDetailOutputDto> list4 = tallyAccountWaterDetailService.findList(detail,startTime,now);
            Double outcome_current_month = new Double(0);
            if(list4.size()>0)
               outcome_current_month = list4.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            map.put("outcome_current_month",new BigDecimal(outcome_current_month).setScale(2,RoundingMode.HALF_DOWN));

            //总利润
            Double profits_current_month = income_current_month - outcome_current_month;
            map.put("profits_current_month",new BigDecimal(profits_current_month).setScale(2,RoundingMode.HALF_DOWN));
            //往来账户
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(Integer.valueOf(userId));
            List<TallyAccount> list = tallyAccountService.findList(tallyAccount);
            for (TallyAccount account:list) {
                if(account.getTypeCode().equals(AccountTypeEnums.YS.getRetCode())){
                    BigDecimal ys = account.getAmout();
                    map.put("ys",ys.setScale(2,RoundingMode.HALF_DOWN));
                }else if(account.getTypeCode().equals(AccountTypeEnums.YF.getRetCode())){
                    BigDecimal yf = account.getAmout();
                    map.put("yf",yf.setScale(2,RoundingMode.HALF_DOWN));
                }
                 if(account.getTypeCode().equals(AccountTypeEnums.YSK.getRetCode())){
                    BigDecimal ysk = account.getAmout();
                    map.put("ysk",ysk.setScale(2,RoundingMode.HALF_DOWN));
                }else if(account.getTypeCode().equals(AccountTypeEnums.YFK.getRetCode())){
                    BigDecimal yfk= account.getAmout();
                    map.put("yfk",yfk.setScale(2,RoundingMode.HALF_DOWN));
                }
            }
            //应收款 应付款
//            TallyBill bill = new TallyBill();
//            bill.setUserId(Integer.valueOf(userId));
//            Map<String,String> sfmap =  tallyBillService.sfCount(bill);
//            map.putAll(sfmap);
            //对账
            //客户对账--销售 销售统计 供应商对账--采购 采购成本统计
            TallyOrder tallyOrder = new TallyOrder();
            //销售
            tallyOrder.setOrderType(100);
            tallyOrder.setUserId(Integer.valueOf(userId));
            List<TallyOrder> list5 = tallyOrderService.findListWithNoSpec(tallyOrder);
            Double salesAmount = new Double(0);
            if(list5.size()>0)
               salesAmount = list5.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            map.put("salesAmount",new BigDecimal(salesAmount).setScale(2,RoundingMode.HALF_DOWN));
            //采购
            tallyOrder.setOrderType(102);
            tallyOrder.setUserId(Integer.valueOf(userId));
            List<TallyOrder> list6 = tallyOrderService.findListWithNoSpec(tallyOrder);
            Double purchaseAmount = new Double(0);
            if(list6.size()>0)
               purchaseAmount = list6.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get();
            map.put("purchaseAmount",new BigDecimal(purchaseAmount).setScale(2,RoundingMode.HALF_DOWN));
            return ApiResponse.success(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }
    @PostMapping("/getSumByTypeCode")
    public ApiResponse getSumByTypeCode (String accountTypeCode, Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(Integer.valueOf(userId));
            tallyAccount.setTypeCode(accountTypeCode);
            TallyAccount ta = tallyAccountService.findOne(tallyAccount);
            BigDecimal amout = ta.getAmout();
            return ApiResponse.success(amout.setScale(2,RoundingMode.HALF_DOWN));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
//    /**
//     * 创建
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyAccount tallyAccount) {
//        return ApiResponse.success(tallyAccountService.create(tallyAccount));
//    }
//
//    /**
//     * 用户删除
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyAccountService.deleteById(id);
//        return ApiResponse.success(null);
//    }
//
//    /**
//     * 修改用户
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyAccount tallyAccount) {
//        tallyAccountService.updateById(tallyAccount);
//        return ApiResponse.success(null);
//    }
//
//
//
//    /**
//     * 通过ID查询
//     * @author 131****2893
//     * @date 2021/01/03 14:16
//     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyAccountService.findById(id));
//    }
}