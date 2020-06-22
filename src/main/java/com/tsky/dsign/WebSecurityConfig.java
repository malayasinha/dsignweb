package com.tsky.dsign;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("Select USER_ID,PASSWORD,IS_ACTIVE from dsignwebdb.TBL_USERS where USER_ID = ?")
				.authoritiesByUsernameQuery("Select USER_ID,AUTHORITY_ID from dsignwebdb.TBL_USER_AUTHORITY where USER_ID = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.and()
		.formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("USER_ID")
				.passwordParameter("PASSWORD")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and()
				.exceptionHandling().accessDeniedPage("/403")
		.and().csrf();
	}
}
