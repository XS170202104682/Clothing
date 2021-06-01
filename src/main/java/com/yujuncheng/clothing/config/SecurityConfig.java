package com.yujuncheng.clothing.config;

import com.yujuncheng.clothing.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/assets/**","/css/**","/images/**","/js/**","/layui/**").permitAll()
                .antMatchers("/adminLogin").permitAll()
                .antMatchers("/adminRegister").permitAll()
                .antMatchers("/login1").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/toRegister").permitAll()
                .antMatchers("/toLogin").permitAll()
                .antMatchers("/customerLogin").permitAll()
                .antMatchers("/customerRegister").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/showClothes").permitAll()
                .antMatchers("/nozari/**").permitAll()
                .antMatchers("/toCart").permitAll()
                .antMatchers("/sortClothes").permitAll()
                .antMatchers("/sortClothes1").permitAll()
                .antMatchers("/sortShoe").permitAll()
                .antMatchers("/sortShoe1").permitAll()
                .antMatchers("/sortUnderWear").permitAll()
                .antMatchers("/sortUnderWear1").permitAll()
                .antMatchers("/deleteCart").permitAll()
                .antMatchers("/addToCart").permitAll()
                .antMatchers("/detailClothes").permitAll()
                .antMatchers("/sortByName").permitAll()
                .antMatchers("/becomeOrder").permitAll()
                .antMatchers("/ctrLogout").permitAll()
                .antMatchers("/reduceQuantity").permitAll()
                .antMatchers("/addQuantity").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll().logoutSuccessUrl("/")
                .and()
                .formLogin()
                .loginPage("/adminLogin").usernameParameter("name").passwordParameter("password")
                .loginProcessingUrl("/login1")
                .permitAll()
                .and()
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
        http.csrf().disable();
        http.rememberMe();



    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
