package com.jejuro.server.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.jejuro.server.auth.service.JejuroUserDetailsService;

@Configuration
public class JejuroSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/search/**").hasAnyRole("ADMIN")
                        .requestMatchers("/post/**").hasAnyRole("MEMBER", "ADMIN")
                        .anyRequest().permitAll())

                .formLogin(form -> form
                        .loginPage("/member/login")
                        .defaultSuccessUrl("/index"))
                .exceptionHandling(exp -> exp.accessDeniedPage("/denied"))
                .logout(form -> form
                        .logoutUrl("/member/logout")
                        .logoutSuccessUrl("/index"));

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
