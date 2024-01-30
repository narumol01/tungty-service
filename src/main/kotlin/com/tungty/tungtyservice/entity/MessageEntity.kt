package com.tungty.tungtyservice.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.sql.Timestamp

// Message Entity
@Document(collection = "Message")
data class MessageEntity(
        @Id
        val messageId: String,
        val messageContent: String,
        val senderUserId: String,
        val timestamp: Timestamp,
        val createDateTime: Timestamp
)
