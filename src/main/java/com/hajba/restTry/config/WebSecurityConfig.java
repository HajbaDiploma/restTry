package com.hajba.restTry.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll() // для главной страницы по url:/ доступен доступ всем пользователям системы
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource) // чтобы менеджер (AuthenticationManagerBuilder) мог ходить в бд и доставать из нее типы юзеров и юзеров
        .passwordEncoder(NoOpPasswordEncoder.getInstance()) // шифрует пароли чтобы они не хранились в бд в явном виде
        .usersByUsernameQuery("select username, password, active from usr where username=?") // система находит пользователя по имени. поля именно в таком порядке
                // select username, password, active from usr where username=?
        .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?"); // помогает спрингу плучить имена пользователей с их ролями
                //                   select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?
    }
}