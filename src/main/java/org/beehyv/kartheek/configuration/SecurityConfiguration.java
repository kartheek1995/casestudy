package org.beehyv.kartheek.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
 
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().authorizeRequests()
        .antMatchers("/static/html/home.htm").access("hasRole('USER')")
        .antMatchers("/static/html/productdetails.htm").access("hasRole('USER')")
        .antMatchers("/static/html/cart.htm").access("hasRole('USER')")
        .antMatchers("/static/html/order.htm").access("hasRole('USER')")
        .antMatchers("/static/html/electronics.htm").access("hasRole('USER')")
        .antMatchers("/static/html/sports.htm").access("hasRole('USER')")
        .antMatchers("/static/html/account.htm").access("hasRole('USER')")
        .antMatchers("/static/html/books.htm").access("hasRole('USER')")
        .antMatchers("/static/html/clothes.htm").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .and().formLogin().loginPage("/login")
        .loginProcessingUrl("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
