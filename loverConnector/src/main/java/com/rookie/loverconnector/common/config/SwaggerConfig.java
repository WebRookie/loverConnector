package com.rookie.loverconnector.common.config;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Documentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author WebRookie
 * @date 2023/7/19 16:22
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("loverConnector接口文档")
                        .description("swaggerFor MiniProgramApi")
                        .version("v1.0")
                        .contact(new Contact("rookie", "https://github.com/WebRookie", "912962951@gmail.com"))
                        .build()
                ).select()
                .apis(RequestHandlerSelectors
                        .withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }
}
