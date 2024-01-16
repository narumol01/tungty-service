package com.tungty.tungtyservice.service.implement

import com.tungty.tungtyservice.service.TestService
import org.springframework.stereotype.Service

@Service
class TestServiceImp : TestService {

    override fun testSay(): String {
        return "Hello World!!"
    }

    override fun testSaySometing(word: String): String {
        return "Hello, "+word
    }
}