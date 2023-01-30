package com.jejuro.server.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jejuro.server.auth.service.CustomOAuth2UserService;

@Configuration
public class JejuroSecurityConfig {

        @Autowired
        private CustomOAuth2UserService CustomOAuth2UserService;

        @Autowired
        private UserDetailsService JejuroUserDetailsService;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                                .csrf()
                                .disable()
                                .authorizeHttpRequests(authorize -> authorize // 회원 권한 테스트
                                                .requestMatchers("/search/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                                .requestMatchers("/post/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                                                .anyRequest().permitAll())

                                .exceptionHandling(exp -> exp
                                                .accessDeniedPage("/denied")) // 인가 실패시 처리

                                .formLogin(form -> form
                                                .loginPage("/member/login")
                                                .defaultSuccessUrl("/index"))

                                .logout(form -> form
                                                .logoutUrl("/member/logout")
                                                .logoutSuccessUrl("/index"))

                                .oauth2Login(oauth2 -> oauth2
                                                .userInfoEndpoint()
                                                .userService(CustomOAuth2UserService))
                                                
                                // 소셜 로그인 완료된 뒤의 후처리가 필요함.
                                // Tip. 코드X, (엑세스 토큰+사용자 프로필 정보)
                                // oauth2 로그인에 성공하면, 유저 데이터를 가지고 우리가 생성한 customOAuth2UserService에서 처리를 하겠다.

                                .rememberMe(form -> form
                                                .key("uniqueAndSecret") // 인증을 위해 발행되는 토큰을 구별하는 키 이름
                                                .userDetailsService(JejuroUserDetailsService)
                                                .rememberMeParameter("remember-me") // 로그인 페이지 html 파라미터 이름
                                                .tokenValiditySeconds(60 * 60 * 24)); // 토큰 유효시간(s) 디폴트는 2주

                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        };
}
