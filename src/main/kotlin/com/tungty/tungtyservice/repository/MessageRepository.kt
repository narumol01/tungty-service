package com.tungty.tungtyservice.repository

import com.tungty.tungtyservice.entity.MessageEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository


@Repository
interface MessageRepository: ReactiveMongoRepository<MessageEntity, String> {
    // ...
}