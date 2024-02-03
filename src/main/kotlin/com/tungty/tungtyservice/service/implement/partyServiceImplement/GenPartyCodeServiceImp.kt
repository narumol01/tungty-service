package com.tungty.tungtyservice.service.implement.partyServiceImplement

import com.tungty.tungtyservice.service.partyService.GenPartyCodeService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class GenPartyCodeServiceImp: GenPartyCodeService {
    override fun genPartyCode(partyId: String): String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        val random = Random.Default

        val randomString = (1..4)
            .map { charset[random.nextInt(charset.length)] }
            .joinToString("")

        println("Random String: $randomString")
        return randomString
    }
}