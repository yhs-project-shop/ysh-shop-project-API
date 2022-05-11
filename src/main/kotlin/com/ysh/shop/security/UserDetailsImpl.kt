package com.ysh.shop.security

import com.ysh.shop.domain.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class UserDetailsImpl(private val user : User) : UserDetails {

    fun getUser():User{
        return user;
    }

    fun getUserPk():Long?{
        return user.id;
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.name;
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return Collections.emptyList();
    }

    override fun isAccountNonExpired(): Boolean {
        return true;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isEnabled(): Boolean {
        return true;
    }
}