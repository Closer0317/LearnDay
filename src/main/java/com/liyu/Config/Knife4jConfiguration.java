package com.liyu.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j + SpringDoc 配置（OpenAPI 3 / Jakarta EE）
 * <p>
 * 访问地址：{@code http://127.0.0.1:8080/doc.html}
 * <p>
 * Knife4j 4.x 增强功能通过 application.yml 中的 {@code knife4j.enable: true} 启用，
 * 无需 @EnableKnife4j 注解。
 */
@Configuration
@Slf4j
public class Knife4jConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        log.info("初始化 Knife4j OpenAPI 文档配置");
        return new OpenAPI()
                .info(new Info()
                        .title("LearnDay 接口文档")
                        .description("LearnDay 学习平台 API 接口文档")
                        .version("1.0.0"));
    }
}
