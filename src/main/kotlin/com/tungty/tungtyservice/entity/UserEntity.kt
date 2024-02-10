package com.tungty.tungtyservice.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// User Entity

@Document(collection = "UserCollection")
data class UserEntity(
        @Id
        val userId: String,
        val name: String,
        val surname: String,
        val username: String,
        val password: String,
        val studentId: String,
        val faculty: String,
        val field: String,
        val year: Int,
        val profileImg: String,
        val createDateTime: String,
        val updateDateTime: String
)