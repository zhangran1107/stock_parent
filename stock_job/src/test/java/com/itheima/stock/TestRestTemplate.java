package com.itheima.stock;

import com.itheima.stock.pojo.Account;
import com.itheima.stock.service.StockTimerTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockTimerTaskService stockTimerTaskService;

    public void test01() {
        String url = "http://localhost:6766/account/getByUserNameAndAddress?userName=zhangsan&address=sh";
        ResponseEntity<String> resp = restTemplate.getForEntity(url, String.class);
        //获取响应头
        HttpHeaders headers = resp.getHeaders();
        System.out.println(headers);
        //获取响应的状态码200
        int statusCode = resp.getStatusCodeValue();

        System.out.println(statusCode);

        //获取响应的数据
        String respData = resp.getBody();
        //获取响应的数据
        System.out.println(respData);


    }


    @Test
    public void test02() {
        String url="http://localhost:6766/account/getByUserNameAndAddress?userName=zhangsan&address=sh";
     //   ResponseEntity<Account> resp = restTemplate.getForEntity(url, Account.class);
        Account account = restTemplate.getForObject(url, Account.class);
        System.out.println(account);


    }


    @Test
    public void test03(){
        String url="http://localhost:6766/account/getHeader";
        //设置请求头参
        HttpHeaders headers = new HttpHeaders() ;
         //请求头填充到请求对象下
        headers.add("userName","zhangsan");
        HttpEntity<Map> entry = new HttpEntity<>(headers);
        //发送请求
        ResponseEntity<String> responseEntity = restTemplate.exchange (url, HttpMethod.GET, entry, String.class);

        String result = responseEntity.getBody();
        System.out.println(result);
    }

    @Test
    public void test04(){
        String url="http://localhost:6766/account/addAccount";
        //设置请求头参
        HttpHeaders headers = new HttpHeaders() ;
        //请求头填充到请求对象下
        headers.add("'Content-type","application/x-www-form-urlencoded");
        LinkedMultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
        map. add("id", "10");
        map. add("userName", "itheima");
        map. add ( "address", "shanghai") ;
        HttpEntity<LinkedMultiValueMap<String, Object>> httpEntity = new HttpEntity<>(map,headers) ;
        ResponseEntity<Account> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Account.class);
        Account body = exchange.getBody();
        System.out. println(body);

    }

    @Test
    public void test06(){
        String url=" http://localhost:6766/account/getCookie";
        ResponseEntity<String> result = restTemplate.getForEntity(url,String.class);
        //获取cookie
        List<String> cookies = result. getHeaders().get("Set-Cookie");
        //获取响应数据
        String resStr = result.getBody();
        System. out. println(resStr);
        System. out. println(cookies);
    }


    @Test
    public void testInnerGetMarketInfo() {
        stockTimerTaskService.getInnerMarketInfo();
    }




}