package com.tally.api.tallybill;

import com.google.common.collect.Lists;
import com.tally.api.BaseController;
import com.tally.api.inputDto.AddBillInputDto;
import com.tally.api.inputDto.AddCollectionInputDto;
import com.tally.api.inputDto.AddCollectionShInputDto;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.service.tallybill.TallyBillService;
import com.tally.service.tallybilldetail.TallyBillDetailService;
import com.tally.service.tallyuserpergrant.TallyUserPerGrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 账单表接口
 * @author 131****2893
 * @date 2021/04/12 13:43
 */
@RestController
@RequestMapping("/api/tallyBill")
public class TallyBillController extends BaseController {

    @Autowired
    private TallyBillService tallyBillService;
    @Autowired
    private TallyBillDetailService tallyBillDetailService;
    @Autowired
    private TallyUserPerGrantService tallyUserPerGrantService;

    /**
     * 新增账单
     * @author 131****2893
     * @date 2021/01/03 14:16
     * TODO
     */
    @PostMapping("/addBill")
    public ApiResponse addBill(@RequestBody AddBillInputDto addBillInputDto, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            addBillInputDto.setUserId(Integer.valueOf(userId));
            Integer billId = tallyBillService.addBill(addBillInputDto);
            return ApiResponse.success("新增成功",billId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("新增失败！");
    }

    /**
     * 增加收还款
     * @param dto
     * @param request
     * @return
     */
    @PostMapping("/addCollection")
    public ApiResponse addCollection(@RequestBody AddCollectionInputDto dto, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            dto.setUserId(Integer.valueOf(userId));
            Integer billid = tallyBillService.addCollection(dto);
            return ApiResponse.success("新增成功",billid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("新增失败！");
    }
    /**
     * 物料收还
     * @param dto
     * @param request
     * @return
     */
    @PostMapping("/addCollectionSh")
    public ApiResponse addCollectionSh(@RequestBody AddCollectionShInputDto dto, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            dto.setUserId(Integer.valueOf(userId));
            Integer billid = tallyBillService.addCollectionSh(dto);
            return ApiResponse.success("新增成功",billid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("新增失败！");
    }
    /**
     *账单审核
     * @param ids
     * @param request
     * @return
     */
    @PostMapping("/billAuit")
    @ResponseBody
    public ApiResponse billAuit(String ids,Integer status, HttpServletRequest request) {
        ApiResponse apiResponse = ApiResponse.success("审核成功",null);
        try {
            String userId = getUserId(request);
             tallyBillService.auitBill(userId,status,ids);
            return apiResponse;
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setMessage("审核失败:"+e.getMessage());
        }
        return apiResponse;
    }

    @PostMapping("/findById")
    public ApiResponse finById(@RequestBody TallyBill tallyBill, HttpServletRequest request) {
        String userId = getUserId(request);
        tallyBill.setUserId(Integer.valueOf(userId));
        return ApiResponse.success(tallyBillService.findBill(tallyBill));
    }

    /**
     * 查询 账单 ids
     * @param ids
     * @param request
     * @return
     */
    @PostMapping("/findListByIds")
    public ApiResponse findListByIds(String ids, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            List<TallyBill> list =  tallyBillService.findListByIds(ids,userId);
            return ApiResponse.success("查询成功",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("查询失败！");
    }
    /**
     *  按照用户分组 分页
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    @PostMapping("/billCollectPage")
    public ApiResponse billCollectPage (Integer type,Integer auitStatus,Integer status, Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            TallyBill bill = new TallyBill();
            bill.setStatus(status);
            bill.setType(type);
            bill.setAuitStatus(auitStatus);
            bill.setIsMaterial(0);
            bill.setUserId(Integer.valueOf(userId));
            return ApiResponse.success(tallyBillService.billCollectPage(bill,page));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
    /**
     * 分页 - 没有数据权限
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    @PostMapping("/pageWithNoAuth")
    @Deprecated
    public ApiResponse pageWithNoAuth (Integer auitStatus,Integer btypeUserId,Integer type,Integer status, Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            TallyBill bill = new TallyBill();
            bill.setAuitStatus(auitStatus);
            bill.setStatus(status);
            bill.setType(type);
            bill.setIsMaterial(0);
            bill.setBtypeUserId(btypeUserId);
            List userIdList = new ArrayList();
            List<String> btypeUserMobileList = new ArrayList();
            userIdList.add(Integer.valueOf(userId));
            return ApiResponse.success(tallyBillService.findPage(userIdList,btypeUserMobileList,bill,page));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
    /**
     * 分页查询
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    @PostMapping("/page")
    public ApiResponse findPage (Integer isMaterial,Integer status,Integer type,Integer isClose,Integer isMyself, Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            String userMobile = getUserName(request);
            TallyBill bill = TallyBill.builder().auitStatus(status).status(isClose).type(type).isMaterial(isMaterial).build();
            List userIdList = new ArrayList();
            List<String> btypeUserMobileList = new ArrayList();
            if(1==isMyself){
                Map<String, List> map = tallyUserPerGrantService.getGrantUserIds(userId, "CHECK_BILL");
                 userIdList.add(Integer.valueOf(userId));
                 userIdList.addAll(map.get("userIdList"));
            }else{
                Map<String, List> map = tallyUserPerGrantService.getGrantUserIds(userId, "CONFIRM_BILL");
                btypeUserMobileList.add(userMobile);
                btypeUserMobileList.addAll(map.get("userMobileList"));
            }
            return ApiResponse.success(tallyBillService.findPage(userIdList,btypeUserMobileList,bill,page));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }


    /**
     * 物料账单分页查询
     * type  100 借出 101 借入 102
     * status 100-未结算 101-结算完成
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
    @PostMapping("/materialCollectPage")
    public ApiResponse materialCollectPage (Integer type,Integer status, Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            PageData<TallyBill> list =  tallyBillService.findMaterialCollectPage(page,userId,status,type);
            return ApiResponse.success(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
    /**
     * 产品收还列表
     * @param page
     * @param request
     * @param type
     * @return
     */
    @PostMapping("/shPage")
    public ApiResponse productShPage (Integer page,HttpServletRequest request,Integer type,Integer btypeUserId) {
        try {
            String userId = getUserId(request);
            //查询所需要的账单
            List<TallyBill> bills = tallyBillService.getMaterialTallyBills(userId,100, type,btypeUserId);
            //查询账单明细并做分组
            PageData<TallyBillDetail> pageData = tallyBillDetailService.findCollectPage(page,bills);
            return ApiResponse.success(pageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("调用失败！");
    }
    /**
     *
     * @param type
     * @param status
     * @param page
     * @param request
     * @return
     */
    @PostMapping("/materialPage")
    public ApiResponse materialPage (Integer type,Integer status,Integer btypeUserId, Integer page, HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            PageData<TallyBill> list =  tallyBillService.findMaterialPage(page,userId,status,type,btypeUserId);
            return ApiResponse.success(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
    /**
     *  物料借入借出统计
     * @param request
     * @return
     */
    @PostMapping("/materialCount")
    public ApiResponse materialCount ( HttpServletRequest request) {
        try {
            String userId = getUserId(request);
            TallyBill bill = new TallyBill();
            bill.setIsMaterial(1);
            bill.setUserId(Integer.valueOf(userId));
           Map<String,String> map =  tallyBillService.materialCount(bill);
           return ApiResponse.success(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
    /**
     *  应收应付统计
     * @param request
     * @return
     */
    @PostMapping("/sfCount")
    public ApiResponse sfCount ( HttpServletRequest request,Integer btypeUserId) {
        try {
            String userId = getUserId(request);
            TallyBill bill = new TallyBill();
            bill.setUserId(Integer.valueOf(userId));
            bill.setBtypeUserId(btypeUserId);
            Map<String,String> map =  tallyBillService.sfCount(bill);
            return ApiResponse.success(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.failed("获取失败！");
    }
    /**
     * 创建
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
//    @PostMapping("/create")
//    public ApiResponse create(@RequestBody TallyBill tallyBill) {
//        return ApiResponse.success(tallyBillService.create(tallyBill));
//    }

    /**
     * 用户删除
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
//    @GetMapping("/delete/{id}")
//    public ApiResponse deleteById(@PathVariable Integer id) {
//        tallyBillService.deleteById(id);
//        return ApiResponse.success(null);
//    }

    /**
     * 修改用户
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
//    @PostMapping("/updateById")
//    public ApiResponse updateById(@RequestBody TallyBill tallyBill) {
//        tallyBillService.updateById(tallyBill);
//        return ApiResponse.success(null);
//    }



    /**
     * 通过ID查询
     * @author 131****2893
     * @date 2021/04/12 13:43
     */
//    @GetMapping("/{id}")
//    public ApiResponse finById(@PathVariable Integer id) {
//        return ApiResponse.success(tallyBillService.findById(id));
//    }
    public static void main(String[] args) {
        Lists.newArrayList();
    }
}