//package com.example.demo.authentication;
//
//import com.example.demo.services.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Configuration
////@EnableWebSecurity
//public class SecurityConfiguration {
//
////    @Autowired
////    private UserDetailsServiceImpl userDetailsService;
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////    }
////
////    @Bean
////    public AuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
////        provider.setUserDetailsService(userDetailsService);
////        provider.setPasswordEncoder(passwordEncoder());
////        return provider;
////    }
////
////    @Configuration
////    @Order(1)
////    public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
////        @Override
////        protected void configure(HttpSecurity http) throws Exception {
////            http.antMatcher("/api/**")
////                    .authorizeRequests()
////                    .anyRequest().authenticated()
////                    .and()
////                    .httpBasic();
////        }
////    }
////
////    @Configuration
////    @Order(2)
////    public static class FormLoginSecurityConfig extends WebSecurityConfigurerAdapter {
////        @Override
////        protected void configure(HttpSecurity http) throws Exception {
////            http.authorizeRequests()
////                    .antMatchers("/public/**").permitAll()
////                    .antMatchers("/admin/**").hasRole("ADMIN")
////                    .anyRequest().authenticated()
////                    .and()
////                    .formLogin()
////                    .loginPage("/login")
////                    .permitAll()
////                    .and()
////                    .logout()
////                    .permitAll();
////        }
////    }
////
////    // Other beans and configurations...
////
////}
//}