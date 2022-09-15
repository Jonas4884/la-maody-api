package com.hei.la_Maody.Security;

import com.hei.la_Maody.service.securityService.UserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConf extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(GET,"/user/**").permitAll()
                .antMatchers(GET,"/role/**").permitAll()
                .antMatchers("/test/roles/admin").hasRole("admin")
                .antMatchers("/test/roles/user").hasAnyRole("admin", "user")
                .antMatchers(PUT,"/product/**").hasAnyRole("admin")
                .antMatchers(GET,"/customer/**").hasAnyRole("admin    ")
                .antMatchers(GET,"/item/**").anonymous()
                .and()
                .formLogin()
                .disable().cors()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .cors().disable()
                .httpBasic();
    }

    @Bean
    protected PasswordEncoder getPass (){
        return new BCryptPasswordEncoder();
    }
}

