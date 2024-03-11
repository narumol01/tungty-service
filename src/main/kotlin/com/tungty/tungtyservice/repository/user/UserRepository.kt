package com.tungty.tungtyservice.repository.user

import com.tungty.tungtyservice.entity.UserEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveMongoRepository <UserEntity, String> {
    fun findByUsername(username: String): Mono<UserEntity>
}