package com.season;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @decription:
 * @author: season
 * @date: 2020/6/23 16:08
 */
@SpringBootApplication
@MapperScan("com.season.dao")
public class SummerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SummerApplication.class, args);
    }
}
