package com.wellington.applications.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http        
        	.httpBasic()
        	.and()
        	.authorizeRequests()
        		.antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
        		.anyRequest().authenticated()
        	.and()
        	.csrf()
        		.disable()
        	.formLogin()
        		.disable()
        	.headers()
        		.frameOptions()
        			.disable();
    }
}
