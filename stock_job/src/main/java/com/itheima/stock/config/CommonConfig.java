package com.itheima.stock.config;


import com.itheima.stock.pojo.vo.StockInfoConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({StockInfoConfig.class})
public class CommonConfig {

//    @Bean
//    public IdWorker idWorker()
//    {
//        return new IdWorker(1l,2l);
//    }


}
