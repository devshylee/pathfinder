package com.project.pathfinder.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정
                .allowedOrigins("http://ec2-43-203-203-157.ap-northeast-2.compute.amazonaws.com", "http://ec2-43-203-203-157.ap-northeast-2.compute.amazonaws.com:8085","http://localhost:3000", "http://43.203.203.157:8085", "http://43.203.203.157", "http://127.0.0.1:5500") // 특정 출처 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowedHeaders("*") // 모든 헤더 허용
                .allowCredentials(true); // 자격 증명 포함 요청 허용
    }
}
