package com.rookie.loverconnector;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WebRookie
 */
@SpringBootApplication
@MapperScan({"com.rookie.loverconnector.**.dao"})
public class LoverConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoverConnectorApplication.class, args);
    }

}
