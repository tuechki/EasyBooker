package com.elsys.easybooker.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.Filter;

import java.util.Collections;

import static com.elsys.easybooker.security.SecurityConstants.SIGN_UP_URL;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/login/").permitAll().and()
//        http.headers().frameOptions().disable().and().cors().and().csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
//                .antMatchers(HttpMethod.POST, "/users").permitAll()
//                .antMatchers(HttpMethod.GET, "/businesses").permitAll()
//                .antMatchers(HttpMethod.PUT, "/businesses/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager()),JWTAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthorizationFilter(authenticationManager()),JWTAuthorizationFilter.class)
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/**").permitAll();
        http.  authorizeRequests().antMatchers("/**").permitAll().and().addFilterBefore(new JWTAuthorizationFilter(authenticationManager()),JWTAuthorizationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.applyPermitDefaultValues();
        corsConfig.addAllowedMethod(HttpMethod.PUT);
        corsConfig.addExposedHeader("Authorization");
        corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

}