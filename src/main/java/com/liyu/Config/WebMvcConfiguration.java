package com.liyu.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 配置 — CORS + Knife4j 静态资源映射
 */
@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * Knife4j 文档页面 + WebJars 静态资源
     * <p>
     * Knife4j 4.x 的 doc.html 和 webjars 可能不在 Spring Boot 默认扫描路径，
     * 手动注册确保 /doc.html 和 /webjars/** 能被正确访问。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("注册 Knife4j 静态资源映射");
        registry.addResourceHandler("/doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * Spring MVC 层 CORS（兜底）
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("配置 CORS 映射");
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    /**
     * Servlet 层 CORS Filter — 最先拦截，包括 OPTIONS 预检
     */
    @Bean
    public CorsFilter corsFilter() {
        log.info("注册 CorsFilter");
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
