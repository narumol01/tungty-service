package com.tungty.tungtyservice.service.userService

import com.tungty.tungtyservice.DTO.ReqEditProfileDTO
import com.tungty.tungtyservice.DTO.ReqRegisterDTO
import com.tungty.tungtyservice.entity.UserEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface userService {
    fun createUser(reqRegisterDTO: ReqRegisterDTO) : String

    fun findUserById(userId:String): Mono<UserEntity?>

    fun findUserByUsername(username: String): Mono<UserEntity>

    fun getAllUsers() : Flux<UserEntity>

    fun editUsers(reqEditProfileDTO: ReqEditProfileDTO): String
}