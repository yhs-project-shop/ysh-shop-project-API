package com.ysh.shop.domain.user.repository

import com.ysh.shop.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long>{
    fun findByName(name:String):User?=null

    fun findByUserId(userId:String):User?=null

    fun countAllByUserId(userId:String):Long

    fun countAllByEmail(email:String):Long

    fun countAllByPhoneNumber(phoneNumber:String):Long

}
