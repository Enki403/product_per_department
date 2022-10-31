package com.product_per_department.product_per_department.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.product_per_department.product_per_department.service.ServiceUsuario;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    String[] resources = new String[]{
        "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };

    // no se toma en cuenta el autenticado
    // multiples intentos resultaron errados

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	        .antMatchers(resources).permitAll()  
	        .antMatchers("/login").permitAll()
                .anyRequest().permitAll()
                //.anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout")
            .and()
            .csrf()
            .disable();
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, contrasenia, 1 activo FROM tbl_usuario where username=?")
            .authoritiesByUsernameQuery("SELECT username, 'USER' role FROM tbl_usuario " 
                + " WHERE username=?");
    }
    
    // @Autowired
    // ServiceUsuario userDetailsService;

    // @Autowired
    // public void configure(AuthenticationManagerBuilder auth) throws Exception { 
    //     auth.userDetailsService(UserDetails).passwordEncoder(passwordEncoder());     
    // }
}
