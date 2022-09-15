package com.hei.la_Maody.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@SuppressWarnings( "deprecation" )
public class SecurityConf  extends WebSecurityConfigurerAdapter {




        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http
                    .authorizeRequests()
                    .antMatchers(PUT,"/**").anonymous()
                    .antMatchers("/**").permitAll()
                    .and()
                    .cors()
                    .and()
                    .csrf().disable();

        }


}
