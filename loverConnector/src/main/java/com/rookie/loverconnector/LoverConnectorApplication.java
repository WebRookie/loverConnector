package com.rookie.loverconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author WebRookie
 */
@SpringBootApplication
//@MapperScan({"com.rookie.loverconnector.**.dao"})
@EnableWebMvc
public class LoverConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoverConnectorApplication.class, args);
    }

}
