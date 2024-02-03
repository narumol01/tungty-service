package com.tungty.tungtyservice.service.implement.partyServiceImplement

import com.tungty.tungtyservice.entity.MessageEntity
import com.tungty.tungtyservice.repository.MessageRepository
import com.tungty.tungtyservice.repository.party.PartyRepository
import com.tungty.tungtyservice.service.partyService.PartyCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import kotlin.random.Random

@Service
class PartyCodeServiceImp: PartyCodeService {
    @Autowired
    lateinit var partyRepository: PartyRepository
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

    override fun getPartyCode(partyId: String): String {
        TODO("Query from mongo")



    }
//    override fun findAllParty(): Flux<MessageEntity> {
//        return partyRepository.findAll()
//    }
}