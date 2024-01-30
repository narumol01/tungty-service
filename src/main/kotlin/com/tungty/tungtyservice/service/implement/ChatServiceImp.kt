package com.tungty.tungtyservice.service.implement

import com.tungty.tungtyservice.entity.MessageEntity
import com.tungty.tungtyservice.repository.MessageRepository
import com.tungty.tungtyservice.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ChatServiceImp: ChatService {
    @Autowired
    lateinit var messageRepository: MessageRepository
    override fun findAllMessage(): Flux<MessageEntity> {
        return messageRepository.findAll()
    }
}