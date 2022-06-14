package com.cybermax.samples.spring_native_service.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
       
	private static final String SCOPE_ALL = "SCOPE_test.agent.admin";
    private static final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html",
    };
    private static final String[] ACTUATOR_WHITELIST = {
            "/actuator/health/readiness",
            "/actuator/health/liveness"
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off

		     http
		    	.cors().and().csrf().disable()
		        .exceptionHandling()
		    .and()
		        .headers()
		        .frameOptions()
		        .disable()
		    .and()
		        .sessionManagement()
		        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
                .authorizeRequests()
                .antMatchers(ACTUATOR_WHITELIST).permitAll()
                .antMatchers(SWAGGER_WHITELIST).permitAll()       
                .antMatchers("/actuator").hasAuthority(SCOPE_ALL)
                .antMatchers("/actuator/**").hasAuthority(SCOPE_ALL)
                .antMatchers("/api/v1/**").permitAll();
                //.anyRequest().authenticated();
                //.anyRequest().denyAll()
//             .and()   
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt());
        // @formatter:on

    }
  
}