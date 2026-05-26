package com.liyu.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport{


    @Bean
    public Docket docket (){
        log.info("准备生成接口文档");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("接口文档")
                .description("接口文档")
                .version("1.0")
                .build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liyu.Controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("准备加载静态资源");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        log.info("配置跨域映射");
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5500","http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
