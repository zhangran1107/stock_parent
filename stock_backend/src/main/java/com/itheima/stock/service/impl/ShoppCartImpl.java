package com.itheima.stock.service.impl;

import com.itheima.stock.mapper.ShoppCartZiMapper;
import com.itheima.stock.mapper.ShoppingCartMapper;
import com.itheima.stock.pojo.domain.ShoppCartDomain;
import com.itheima.stock.pojo.domain.ShoppCartZiDomain;
import com.itheima.stock.pojo.vo.ShoppCartZiParam;
import com.itheima.stock.service.ShoppCartSercive;
import com.itheima.stock.vo.resp.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShoppCartImpl implements ShoppCartSercive {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper ;


    @Autowired
    private ShoppCartZiMapper shoppCartZiMapper ;
    private Object ShoppCartZiDomain;


//
//    @Override
//    public R<Integer> insertShoppCart (Integer bb) {
//
//        shoppingCartMapper.insertShoppCart(bb);
//
//
//        return R.ok(bb);
//
//
//    }


//    @Override
//    public R<Integer> getShoppCart(Integer aa) {
//
//
//
//       Integer ss= shoppingCartMapper.getUserId(aa);
//        if(ss==null){
//            shoppingCartMapper.insertShoppCart(aa);
//
////            ShoppCartDomain shoppCartDomain =new ShoppCartDomain();
////            ss=shoppCartDomain.getId();
//
//        }
//
//
//        return  R. ok(aa);
//
//
//
//    }

//
    public Integer getShoppCartId(Integer aa) {

      Integer ss= shoppingCartMapper.getUserId(aa);
        if(ss==null){
            ShoppCartDomain shoppCartDomain1 =new ShoppCartDomain();
            shoppCartDomain1.setUserId(aa);
            shoppingCartMapper.insertShoppCart(shoppCartDomain1);

             ss=shoppCartDomain1.getId();

        }
        return  ss;
    }


    //数据库里如果有相同的数据 那就修改数据库（增加）
    @Override
    public R<ShoppCartZiDomain> insertShoppCartZi(ShoppCartZiParam param) {

        Integer shoppCartId =getShoppCartId(param.getUserId());
        ShoppCartZiDomain  aa=shoppCartZiMapper.getObject(shoppCartId,param.getCommodityId());


        if(aa!=null){
            aa.setNumber(aa.getNumber()+param.getNumber());
            shoppCartZiMapper.updateNumber(aa);
            return  R. ok(aa);
        }
        else{

            ShoppCartZiDomain shoppCartZiDomain = new ShoppCartZiDomain();


            shoppCartZiDomain.setShoppingCartId(shoppCartId);
            shoppCartZiDomain.setCommodityId(param.getCommodityId());
            shoppCartZiDomain.setNumber(param.getNumber());
            shoppCartZiMapper.insert(shoppCartZiDomain);

            return  R. ok(shoppCartZiDomain);


        }


    }









    //数据库里如果有相同的数据 那就修改数据库（减去）
    @Override
    public R<ShoppCartZiDomain> deleteShoppCartZi2(ShoppCartZiParam param) {

        Integer shoppCartId =getShoppCartId(param.getUserId());
        ShoppCartZiDomain  aa=shoppCartZiMapper.getObject(shoppCartId,param.getCommodityId());


        if(aa!=null){
            aa.setNumber(aa.getNumber()-param.getNumber());
            if(aa.getNumber()<=0 ){
                shoppCartZiMapper.deleteData(aa.getId());
                return  R. ok(aa);
            }else {
                shoppCartZiMapper.updateNumber(aa);
                return  R. ok(aa);
            }


        }
        else{


            return  R. error();


        }


    }






}
