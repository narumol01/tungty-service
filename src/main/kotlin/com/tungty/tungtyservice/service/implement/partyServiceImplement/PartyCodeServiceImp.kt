package com.tungty.tungtyservice.service.implement.partyServiceImplement

import com.tungty.tungtyservice.service.partyService.PartyCodeService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class PartyCodeServiceImp: PartyCodeService {
    override fun genPartyCode(partyId: String): String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        val random = Random.Default

        val randomString = (1..4)
            .map { charset[random.nextInt(charset.length)] }
            .joinToString("")

        println("Random String: $randomString")
        //save code to mongo
        return randomString
    }
}