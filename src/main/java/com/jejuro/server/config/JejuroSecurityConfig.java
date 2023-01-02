package com.jejuro.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jejuro.server.auth.service.JejuroUserDetailsService;

@Configuration
public class JejuroSecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                                .csrf()
                                .disable()
                                .authorizeHttpRequests(authorize -> authorize // 회원 권한 테스트
                                                .requestMatchers("/search/**").hasAnyRole("MEMBER", "ADMIN")
                                                .requestMatchers("/post/**").hasAnyRole("MEMBER", "ADMIN")
                                                .anyRequest().permitAll())
                                
                                .exceptionHandling(exp -> exp
                                                .accessDeniedPage("/denied")) // 인가 실패시 처리

                                .formLogin(form -> form
                                                .loginPage("/member/login")
                                                .defaultSuccessUrl("/index"))

                                .logout(form -> form
                                                .logoutUrl("/member/logout")
                                                .logoutSuccessUrl("/index"))

                                .rememberMe(form -> form
                                                .key("uniqueAndSecret") // 인증을 위해 발행되는 토큰을 구별하는 키 이름
                                                .rememberMeParameter("remember-me") // 로그인 페이지 html 파라미터 이름
                                                .tokenValiditySeconds(60 * 60 * 24)) // 토큰 유효시간(s) 디폴트는 2주
                ;

                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        };

        @Bean
        public UserDetailsService jejuroUserDetailsService() {
                return new JejuroUserDetailsService();
        }
}
