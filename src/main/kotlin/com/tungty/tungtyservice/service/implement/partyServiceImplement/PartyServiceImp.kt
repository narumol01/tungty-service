package com.tungty.tungtyservice.service.implement.partyServiceImplement


//import com.tungty.tungtyservice.dto.ReqCreatePartyDTO
import com.tungty.tungtyservice.DTO.ReqCreatePartyDTO
import com.tungty.tungtyservice.entity.PartyEntity
import com.tungty.tungtyservice.repository.party.PartyRepository
import com.tungty.tungtyservice.service.partyService.PartyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random

@Service
class PartyServiceImp: PartyService {
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
    override fun getAllParties(): Flux<PartyEntity> {
        return partyRepository.findAll()
    }
    override fun getPartyById(partyId: String): Mono<PartyEntity> {
//        try {
//            partyRepository.findById(partyId)
//        }
        return partyRepository.findById(partyId)
    }

//    override fun findAllParty(): Flux<MessageEntity> {
//        return partyRepository.findAll()
//    }


    override fun createParty(reqCreatePartyDTO: ReqCreatePartyDTO): String {
        try {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            val current = LocalDateTime.now().format(formatter)
            val id = UUID.randomUUID().toString()
            val partyOwner = "TestName"

            val party = PartyEntity(
                partyId = id,
                partyOwner = partyOwner,
                partyName = reqCreatePartyDTO.partyName,
                partyDescription = reqCreatePartyDTO.partyDescription,
                partyType = reqCreatePartyDTO.partyType,
                partyCode = if (reqCreatePartyDTO.partyType == "Private") genPartyCode(id) else "",
                partyCategory = "test",
                appointmentDate = current.toString(),
                appointmentTime = reqCreatePartyDTO.appointmentTime?.toString() ?: "",
                memberAmount = reqCreatePartyDTO.memberAmount,
                memberList = reqCreatePartyDTO.memberList,
                createDateTime = current.toString(),
                updateDateTime = current.toString()
            )

            val result = partyRepository.save(party)

            return result.block()?.toString() ?: "fail"
        } catch (error: Exception) {
            return error.toString()
        }
    }



//
//    fun getAllParties(): List<Party> {
//        return partyRepository.findAll()
//    }
//
//    fun updateParty(id: String, updatedParty: Party): Party? {
//        if (partyRepository.existsById(id)) {
//            updatedParty.id = id
//            return partyRepository.save(updatedParty)
//        }
//        return null
//    }
//
//    fun deleteParty(id: String): Boolean {
//        return if (partyRepository.existsById(id)) {
//            partyRepository.deleteById(id)
//            true
//        } else {
//            false
//        }
//    }
}