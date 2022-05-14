package com.ysh.shop.config

import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
class WebSecurityConfig(disableDefaults: Boolean=true) : WebSecurityConfigurerAdapter(disableDefaults) {
    @Bean
    fun passwordEncoder() : PasswordEncoder{
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    override fun configure(web: WebSecurity){
        web.ignoring()
            .antMatchers("**")
    }

//    @Override
    override fun configure(http: HttpSecurity) {
        http.cors().and()
            .authorizeHttpRequests()
            // 어떤 요청이든 인증
            .antMatchers("/sss")
            .authenticated()

            .and()
            .httpBasic().disable()
            .csrf().disable()

    }


}