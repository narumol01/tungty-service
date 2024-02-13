package com.tungty.tungtyservice.service.implement.partyServiceImplement


//import com.tungty.tungtyservice.dto.ReqCreatePartyDTO
import com.tungty.tungtyservice.DTO.party.ReqCreatePartyDTO
import com.tungty.tungtyservice.DTO.party.ReqEditPartyDTO
import com.tungty.tungtyservice.DTO.party.ReqJoinPartyDTO
import com.tungty.tungtyservice.DTO.party.ReqJoinPrivatePartyDTO
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
    override fun getMyParties(userId:String): Flux<PartyEntity> {
        return partyRepository.findAll().filter { party -> userId in party.memberList }
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
                partyCategory = reqCreatePartyDTO.partyCategory,
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

//    override fun editParty(reqEditPartyDTO: ReqEditPartyDTO): String {
//        try {
//            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
//            val current = LocalDateTime.now().format(formatter)
//            // Fetch the existing party entity from the database
//            val partyId = reqEditPartyDTO.partyId
//
//            val existingParty : Mono<PartyEntity> = partyRepository.findById(partyId)
//            // Update only the attributes that need to be changed
//            existingParty.partyName = reqEditPartyDTO.partyName
//            existingParty.partyDescription = reqEditPartyDTO.partyDescription
//            existingParty.partyType = reqEditPartyDTO.partyType
//            existingParty.partyCatagory = reqEditPartyDTO.partyCatagory
//            existingParty.partyCode = if (reqEditPartyDTO.partyType == "Private") genPartyCode(partyId) else ""
//
//            existingParty.appointmentDate = reqEditPartyDTO.appointmentDate
//            existingParty.appointmentTime = reqEditPartyDTO.appointmentTime
////            existingParty.memberAmount = reqEditPartyDTO.memberAmount
////            existingParty.memberList = reqEditPartyDTO.memberList
//            existingParty.updateDateTime = current.toString()
//            // Save the updated party entity back to the database
//            val result = partyRepository.save(existingParty).toString()
//
//
//            return result.block()?.toString() ?: "fail"
//        } catch (error: Exception) {
//            return error.toString()
//        }
//    }
override fun editParty(reqEditPartyDTO: ReqEditPartyDTO): String {
    try {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val current = LocalDateTime.now().format(formatter)
        // Fetch the existing party entity from the database
        val partyId = reqEditPartyDTO.partyId

        var existingPartyMono: Mono<PartyEntity> = partyRepository.findById(partyId)

        return existingPartyMono.flatMap { existingParty ->
            // Update only the attributes that need to be changed
            existingParty.partyName = reqEditPartyDTO.partyName
            existingParty.partyDescription = reqEditPartyDTO.partyDescription
            existingParty.partyType = reqEditPartyDTO.partyType
            existingParty.partyCategory = reqEditPartyDTO.partyCategory
            existingParty.partyCode = if (reqEditPartyDTO.partyType == "Private") genPartyCode(partyId) else ""

            existingParty.appointmentDate = reqEditPartyDTO.appointmentDate
            existingParty.appointmentTime = reqEditPartyDTO.appointmentTime
            // existingParty.memberAmount = reqEditPartyDTO.memberAmount
            // existingParty.memberList = reqEditPartyDTO.memberList
            existingParty.updateDateTime = current.toString()

            // Save the updated party entity back to the database
            partyRepository.save(existingParty)
        }.block()?.toString() ?: "fail"
    } catch (error: Exception) {
        return error.toString()
    }
}

    override fun joinParty(reqJoinPartyDTO: ReqJoinPartyDTO): String {
        TODO("Not yet implemented")

//        try {
//            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
//            val current = LocalDateTime.now().format(formatter)
//            // Fetch the existing party entity from the database
//            val user = ReqJoinPartyDTO.user
//
//            val partyId = ReqJoinPartyDTO.partyId
//
//            var existingPartyMono: Mono<PartyEntity> = partyRepository.findById(partyId)
//
//            return existingPartyMono.flatMap { existingParty ->
//                // Update only the attributes that need to be changed
//                existingParty.memberList = existingParty.memberList.plus(reqJoinPartyDTO.userId)
//                existingParty.updateDateTime = current.toString()
//
//                // Save the updated party entity back to the database
//                partyRepository.save(existingParty)
//            }.block()?.toString() ?: "fail"
//        } catch (error: Exception) {
//            return error.toString()
//        }

    }

    override fun joinPrivateParty(reqJoinPrivatePartyDTO: ReqJoinPrivatePartyDTO): String {
        TODO("Not yet implemented")
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