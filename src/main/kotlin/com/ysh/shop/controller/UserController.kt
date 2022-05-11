package com.ysh.shop.controller

import com.ysh.shop.domain.user.dto.SigninRequestDto
import com.ysh.shop.domain.user.dto.SignupRequestDto
import com.ysh.shop.domain.user.dto.UserResponseDto
import com.ysh.shop.domain.user.model.User
import com.ysh.shop.domain.user.service.UserService
import com.ysh.shop.security.JwtProvider
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequiredArgsConstructor
@RestController
class UserController(
    private val userService: UserService,

    ) {
    @PostMapping("/users/signup/check")
    fun duplicateCheck(target: String, value: String): Map<String, Boolean> {
        val isAvailable = userService.validateProps(target, value)
        return mapOf("result" to isAvailable)
    }

    @PostMapping("/users/signup")
    fun signup(signupRequestDto: SignupRequestDto): UserResponseDto {

        val user: User = userService.signup(signupRequestDto)

        return UserResponseDto(user)
    }

    @PostMapping("/users/signin")
    fun signin(signinRequestDto: SigninRequestDto): UserResponseDto {
        return userService.signin(signinRequestDto)
    }


}