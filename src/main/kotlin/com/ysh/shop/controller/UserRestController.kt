package com.ysh.shop.controller

import com.ysh.shop.domain.user.dto.SigninRequestDto
import com.ysh.shop.domain.user.dto.SignupCheckRequestDto
import com.ysh.shop.domain.user.dto.SignupRequestDto
import com.ysh.shop.domain.user.dto.UserResponseDto
import com.ysh.shop.domain.user.model.User
import com.ysh.shop.domain.user.service.UserService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RequiredArgsConstructor
@RestController
class UserRestController(
    private val userService: UserService,

    ) {
    @PostMapping("/users/signup/check")
    fun duplicateCheck(@RequestBody signupRequestDto: SignupCheckRequestDto) :Map<String, Boolean> {
        val isAvailable = userService.validateProps(signupRequestDto.target,signupRequestDto.value)
        return mapOf("result" to isAvailable)
    }

    @PostMapping("/users/signup")
    fun signup(@RequestBody signupRequestDto: SignupRequestDto): UserResponseDto {

        val user: User = userService.signup(signupRequestDto)

        return UserResponseDto(user)
    }

    @PostMapping("/users/signin")
    fun signin(@RequestBody signinRequestDto: SigninRequestDto): UserResponseDto {
        return userService.signin(signinRequestDto)
    }


}