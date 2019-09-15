package com.wellington.applications.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
        	.antMatchers("/api/**").authenticated()
        	.anyRequest().permitAll()
        	.and()
        	.csrf()
        		.disable()
        	.formLogin()
        		.disable()
        	.headers()
        		.frameOptions()
        			.disable();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources/**",
                                   "/configuration/security",
                                   "/swagger-ui.html",
                                   "/webjars/**",
                                   "/webjars/springfox-swagger-ui/springfox.js?v=2.9.2:1",
                                   "/csrf", 
                                   "/",
                                   "/api/v1/user/save");
    }
}
