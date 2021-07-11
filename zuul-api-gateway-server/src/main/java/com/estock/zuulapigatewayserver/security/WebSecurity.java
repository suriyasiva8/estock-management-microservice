package com.estock.zuulapigatewayserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().cors();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/swagger-ui.html").permitAll().antMatchers("/webjars/**").permitAll()
				.antMatchers("/swagger-resources/**").permitAll().antMatchers("/actuator/*").permitAll()
				.antMatchers("/estock-users/actuator/*").permitAll().antMatchers("/estock-management/actuator/*")
				.permitAll().antMatchers("/estock-cloud-config-server/actuator/*").permitAll()
				.antMatchers("/estock-eureka-naming-server/actuator/*").permitAll()
				.antMatchers("/estock-users/v2/api-docs").permitAll().antMatchers("/estock-management/v2/api-docs")
				.permitAll().antMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path"))
				.permitAll().antMatchers(HttpMethod.POST, environment.getProperty("api.login.url.path")).permitAll()
				.anyRequest().authenticated().and()
				.addFilter(new AuthorizationFilter(authenticationManager(), environment));

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

}
