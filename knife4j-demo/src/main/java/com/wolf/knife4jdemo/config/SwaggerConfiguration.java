package com.wolf.knife4jdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author zhangle
 * @CreateTime 2021-12-15 09:58:12
 * @Description Swagger配置
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket defaultApi2(){
        Docket docket = new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("dev")
                .select()
                //指定controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.wolf.knife4jdemo.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

    public ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("knife4j 3.0.2版本 使用")
                .description("Api接口管理工具Knife4j")
                .version("v1.0.0")
                .contact(new Contact("李白","https://www.baidu.com","libai@qq.com"))
                .termsOfServiceUrl("https://127.0.0.1:8081/api")
                .build();
        return apiInfo;
    }
}
