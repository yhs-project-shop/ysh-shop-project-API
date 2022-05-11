package com.ysh.shop.domain.user.dto

import org.springframework.security.crypto.password.PasswordEncoder

data class SignupRequestDto (
    val userId : String = "",
    var password : String = "",
    val phoneNumber : String = "",
    val name : String = "",
    val email : String = "",
    val address : String = ""
        ){
    fun setPassword(passwordEncoder: PasswordEncoder){
        password = passwordEncoder.encode(password)
    }
}
