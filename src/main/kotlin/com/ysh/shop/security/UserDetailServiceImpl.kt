package com.ysh.shop.security

import com.ysh.shop.domain.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(private val userRepository: UserRepository) : UserDetailsService{

    override fun loadUserByUsername(userName: String): UserDetails {

        val user = userRepository.findByName(userName)

        if (user == null) {
            TODO("user를 찾을 수 없을 때 바로 예외처리 하는 것이 적절한지 판단 필요")
            throw IllegalArgumentException("해당 유저를 찾을 수 없습니다")
        }

        else return UserDetailsImpl(user)
    }
}