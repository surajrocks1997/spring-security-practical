package com.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
			inMemoryAuthentication()
			.passwordEncoder(passwordEncoder)
			.withUser("test@test.com")
			.password("$2a$10$KvOVOAhnx8JsxtHYsKbY.uaZvpXawoXVWeD4h.jtDGjD9EefqtEsa")
			.roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.anyRequest().hasAnyRole("USER")
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/dashboard")
			.permitAll();
	}
}
