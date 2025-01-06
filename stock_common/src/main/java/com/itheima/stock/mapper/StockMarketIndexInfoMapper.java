package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.InnerMarketDomain;
import com.itheima.stock.pojo.entity.StockMarketIndexInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Entity com.itheima.stock.pojo.entity.StockMarketIndexInfo
 */
public interface StockMarketIndexInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockMarketIndexInfo record);

    int insertSelective(StockMarketIndexInfo record);

    StockMarketIndexInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockMarketIndexInfo record);

    int updateByPrimaryKey(StockMarketIndexInfo record);

    List <InnerMarketDomain> getMarketInfo(@Param("curDate") Date curDate,@Param("marketCodes")List<String> marketCodes);
    List<Map> getSumAmtInfo (@Param("openDate") Date openDate, @Param("endDate") Date endDate, @Param( "marketCodes") List<String> marketCodes);
    int insertBatch(@Param("infos") List<StockMarketIndexInfo> entities);

}
