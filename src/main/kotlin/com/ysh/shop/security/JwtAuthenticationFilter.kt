package com.ysh.shop.security

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest


class JwtAuthenticationFilter(private val jwtProvider: JwtProvider) : GenericFilterBean() {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token:String = jwtProvider.resolveToken(request as HttpServletRequest)
        if (jwtProvider.validateToken(token)){
            val authentication : Authentication = jwtProvider.getAuthentication(token)
            // SecurityContext 에 Authentication 객체를 저장
            SecurityContextHolder.getContext().authentication = authentication
        }
        // request로 정보를 받아와서 검증을 한 후 결과를 reponse로 내보냄
        chain?.doFilter(request, response);
    }
}


