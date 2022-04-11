package com.erick.lue.casestudy.worstenemies.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .mvcMatchers("/","/login","/signup").permitAll()
                .mvcMatchers("/deleteUser/**","/showFormForUserUpdate/**",
                                        "/saveUserAdmin/**","/adminCards","/showNewQuestionForm/**",
                                        "/saveQuestion/**","/deleteQuestion/{id}/**","/admin_questions","/admin_update_question/**").hasAnyRole("ADMIN")
//                .mvcMatchers("/showFormForUserUpdate/**").hasAnyRole("ADMIN")
//                .mvcMatchers("/saveUserAdmin/**").hasAnyRole("ADMIN")
                .mvcMatchers("/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                   .loginProcessingUrl("/login")
                .defaultSuccessUrl("/profile", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
        // @formatter:on
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder.encode("user")).roles("USER").and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN");



    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/styles/**");
    }

}
