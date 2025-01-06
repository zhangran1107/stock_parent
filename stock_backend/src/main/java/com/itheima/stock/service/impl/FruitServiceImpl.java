package com.itheima.stock.service.impl;

import com.github.pagehelper.PageInfo;
import com.itheima.stock.mapper.FruitMapper;
import com.itheima.stock.pojo.domain.CommodityDomain;
import com.itheima.stock.pojo.domain.FruitDomain;
import com.itheima.stock.service.FruitSercive;
import com.itheima.stock.vo.req.CommodityReq;
import com.itheima.stock.vo.req.FruitReq;
import com.itheima.stock.vo.resp.PageResult;
import com.itheima.stock.vo.resp.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FruitServiceImpl implements FruitSercive {

    @Autowired
    private FruitMapper fruitMapper ;

//    @Autowired
//    private Fruitinsert fruitinsert;

    @Override
    public R<PageResult<FruitDomain>> getFruitPage(FruitReq req) {


        //2.设置分页参数
       // PageHelper.startPage(req.getPage(), req.getPageSize());
        //3.调用mapper查询数据

        if(req.getPage()==null){
            req.setPage(1);
        }
        if(req.getPageSize()==null){
            req.setPageSize(2);
        }



        int  start=( (req.getPage() -1)*req.getPageSize());
        List<FruitDomain> pageData=fruitMapper.getfruitPage(req.getNames(), req.getProduce(),
                req.getAa(),req.getBb() , start, req.getPageSize());




        //判断数据是否为空

        PageInfo<FruitDomain> pageInfo = new PageInfo<>(pageData);
        PageResult<FruitDomain> pageResult = new PageResult<>(pageInfo);
        //4.响应数据
        return R.ok(pageResult);

    }

    @Override
    public R<FruitDomain> getfruitInfo( Integer aa) {
        FruitDomain bb=fruitMapper.getFruit2(aa);

        return  R. ok(bb);
    }




    @Override
    public R<FruitDomain> insertFruit(FruitDomain fruit) {

//       int a= fruitMapper.insert(fruit);


//        return  R. ok(a);



        int a= fruitMapper.insert(fruit);
//        FruitDomain fruit2= new FruitDomain();
//        entities.add(fruit2.getId());
//        FruitDomain bbb= entities.get(0);

        return  R. ok(fruit);

    }


    @Override
    public R<List<FruitDomain>>insertFruit2( List<FruitDomain> fruit) {


      fruitMapper.insertBatch(fruit);

        return  R. ok(fruit);

    }

    @Override
    public R<FruitDomain> updateNameById( FruitDomain fruit) {


      fruitMapper.updateNameById(fruit);

        return  R. ok(fruit);

    }


    @Override
    public R<FruitDomain> updateName( FruitDomain fruit) {


        fruitMapper.updateName(fruit);

        return  R. ok(fruit);


    }


    @Override
    public R<List<FruitDomain>>updateBatch( List<FruitDomain> fruit) {
        for(int i=0 ; i<fruit.size();i++){
            FruitDomain aaa= fruit.get(i);
            fruitMapper.updateBatch(aaa);
        }

        return  R. ok(fruit);

    }


    @Override
    public R<FruitDomain> updateTrends ( FruitDomain fruit) {


        fruitMapper.updateTrends(fruit);
        return  R. ok(fruit);

    }






    @Override
    public R<Integer> deleteById( Integer id) {

        return  R. ok(fruitMapper.deleteById(id));

    }


    @Override
        public R<List<Integer>>deleteMultiple ( List<Integer> id) {
        fruitMapper.deleteMultiple(id);

        return  R. ok(id);

    }


    @Override
    public R<List<String>>deleteName( List<String> name) {
        fruitMapper.deleteName(name);

        return  R. ok(name);

    }













}
