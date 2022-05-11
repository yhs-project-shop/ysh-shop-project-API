package com.ysh.shop.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtProvider(private val userDetailsService: UserDetailServiceImpl) {
    private val secretKey = "todochange"
    private val validTime = 30 * 60 * 1000L

    fun createToken(userName: String) : String {
        val claims:Claims = Jwts.claims().setSubject(userName)
        val now = Date()
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + validTime))
            .signWith(SignatureAlgorithm.HS256,secretKey)
            .compact()
    }
    fun getUserNameByToken(token:String):String{
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).body.subject
    }

    fun getAuthentication(token:String): Authentication {
        val userDetails : UserDetails = userDetailsService.loadUserByUsername(getUserNameByToken(token))
        return UsernamePasswordAuthenticationToken(userDetails,"",userDetails.authorities)
    }

    fun resolveToken(request : HttpServletRequest):String{
        return request.getHeader("X-AUTH-TOKEN");
    }

    fun validateToken(token: String):Boolean{
        val claims: Jws<Claims> = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
        return !claims.body.expiration.before(Date())
    }
}