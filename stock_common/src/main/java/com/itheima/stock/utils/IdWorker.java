package com.itheima.stock.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IdWorker {
    public Long nextId(){
        Random random = new Random();
        return random.nextLong();
    }
}
