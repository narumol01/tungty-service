package com.tungty.tungtyservice.repository.user

import com.tungty.tungtyservice.entity.UserEntity
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : ReactiveMongoRepository <UserEntity, String> {
}