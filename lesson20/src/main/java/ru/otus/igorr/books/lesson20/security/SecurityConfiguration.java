package ru.otus.igorr.books.lesson20.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Slf4j
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    CustomUserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                //.antMatchers("/book/**").hasRole("ADMIN")
                .antMatchers("/genre/list").hasAnyRole("ADMIN", "EDIT", "VIEW")
                .antMatchers("/genre/add").hasRole("EDIT")
                .antMatchers("/author/list").hasRole("VIEW")
                .antMatchers("/author/add").hasRole("EDIT")
                .antMatchers("/book/list").hasRole("VIEW")
                .antMatchers("/book/authors").hasRole("VIEW")
                .antMatchers("/book/add").hasRole("ADMIN")
                .antMatchers("/book/edit").hasRole("ADMIN")
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler())
        ;

    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        /**/
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("q123").roles("ADMIN")
//                .and()
//                .withUser("view").password("q123").roles("VIEW")
//                .and()
//                .withUser("edit").password("q123").roles("EDIT");


    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                LOG.debug(charSequence.toString());
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                boolean result = charSequence.toString().equals(s);
                LOG.debug("***: " + charSequence.toString() + " " + s + " " + result);
                return result;
            }
        };
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }


}
