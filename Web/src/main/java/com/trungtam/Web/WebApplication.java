package com.trungtam.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.trungtam.service_iml.serviceSercurity;

@SpringBootApplication(scanBasePackages="com.trungtam")
@EntityScan(basePackages="com.trungtam.modelEntity")
public class WebApplication extends WebSecurityConfigurerAdapter{

	@Autowired
	serviceSercurity sercurity;
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/listjson","/listjson1").permitAll()
		
		.anyRequest().authenticated().and().formLogin().loginPage("/login")
		.defaultSuccessUrl("/trungtam").failureUrl("/login?e=erro").permitAll()
		
		.and().logout().permitAll();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
		auth.userDetailsService(sercurity);
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/CSS/**","/img/**");
	}
}
