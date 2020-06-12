package com.springbootdev.amazon.s3.example.aws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
       //  .and()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
    }
  
    @Autowired    
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    	
    	
       }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
   
}