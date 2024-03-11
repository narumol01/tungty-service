package com.tungty.tungtyservice.config

import com.tungty.tungtyservice.entity.UserEntity
import org.springframework.security.core.Authentication

fun Authentication.toUser(): UserEntity{
    return principal as UserEntity
}