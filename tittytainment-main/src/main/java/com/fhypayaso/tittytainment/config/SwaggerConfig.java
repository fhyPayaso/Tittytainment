package com.fhypayaso.tittytainment.config;

import io.swagger.annotations.ApiOperation;
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

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2020/12/28 3:43 下午
#   @Description   : swagger 配置类 访问地址 http://localhost:8080/swagger-ui.html#/
# ====================================================*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //添加ApiOperiation注解的被扫描
                .paths(PathSelectors.any())
                .build();
//                .globalOperationParameters(pars); // 后面可以加token

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("fhyPayaso", "https://github.com/fhyPayaso", "410619823@qq.com"))
                .title("Tittytainment API文档")
                .description("后端接口文档")
                .version("1.0").build();
    }

}