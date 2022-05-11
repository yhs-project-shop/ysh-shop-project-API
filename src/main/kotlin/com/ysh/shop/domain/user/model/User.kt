package com.ysh.shop.domain.user.model

import com.ysh.shop.domain.authentication.Role
import com.ysh.shop.domain.user.dto.SignupRequestDto
import javax.persistence.*

@Entity
class User (userRequestDto: SignupRequestDto) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = 0
    val userId : String = userRequestDto.userId
    val password : String = userRequestDto.password
    val phoneNumber : String = userRequestDto.phoneNumber
    val address : String = userRequestDto.address
    val role : Role = Role.CUSTOMER
    val name : String = userRequestDto.name
    val email : String = userRequestDto.email
}