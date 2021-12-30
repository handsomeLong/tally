package com.tally.api.tallyaccountwater;

import com.tally.api.BaseController;
import com.tally.api.inputDto.AddBillInputDto;
import com.tally.api.inputDto.AddCollectionInputDto;
import com.tally.api.inputDto.AddWaterInputDto;
import com.tally.api.inputDto.WaterDetailInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageWrap;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccountwater.model.TallyAccountWater;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyaccountwater.TallyAccountWaterService;
import com.tally.service.tallybill.TallyBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 账户流水接口
 * @author 131****2893
 * @date 2021/01/03 14:16
 */
@RestController
@RequestMapping("/api/tallyAccountWater")
@Api("流水")
public class TallyAccountWaterController extends BaseController {

    @Autowired
    private TallyAccountWaterService tallyAccountWaterService;
    @Autowired
    private TallyBillService tallyBillService;
    @Autowired
    private TallyAccountService tallyAccountService;

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/pageByTypeCode")
    @ApiOperation("分页查询")
    public ApiResponse pageByTypeCode (String accountTypeCode,Integer btypeUserId,Integer page, HttpServletRequest request) {
        String userId = getUserId(request);
        TallyAccount tallyAccount = new TallyAccount();
        tallyAccount.setUserId(Integer.valueOf(userId));
        tallyAccount.setTypeCode(accountTypeCode);
        TallyAccount ta = tallyAccountService.findOne(tallyAccount);
        PageWrap pageWrap = new PageWrap();
        pageWrap.setPage(page);
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setAccountId(ta.getId());
        tallyAccountWater.setUserId(Integer.valueOf(userId));
        tallyAccountWater.setBtypeUserId(btypeUserId);
        pageWrap.setModel(tallyAccountWater);
        List<PageWrap.SortData> list = new ArrayList<>();
        PageWrap.SortData sortData = new PageWrap.SortData();
        sortData.setProperty("create_time");
        sortData.setDirection("desc");
        list.add(sortData);
        pageWrap.setSorts(list);
        return ApiResponse.success(tallyAccountWaterService.findPage(pageWrap));
    }

    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/waterCollectPage")
    @ApiOperation("分页查询")
    public ApiResponse waterCollectPage (String accountTypeCode,Integer page, HttpServletRequest request) {
        String userId = getUserId(request);
        TallyAccount tallyAccount = new TallyAccount();
        tallyAccount.setUserId(Integer.valueOf(userId));
        tallyAccount.setTypeCode(accountTypeCode);
        TallyAccount ta = tallyAccountService.findOne(tallyAccount);
        TallyAccountWater tallyAccountWater = new TallyAccountWater();
        tallyAccountWater.setAccountId(ta.getId());
        tallyAccountWater.setUserId(Integer.valueOf(userId));
        return ApiResponse.success(tallyAccountWaterService.waterCollectPage(tallyAccountWater,page));
    }

    /**
     * 新增流水
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/add")
    public ApiResponse create(@RequestBody AddWaterInputDto addWaterInputDto, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            addWaterInputDto.setUserId(Integer.valueOf(userId));
            tallyAccountWaterService.addWater(addWaterInputDto);
            return ApiResponse.success("新增成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("新增失败！");
    }
    /**
     * 快速记账
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/addQuickAccount")
    public ApiResponse addQuickAccount(@RequestBody AddWaterInputDto addWaterInputDto, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            addWaterInputDto.setUserId(Integer.valueOf(userId));
            tallyAccountWaterService.addQuickAccount(addWaterInputDto);
            return ApiResponse.success("新增成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("新增失败！");
    }
    /**
     * 增加收付款
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @PostMapping("/addCollection")
    @Deprecated
    public ApiResponse addCollection(@RequestBody AddCollectionInputDto addCollectionInputDto, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            addCollectionInputDto.setUserId(Integer.valueOf(userId));
            tallyAccountWaterService.addCollection(addCollectionInputDto);
            return ApiResponse.success("新增成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("新增失败！");
    }
    /**
     * 用户删除
     * @author 131****2893
     * @date 2021/01/03 14:16
     */
    @GetMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable Integer id) {
        tallyAccountWaterService.deleteById(id);
        return ApiResponse.success(null);
    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2021/01/03 14:16
     *//*
    @PostMapping("/updateById")
    public ApiResponse updateById(@RequestBody TallyAccountWater tallyAccountWater) {
        tallyAccountWaterService.updateById(tallyAccountWater);
        return ApiResponse.success(null);
    }



    *//**
     * 通过ID查询
     * @author 131****2893
     * @date 2021/01/03 14:16
     *//*
    @GetMapping("/{id}")
    public ApiResponse finById(@PathVariable Integer id) {
        return ApiResponse.success(tallyAccountWaterService.findById(id));
    }*/
}