package com.ricky.carmechanic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.ricky.carmechanic.mapper")
public class CarmechanicApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarmechanicApplication.class, args);
    }

}
