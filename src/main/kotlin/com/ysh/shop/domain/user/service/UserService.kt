package com.ysh.shop.domain.user.service

import com.ysh.shop.domain.user.dto.SigninRequestDto
import com.ysh.shop.domain.user.dto.SignupRequestDto
import com.ysh.shop.domain.user.dto.UserResponseDto
import com.ysh.shop.domain.user.model.User
import com.ysh.shop.domain.user.repository.UserRepository
import com.ysh.shop.security.JwtProvider
import lombok.RequiredArgsConstructor
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider
) {

    fun signup(signupRequestDto: SignupRequestDto): User {
        signupRequestDto.setPassword(passwordEncoder);

        return userRepository.save(User(signupRequestDto))
    }

    fun signin(signinRequestDto: SigninRequestDto): UserResponseDto {

        val user = loadUserByUserId(signinRequestDto.userId)
        val isPasswordMatched = passwordEncoder.matches(signinRequestDto.password, user?.password)

        if (isPasswordMatched) {
            val token: String = jwtProvider.createToken(user.name)
            return UserResponseDto(user, token)
        } else throw IllegalAccessException("올바르지 않은 비밀번호 입니다.")
    }

    fun validateProps(target: String, value: String): Boolean {
        if (target.equals("id")) {
            return idCheck(value)
        } else if (target.equals("email")) {
            return emailCheck(value)
        }else throw IllegalAccessException("올바른 target이 아닙니다.")
    }

    fun idCheck(id: String): Boolean {
        return userRepository.countAllByUserId(id) == 0L
    }

    fun emailCheck(email: String): Boolean {
        return userRepository.countAllByEmail(email) == 0L
    }

    fun loadUserByUserId(userId: String): User {
        val user = userRepository.findByUserId(userId)
        if (user != null) {
            return user
        }
        throw IllegalAccessException("해당 유저를 찾을 수 없습니다.")
    }

}