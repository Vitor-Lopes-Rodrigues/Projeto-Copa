package com.example.projetocopa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //Classe que contem configuração
@EnableWebSecurity //Classe de configuração com configuraçã web
public class SpringSecurity extends WebSecurityConfiguration {

    //Proteção de senha
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //protected void configure(HttpSecurity http) throws Exception {
      //  http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
    //}

    //Metodo sem banco :)
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception{
      //  auth.inMemoryAuthentication().withUser("user")
        //        .password(passwordEncoder().encode("password")).authorities("USER");
    //}
}
