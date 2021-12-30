package com.tally.dao.tallybilldetail;

import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybilldetail.model.TallyBillDetail;
import com.tally.dao.tallybilldetail.model.TallyBillDetailExample;
import org.apache.ibatis.annotations.Param;
  
import java.util.List;

public interface TallyBillDetailMapper {
    int countByExample(TallyBillDetailExample example);

    int deleteByExample(TallyBillDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyBillDetail record);

    int insertSelective(TallyBillDetail record);

    List<TallyBillDetail> selectByExample(TallyBillDetailExample example);

    TallyBillDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyBillDetail record, @Param("example") TallyBillDetailExample example);

    int updateByExample(@Param("record") TallyBillDetail record, @Param("example") TallyBillDetailExample example);

    int updateByPrimaryKeySelective(TallyBillDetail record);

    int updateByPrimaryKey(TallyBillDetail record);

    void insertBatch(List batchList);

    List<TallyBillDetail> findByBillId(Integer id);

    List<TallyBillDetail> findCollectLList(@Param("billIds")List<Integer> billIds);

    List<TallyBillDetail> getToSettleDeatials(@Param("userId")Integer userId, @Param("productSpecId")Integer productSpecId);

    void updateSettledByBillId(Integer billId);
}