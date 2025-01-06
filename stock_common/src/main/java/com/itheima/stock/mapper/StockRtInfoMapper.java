package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.Stock4EvrDayDomain;
import com.itheima.stock.pojo.domain.Stock4MinuteDomain;
import com.itheima.stock.pojo.domain.StockUpdownDomain;
import com.itheima.stock.pojo.entity.StockRtInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Entity com.itheima.stock.pojo.entity.StockRtInfo
 */
public interface StockRtInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockRtInfo record);

    int insertSelective(StockRtInfo record);

  //  StockRtInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockRtInfo record);

    int updateByPrimaryKey(StockRtInfo record);

    List<StockUpdownDomain> getStockInfoByTime(@Param("curDate") Date curDate);

    List<Map> getStockUpdownCount (@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("flag") int flag);

    List<Map> getIncreaseRangeInfoByDate (@Param("dateTime") Date curtDate);

    List<Stock4MinuteDomain> getStock4MinuteInfo(@Param("openDate") Date openDate, @Param("endDate") Date endDate, @Param("stockCode") String stockCode);

    List<Stock4EvrDayDomain> getStock4DKLine(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("stockCode") String stockCode);


}
