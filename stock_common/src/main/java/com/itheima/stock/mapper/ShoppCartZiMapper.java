package com.itheima.stock.mapper;

import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.pojo.domain.LipstickDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShoppCartZiMapper {

    //如果没找到就插入数据
    int insert(ShoppCartZiDomain shoppCartZi);


    //查找传入的两个参数，数据库里有没有相同的数据
    ShoppCartZiDomain getObject(@Param("shoppingCartId") Integer shoppingCartId ,
                  @Param("commodityId") Integer commodityId);
  //数据库里如果有相同的数据 那就修改数据库（增加）
    int updateNumber(ShoppCartZiDomain stop);


    //数据库里如果有相同的数据 那就修改数据库（减去）
    int updateNumber2(ShoppCartZiDomain stop);
    //数据库里如果 数量小于等于0 那就修改数据库删除数据
    int deleteData(@Param("id") Integer id);

    //下完单后购物车里的数据里没有了所以需要删除
    int deleteid(@Param("ids") List<Integer> ids);

    //下完单后购物车里的数据里没有了所以需要删除 删除id之前先查找id
    List<Integer> getshoppingCartId(@Param("shoppingCartId") Integer shoppingCartId ,
                                @Param("commodityId") List<Integer> commodityId);

    //查找数量
    List<ShoppCartZiDomain>getnumber(@Param("commodityIds") List<Integer> commodityIds, @Param("shoppingCartId") Integer shoppingCartId);

    //查找不是list 的单个数量
    Integer getnumberdan(@Param("commodityId") Integer commodityId, @Param("shoppingCartId") Integer shoppingCartId);

    //根据在shopping_cart_zi 表中 根据 shoppingCartId 和 commodityId 找到List<id>
    Integer getShoppCartZiid(@Param("commodityId") Integer commodityId,@Param("shoppingCartId")  Integer  shoppingCartId);




}
