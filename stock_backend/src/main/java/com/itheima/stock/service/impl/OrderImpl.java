package com.itheima.stock.service.impl;

import com.itheima.stock.mapper.*;
import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.OrderZhuDomain;
import com.itheima.stock.pojo.domain.OrderZiDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.pojo.vo.OrderZiParam;
import com.itheima.stock.service.OrderSercive;
import com.itheima.stock.vo.resp.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderImpl implements OrderSercive {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper ;

    @Autowired
    private ShoppCartZiMapper shoppCartZiMapper ;

    @Autowired
    private OrderMapper orderMapper ;


    @Autowired
    private OrderZiMapper orderZiMapper ;
    @Autowired
    private CommodityMapper commodityMapper ;







    @Override
    public R<OrderZhuDomain> insertOrderZhu (OrderZiParam orderZiParam){
        OrderZhuDomain  orderZhuDomain1 =new OrderZhuDomain();
        //购物车子表里查出number 跟  Commodity
        //获取 shoppingCartId ID 从购物车主表
        Integer dd=shoppingCartMapper.getUserId(orderZiParam.getUserId());
        //查出的是 commodityId 跟number
        List<ShoppCartZiDomain> ee =shoppCartZiMapper.getnumber(orderZiParam.getCommodityId(),dd);

        //是商品表中的 map key 是commodityId  number
        Map<Integer,Integer> map1 =new HashMap<>();
        for(int i=0;i<ee.size();i++){
            map1.put(ee.get(i).getCommodityId(),ee.get(i).getNumber());

        }
        //获取输入的三个商品id commodityId 的对应的价格 从商品表中
        List<CommodityDomain> number=commodityMapper.getCommodityprice(orderZiParam.getCommodityId());
        //得出相加的价格
        Integer ff=0;
        for(CommodityDomain commodityDomain:number){

            //只需要把number跟价格 相乘
          ff+= map1.get(commodityDomain.getId())*commodityDomain.getPrice();

            //获取UserId 从传进来的参数中
            Integer userid=orderZiParam.getUserId();
            //获取当前时间
            Date currentDate = new Date();

            orderZhuDomain1.setUserId(userid);
            orderZhuDomain1.setTotalPrice(ff);
            orderZhuDomain1.setConstruct(currentDate);
        }





        orderMapper.insertOrder2(orderZhuDomain1);


         //子表

        OrderZiDomain orderZiDomain2 =new OrderZiDomain();
        // 得到 order_zhu_id 从上面完成的主表中
        orderZiDomain2.setOrderZhuId(orderZhuDomain1.getId());
        //得到三条ID 对应的三个价格 从商品表中 得到三条数据
        List<CommodityDomain> aa=commodityMapper.getPrice(orderZiParam.getCommodityId());

        //是商品表中的 map key 是商品表中的id,value price 获取了id 跟 price
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<aa.size();i++){
            map.put(aa.get(i).getId(),aa.get(i).getPrice());

        }

        //从购物车子表中找到对应的三条数据,根据 购物车主表 id(shopping_cart_id和 commodity_id),找 commodity_id（商品id）和数量 （number）
        //获取 shoppingCartId ID 从购物车主表

         Integer bb=shoppingCartMapper.getUserId(orderZiParam.getUserId());

        //查出的是 commodityId 跟number
        List<ShoppCartZiDomain> cc =shoppCartZiMapper.getnumber(orderZiParam.getCommodityId(),bb);



       //把商品表中 商品id  和价格 出来三条数据, 到购物子表中把商品ID  和数量查出来，第三然后把这两个表连在一起ID相同的就是同一条形成了一个表,写到子表里
       //循环 commodityId 跟number 查出来的结果也就是CC

        for(ShoppCartZiDomain shoppCartZiDomain: cc){
            //新建 订单子表的对象
            OrderZiDomain orderZiDomain1 = new OrderZiDomain();
            // 塞进 order_Zhu_id
            orderZiDomain1.setOrderZhuId(orderZhuDomain1.getId());

            //塞进价格
            orderZiDomain1.setPrice(map.get(shoppCartZiDomain.getCommodityId()));

            //塞进商品id
            orderZiDomain1.setCommodityId(shoppCartZiDomain.getCommodityId());
            //塞进数量
            orderZiDomain1.setNumber(shoppCartZiDomain.getNumber());

            //插入订单子表对象

            orderZiMapper.insertOrderZi(orderZiDomain1);


        }


        //下完单后购物车里的数据里没有了

//        shoppCartZiMapper. getshoppingCartId(shoppCartZiDomain.getCommodityId(),dd);

        //shoppCartZiMapper.deleteid()



        return R. ok(orderZhuDomain1);

    }











  }
