package com.tally.dao.tallybill;

import com.tally.dao.tallybill.model.TallyBill;
import com.tally.dao.tallybill.model.TallyBillExample;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TallyBillMapper {
    int countByExample(TallyBillExample example);

    int deleteByExample(TallyBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TallyBill record);

    int insertSelective(TallyBill record);
	
    List<TallyBill> selectByExampleWithBLOBs(TallyBillExample example);

    List<TallyBill> selectByExample(TallyBillExample example);

    TallyBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TallyBill record, @Param("example") TallyBillExample example);

    int updateByExampleWithBLOBs(@Param("record") TallyBill record, @Param("example") TallyBillExample example);

    int updateByExample(@Param("record") TallyBill record, @Param("example") TallyBillExample example);

    int updateByPrimaryKeySelective(TallyBill record);

    int updateByPrimaryKeyWithBLOBs(TallyBill record);

    int updateByPrimaryKey(TallyBill record);

    List<TallyBill> findListByIds(List<String> list, @Param("userId")String userId);

    Map materialCount(TallyBill bill);

    BigDecimal sfCountplus(@Param("userId")Integer userId,@Param("btypeUserId")Integer btypeUserId,@Param("type")Integer type);

    Map sfCount(TallyBill bill);

    List<TallyBill> findList(@Param("bill")TallyBill bill, @Param("userIdList") List userIdList, @Param("btypeUserMobileList") List btypeUserMobileList);


    List<TallyBill> billCollectList(TallyBill bill);

    List<TallyBill> findMaterialList(@Param("userId") String userId, @Param("type1") Integer type1,
                                     @Param("type2") Integer type2, @Param("status") Integer status,
                                     @Param("btypeUserId")Integer btypeUserId);

    Integer updateByVersion(TallyBill b);

    List<TallyBill> findMaterialCollectList(@Param("userId")String userId, @Param("type1")Integer type1,
                                            @Param("type2")Integer type2, @Param("status")Integer status);

    List<TallyBill> findMaterialShList(@Param("userId")String userId, @Param("type1")Integer type1,
                                       @Param("type2")Integer type2, @Param("status")Integer status);
}