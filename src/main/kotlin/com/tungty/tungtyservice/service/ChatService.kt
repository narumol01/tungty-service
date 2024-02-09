package com.tungty.tungtyservice.service

import com.tungty.tungtyservice.entity.MessageEntity
import reactor.core.publisher.Flux

interface ChatService {
    fun findAllMessage(): Flux<MessageEntity>
}