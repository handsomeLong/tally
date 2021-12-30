package com.tally.service.tallyorder.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.tally.api.inputDto.*;
import com.tally.api.outputDto.OrderReportOutputDto;
import com.tally.api.outputDto.ProductOutputDto;
import com.tally.api.outputDto.TallyOrderOutputDto;
import com.tally.api.outputDto.WaterDetailOutputDto;
import com.tally.core.enums.AccountTypeEnums;
import com.tally.core.model.ApiResponse;
import com.tally.core.model.PageData;
import com.tally.core.model.PageWrap;
import com.tally.core.utils.DateUtils;
import com.tally.core.utils.ExampleBuilder;
import com.tally.dao.tallyaccount.model.TallyAccount;
import com.tally.dao.tallyaccountwater.model.TallyAccountWater;
import com.tally.dao.tallyaccountwaterdetail.model.TallyAccountWaterDetail;
import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.dao.tallyorder.TallyOrderMapper;
import com.tally.dao.tallyorder.model.TallyOrder;
import com.tally.dao.tallyorder.model.TallyOrderExample;
import com.tally.dao.tallyorderproduct.TallyOrderProductMapper;
import com.tally.dao.tallyorderproduct.model.TallyOrderProduct;
import com.tally.dao.tallyproduct.model.TallyProduct;
import com.tally.dao.tallyproductspec.model.TallyProductSpec;
import com.tally.service.tallyaccount.TallyAccountService;
import com.tally.service.tallyaccountwater.TallyAccountWaterService;
import com.tally.service.tallyaccountwaterdetail.TallyAccountWaterDetailService;
import com.tally.service.tallybilldetail.TallyBillDetailService;
import com.tally.service.tallyorder.TallyOrderService;
import com.tally.service.tallyproduct.TallyProductService;
import com.tally.service.tallyproductspec.TallyProductSpecService;
import com.tally.service.tallystorageauit.TallyStorageAuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 订单表Service实现
 * @author 131****2893
 * @date 2020/10/27 16:52
 */
@Service
public class TallyOrderServiceImpl implements TallyOrderService {

    @Autowired
    private TallyOrderMapper tallyOrderMapper;
    @Autowired
    private TallyOrderProductMapper tallyOrderProductMapper;
    @Autowired
    private TallyAccountService tallyAccountService;
    @Autowired
    private TallyAccountWaterService tallyAccountWaterService;
     @Autowired
    private TallyProductSpecService tallyProductSpecService;

    @Autowired
    private TallyAccountWaterDetailService tallyAccountWaterDetailService;
    @Autowired
    private TallyBillDetailService tallyBillDetailService;
    @Autowired
    private TallyProductService tallyProductService;

    @Override
    public Integer create(TallyOrder tallyOrder) {
        tallyOrderMapper.insertSelective(tallyOrder);
        return tallyOrder.getId();
    }

    @Override
    public void deleteById(Integer id) {
        tallyOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return;
        for (Integer id: ids) {
            this.deleteById(id);
        }
    }

    @Override
    public void updateById(TallyOrder tallyOrder) {
        tallyOrderMapper.updateByPrimaryKeySelective(tallyOrder);
    }

    @Override
    public void updateByIdInBatch(List<TallyOrder> tallyOrders) {
        if (CollectionUtils.isEmpty(tallyOrders)) return;
        for (TallyOrder tallyOrder: tallyOrders) {
            this.updateById(tallyOrder);
        }
    }

    @Override
    public TallyOrder findById(Integer id) {
        return tallyOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public TallyOrderOutputDto findOne(TallyOrder tallyOrder) {
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        List<TallyOrderOutputDto> tallyOrders = tallyOrderMapper.selectByExample(builder.buildExamplePack(tallyOrder).getExample());
        if (tallyOrders.size() > 0) {
            return tallyOrders.get(0);
        }
        return null;
    }

    @Override
    public List<TallyOrderOutputDto> findList(TallyOrder tallyOrder) {
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        return tallyOrderMapper.selectByExample(builder.buildExamplePack(tallyOrder).getExample());
    }

    @Override
    public List<TallyOrder> findListWithNoSpec(TallyOrder tallyOrder) {
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        return tallyOrderMapper.selectByExampleWithNoSpec(builder.buildExamplePack(tallyOrder).getExample());

    }

    @Override
    public PageData<TallyOrder> findPageWithNoSpec(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyOrderExample, TallyOrderExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        List<TallyOrder> tallyOrders = tallyOrderMapper.selectByExampleWithNoSpec(pack.getExample());
        return PageData.from(new PageInfo<>(tallyOrders));
    }

    @Override
    public PageData<TallyOrderOutputDto> findPage(PageWrap pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyOrderExample, TallyOrderExample.Criteria> pack = builder.buildExamplePack(pageWrap.getModel());
        pack.getExample().setOrderByClause(pageWrap.getOrderByClause());
        return PageData.from(new PageInfo<>(tallyOrderMapper.selectByExample(pack.getExample())));
    }

    @Override
    public long count(TallyOrder tallyOrder) {
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        return tallyOrderMapper.countByExample(builder.buildExamplePack(tallyOrder).getExample());
    }

    @Override
    @Transactional
    public ApiResponse addOrder(OrderInputDto addOrderInputDto) {
        ApiResponse apiResponse = ApiResponse.failed("下单失败！");
        try {
            //插入订单表
            TallyOrder tallyOrder = new TallyOrder();
            tallyOrder.setAmount(addOrderInputDto.getAmount());
            tallyOrder.setDiscout(addOrderInputDto.getDiscout());
            tallyOrder.setTotalPrice(addOrderInputDto.getTotalPrice());
            tallyOrder.setSuccessAmount(BigDecimal.ZERO);
            tallyOrder.setBuyerId(addOrderInputDto.getBuyerId());
            tallyOrder.setBuyerName(addOrderInputDto.getBuyerName());
            tallyOrder.setOrderType(addOrderInputDto.getOrderType());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            Double random =  ((Math.random()*9+1)*100000);
            BigDecimal bg = new BigDecimal(random);
            tallyOrder.setOrderNo(LocalDateTime.now().format(formatter)+bg.setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
            tallyOrder.setPayWay(addOrderInputDto.getPayWay());
            tallyOrder.setStatus(100);
            tallyOrder.setUserId(addOrderInputDto.getUserId());
            if(null!=addOrderInputDto.getAccountId()){
                tallyOrder.setSettleAccountId(addOrderInputDto.getAccountId());
            }else {
                //资金账户为空，则直接使用现金账户
                TallyAccount tallyAccount = new TallyAccount();
                tallyAccount.setUserId(addOrderInputDto.getUserId());
                tallyAccount.setTypeCode(AccountTypeEnums.XJ.getRetCode());
                TallyAccount accounts = tallyAccountService.findOne(tallyAccount);
                tallyOrder.setSettleAccountId(accounts.getId());
            }
            tallyOrder.setRemark(addOrderInputDto.getRemark());
            tallyOrderMapper.insertSelective(tallyOrder);
            //插入订单产品表
            List<TallyOrderProduct> list = new ArrayList();
            for (OrderProductInputDto orderProduct:addOrderInputDto.getList()) {
                TallyOrderProduct tallyOrderProduct = new TallyOrderProduct();
                tallyOrderProduct.setOrderId(tallyOrder.getId());
                tallyOrderProduct.setProductId(orderProduct.getProductId());
                tallyOrderProduct.setProductName(orderProduct.getProductName());
                tallyOrderProduct.setProductNo(orderProduct.getProductNo());
                tallyOrderProduct.setProductSpecId(orderProduct.getProductSpecId());
                tallyOrderProduct.setSpecNum(orderProduct.getSpecNum());
                tallyOrderProduct.setSpecPrice(orderProduct.getSpecPrice());
                tallyOrderProduct.setProductSpecName(orderProduct.getSpecName());
                list.add(tallyOrderProduct);
            }
            tallyOrderProductMapper.insertBatch(list);
            //保存流水
           TallyAccountWater water = tallyAccountWaterService.saveByOrder(tallyOrder,list);
//            //处理库存 //这里不做审核了 麻烦 TODO
//            tallyStorageAuitService.saveByOrder(tallyOrder,list);
            //库存变动
            tallyProductSpecService.updateStorageByOrderProduct(tallyOrder,list);
            //处理账户
            tallyAccountService.updateByOrder(tallyOrder,water,list);
            apiResponse.setSuccess(true);
            apiResponse.setMessage("下单成功！");
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setMessage("下单异常----"+e.getMessage());
        }
        return apiResponse;
    }

    @Override
    @Transactional
    public ApiResponse deliverGoods(OrderInputDto orderInputDto, HttpServletRequest request) {
        return null;
    }

    @Override
    @Transactional
    public ApiResponse takeGoods(OrderInputDto orderInputDto, HttpServletRequest request) {
        return null;
    }

    @Override
    public PageData<TallyOrder> findCollectPage(PageWrap<TallyOrder> pageWrap) {
        PageHelper.startPage(pageWrap.getPage(), pageWrap.getCapacity());
        List<TallyOrder> list = tallyOrderMapper.findCollect(pageWrap.getModel().getUserId(),pageWrap.getModel().getOrderType());
        return PageData.from(new PageInfo<>(list));
    }

    @Override
    public Map<String,String> profitsReport(ProfitsReportInputDto profitsReportInputDto) throws ParseException {
        Integer interval = profitsReportInputDto.getInterval();
        String startDateStr = "";
        Date now = new Date();
        if(interval==0){//当月
               startDateStr = DateUtils.getDateByPattern("yyyy-MM-dd",DateUtils.get1thOfMonth(now));
        }else if(interval==1){//当季
               startDateStr = DateUtils.getDateByPattern("yyyy-MM-dd",DateUtils.getFirstDayOfSeason(Calendar.getInstance()));
        }else if(interval==2){//当年
               startDateStr = DateUtils.getDateByPattern("yyyy-MM-dd",DateUtils.getFirstDayOfYear(Calendar.getInstance()));
        }
        String startDate = startDateStr + " 00:00:00";
        String endDateStr = DateUtils.getDateByPattern("yyyy-MM-dd",now);
        String endDate = endDateStr + " 23:59:59";
        //获取销售订单
        TallyOrder tallyOrder = new TallyOrder();
        tallyOrder.setOrderType(100);
        tallyOrder.setUserId(profitsReportInputDto.getUserId());
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyOrderExample, TallyOrderExample.Criteria> pack = builder.buildExamplePack(tallyOrder);
        if(null!=startDate){
            pack.getCriteria().andCreateTimeBetween(startDate,endDate);
        }
        List<TallyOrderOutputDto> saleList = tallyOrderMapper.selectByExample(pack.getExample());
        //销售额
        BigDecimal salesAmount = BigDecimal.ZERO;
        if(saleList.size()>0)
            salesAmount = new BigDecimal(saleList.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get());
        //计算利润
        BigDecimal profitsAmount = BigDecimal.ZERO;
        if(saleList.size()>0) {
            List<Integer> ids = saleList.stream().map(TallyOrderOutputDto::getId).collect(Collectors.toList());
            profitsAmount = tallyOrderProductMapper.getProfits(ids);
        }
        //获取采购订单 
        tallyOrder.setOrderType(102);
        ExampleBuilder<TallyOrderExample, TallyOrderExample.Criteria> builder2 = ExampleBuilder.create(TallyOrderExample.class, TallyOrderExample.Criteria.class);
        ExampleBuilder.ExamplePack<TallyOrderExample, TallyOrderExample.Criteria> pack2 = builder2.buildExamplePack(tallyOrder);
        if(null!=startDate){
            pack2.getCriteria().andCreateTimeBetween(startDate,endDate);
        }
        List<TallyOrderOutputDto> purchaseList = tallyOrderMapper.selectByExample(pack2.getExample());
        //采购额
        BigDecimal purchaseAmount = BigDecimal.ZERO;
        if(purchaseList.size()>0)
            purchaseAmount = new BigDecimal(purchaseList.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get());
        //收入
        TallyAccountWaterDetail detail = new TallyAccountWaterDetail();
        detail.setUserId(profitsReportInputDto.getUserId());
        detail.setType(100);
        List<WaterDetailOutputDto> incomeList = tallyAccountWaterDetailService.findList(detail,DateUtils.getDate(startDate,"yyyy-MM-dd HH:mm:ss"),DateUtils.getDate(endDate,"yyyy-MM-dd HH:mm:ss"));
        BigDecimal income = BigDecimal.ZERO;
        if(incomeList.size()>0)
            income = new BigDecimal(incomeList.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get());
        //支出
        detail.setType(101);
        List<WaterDetailOutputDto> outcomeList = tallyAccountWaterDetailService.findList(detail,DateUtils.getDate(startDate,"yyyy-MM-dd HH:mm:ss"),DateUtils.getDate(endDate,"yyyy-MM-dd HH:mm:ss"));
        BigDecimal outcome = BigDecimal.ZERO;
        if(outcomeList.size()>0)
            outcome = new BigDecimal(outcomeList.stream().map(e -> e.getAmount().doubleValue()).reduce(Double::sum).get());
        Map map = new HashMap();
        map.put("salesAmount",salesAmount);
        map.put("purchaseAmount",purchaseAmount);
        map.put("profitsAmount",profitsAmount);
        map.put("income",income);
        map.put("outcome",outcome);
        return map;
    }

    @Override
    public PageData<OrderReportOutputDto> salesAndPurchaseReportPage(SalesAndPurchaseReportInputDto inputDto) {
        PageHelper.startPage(inputDto.getPage(), inputDto.getCapacity());
        Integer interval = inputDto.getInterval();
            if(interval==0){//按销量
                List<OrderReportOutputDto> list = tallyOrderMapper.salesAndPurchaseXlReport(inputDto);
                return PageData.from(new PageInfo<>(list));
            }else if(interval==1){//按销售额
                List<OrderReportOutputDto>  list = tallyOrderMapper.salesAndPurchaseXSEReport(inputDto);
                return PageData.from(new PageInfo<>(list));
            }else if(interval==2){//按利润
                List<OrderReportOutputDto>  list = tallyOrderMapper.salesAndPurchaseLRReport(inputDto);
                return PageData.from(new PageInfo<>(list));
            }
        return null;
    }

    @Override
    public PageData<OrderReportOutputDto> cusContributeReport(SalesAndPurchaseReportInputDto inputDto) {
        PageHelper.startPage(inputDto.getPage(), inputDto.getCapacity());
        Integer interval = inputDto.getInterval();
        List<OrderReportOutputDto> list = null;
        if(interval==0){//按销量
            list = tallyOrderMapper.cusContributeXLReport(inputDto);
        }else if(interval==1){//按销售额
            list = tallyOrderMapper.cusContributeXSEReport(inputDto);
        }else if(interval==2){//按利润
            list = tallyOrderMapper.cusContributeLRReport(inputDto);
        }
        return PageData.from(new PageInfo<>(list));
    }

    /**
     * 根据账单生成销售单
     * @param type 100 销售单  102 采购单
     * @param isCreateProduct
     */
    @Override
    public void saveByBill(TallyBill b, Integer userId, Integer btypeUserId, String btypeUserName, Integer type, boolean isCreateProduct) {
        try {
            //插入订单表
            TallyOrder tallyOrder = new TallyOrder();
            tallyOrder.setAmount(b.getTotalPrice());
            tallyOrder.setDiscout(BigDecimal.ZERO);
            tallyOrder.setTotalPrice(b.getTotalPrice());
            tallyOrder.setSuccessAmount(BigDecimal.ZERO);
            tallyOrder.setBuyerId(btypeUserId);
            tallyOrder.setBuyerName(btypeUserName);
            tallyOrder.setOrderType(type);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            Double random =  ((Math.random()*9+1)*100000);
            BigDecimal bg = new BigDecimal(random);
            tallyOrder.setOrderNo(LocalDateTime.now().format(formatter)+bg.setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
            tallyOrder.setPayWay(100);
            tallyOrder.setStatus(100);
            tallyOrder.setUserId(userId);
            /**
             * 默认结算账户为现金账户
             */
            TallyAccount tallyAccount = new TallyAccount();
            tallyAccount.setUserId(userId);
            tallyAccount.setTypeCode(AccountTypeEnums.XJ.getRetCode());
            TallyAccount accounts = tallyAccountService.findOne(tallyAccount);
            tallyOrder.setSettleAccountId(accounts.getId());
            tallyOrder.setRemark(b.getRemark());
            tallyOrderMapper.insertSelective(tallyOrder);
            //插入订单产品表
            List<TallyOrderProduct> list = new ArrayList();
            List<TallyBillDetail> detailList = tallyBillDetailService.findList(TallyBillDetail.builder().billId(b.getId()).build());
            for (TallyBillDetail billDetail:detailList) {
                TallyOrderProduct tallyOrderProduct = new TallyOrderProduct();
                tallyOrderProduct.setOrderId(tallyOrder.getId());
                if(isCreateProduct){
                     TallyProductSpec spec = tallyProductSpecService.findByUserId(userId,TallyProductSpec.builder().specName(billDetail.getProductSpecName()).build());
                    if(null!=spec){
                        tallyOrderProduct.setProductId(spec.getProductId());
                        tallyOrderProduct.setProductName(spec.getSpecName());
                        tallyOrderProduct.setProductNo("");
                        tallyOrderProduct.setProductSpecId(spec.getId());
                    }else{
                        ArrayList<ProductSpecInputDto> objects = Lists.newArrayList();
                        ProductSpecInputDto dto = new ProductSpecInputDto();
                        dto.setSpecName(billDetail.getProductSpecName());
                        dto.setSpecPrice(billDetail.getPerPrice());
                        objects.add(dto);
                        //为用户创建产品
                        AddProductInputDto response = tallyProductService.addProductPlus(AddProductInputDto.builder().name(billDetail.getProductSpecName()).specList(objects).build(), userId.toString());
                        tallyOrderProduct.setProductId(response.getProductId());
                        tallyOrderProduct.setProductName(response.getName());
                        tallyOrderProduct.setProductNo("");
                        tallyOrderProduct.setProductSpecId(response.getSpecList().get(0).getSpecId());
                    }
                }else{
                    tallyOrderProduct.setProductId(billDetail.getProductId());
                    tallyOrderProduct.setProductName(billDetail.getProductSpecName());
                    tallyOrderProduct.setProductNo("");
                    tallyOrderProduct.setProductSpecId(billDetail.getProductSpecId());
                }
                tallyOrderProduct.setSpecNum(billDetail.getNumber());
                tallyOrderProduct.setSpecPrice(billDetail.getPerPrice());
                tallyOrderProduct.setProductSpecName(billDetail.getProductSpecName());
                list.add(tallyOrderProduct);
            }
            tallyOrderProductMapper.insertBatch(list);
            //库存变动
            tallyProductSpecService.updateStorageByOrderProduct(tallyOrder,list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}