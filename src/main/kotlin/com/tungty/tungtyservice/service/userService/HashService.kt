package com.tungty.tungtyservice.service.userService

import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service

@Service
class HashService {
    fun hashBCrypt(input: String): String{
        return BCrypt.hashpw(input, BCrypt.gensalt(10))
    }

    fun checkBcrypt(input: String, hash: String): Boolean {
        return BCrypt.checkpw(input, hash)
    }
}