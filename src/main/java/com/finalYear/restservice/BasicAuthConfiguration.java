package com.finalYear.restservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.finalYear.restservice.controller.UserController;

@Configuration
@EnableWebSecurity

public class BasicAuthConfiguration 
  extends WebSecurityConfigurerAdapter {
	
	
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("Mary")
          .password("test")
          .roles("USER");
    }
    
 
    @Override
    protected void configure(HttpSecurity http) 
      throws Exception {
        http
          .authorizeRequests()
          .antMatchers("/api/**").permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .cors()
          .and()
          .httpBasic()
          .and()
          .csrf()
          .disable();
    }
}