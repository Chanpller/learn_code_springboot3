package com.chanpller.chapter5security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author lfy
 * @Description
 * @create 2023-03-08 16:54
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
//                        .requestMatchers("/hello").hasAnyRole("hello","world")
//                        .requestMatchers("/world").hasRole("world")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())//开启表单登录，默认登录页面是/login
//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("hello")
                        .build();
        UserDetails test =
                User.withDefaultPasswordEncoder()
                        .username("test")
                        .password("test")
                        .roles("world")
                        .build();
        return new InMemoryUserDetailsManager(user,test);
    }
}