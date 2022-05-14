package com.ysh.shop.config

import com.ysh.shop.security.JwtAuthenticationFilter
import com.ysh.shop.security.JwtProvider
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.*
import javax.servlet.Filter

@Configuration
class WebConfig(private val jwtProvider: JwtProvider) : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")

            .allowedOrigins("*")
            .allowedMethods("*")

    }
    @Bean
    fun jwtAuthFilter():FilterRegistrationBean<Filter>{
        val filterRegistrationBean :FilterRegistrationBean<Filter> = FilterRegistrationBean()
        filterRegistrationBean.filter = JwtAuthenticationFilter(jwtProvider)
        filterRegistrationBean.addUrlPatterns("/auth/*")

        return filterRegistrationBean
    }

}