package com.ysh.shop.domain.user.dto

import com.ysh.shop.domain.user.model.User


data class UserResponseDto(
    val user: User?=null,
    val token: String? =null
)
