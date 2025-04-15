package com.project.pathfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // CORS 지원 활성화
                .and()
                .csrf().disable() // 테스트 목적으로 CSRF 비활성화
                .headers(headers -> headers
                        .contentSecurityPolicy("default-src 'self'; " +
                                "img-src 'self' blob: data: https://dapi.kakao.com http://*.daumcdn.net; " +
                                "connect-src 'self' http://43.203.203.157:8085")
                )
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll() // 모든 요청 허용
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
