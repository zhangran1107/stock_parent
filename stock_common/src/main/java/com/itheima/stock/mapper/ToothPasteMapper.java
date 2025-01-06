package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.Toothpaste222Domain;
import com.itheima.stock.pojo.domain.ToothpasteDomain;
import com.itheima.stock.pojo.domain.ToothpasteinformationDomain;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * @Entity com.itheima.stock.pojo.entity.ToothpasteRtinfo
 */

public interface ToothPasteMapper {

    List<ToothpasteDomain> getToothPasteByTime(@Param("names") List<String> names);

    List<ToothpasteinformationDomain> getToothPaste();

    List<Toothpaste222Domain> getToothPaste2(@Param("names") List<String> names);


    List<ToothpasteinformationDomain> getToothPaste3();

    List<Toothpaste222Domain> getToothPaste4(@Param("name") String name);




}
