package com.jihfan.water.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure (HttpSecurity http) throws Exception{
// disables web security while still being able to use bcrypt
		http.csrf().disable().authorizeRequests().anyRequest().permitAll();
	}
}
