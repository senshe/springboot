package com.rimitech.sgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rimitech.sgr.security.AccountDetailsService;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true)
public class SecurityConfig{
	
	
	@Autowired
	private  AccountDetailsService accountDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(accountDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	  
	@Configuration
	@Order(1)                                                       
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/suiviapi/add/**")                              
				.authorizeRequests()
					.anyRequest()
					.authenticated()
					.and()
				.httpBasic();
			http.csrf().disable();
		}
	}

	@Configuration
	
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Override
		  protected void configure(HttpSecurity http) throws Exception {
				//http.csrf().disable();
				/*
				 *  
				 */
				//	http.authorizeRequests().anyRequest().permitAll();
				//*/
				
				//*
		//	http.ignoring().antMatchers("/webjars/**","/css/**","/js/**","/img/**","/font-awesome/**");
				http
			      .authorizeRequests()
			      		.antMatchers("/webjars/**","/css/**","/js/**","/img/**","/font-awesome/**").permitAll()
			      		.antMatchers("/structure/**").access("hasAuthority('ADMIND')")
			      		.antMatchers("/user/**").access("hasAuthority('ADMINS')")
			      		.anyRequest()
			      		.authenticated()
			         	.and()
			      .formLogin()
			      		.loginPage("/login")
						.defaultSuccessUrl("/")
						.failureUrl("/login")				
						.permitAll()
						.and()
				.logout()
						.invalidateHttpSession(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.permitAll();
				//*/
			  }
			
		
	}
}
