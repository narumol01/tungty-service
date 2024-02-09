package com.tungty.tungtyservice.service.implement.partyServiceImplement


//import com.tungty.tungtyservice.dto.ReqCreatePartyDTO
import com.tungty.tungtyservice.entity.PartyEntity
import com.tungty.tungtyservice.repository.party.PartyRepository
import com.tungty.tungtyservice.service.partyService.PartyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
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

//    override fun findAllParty(): Flux<MessageEntity> {
//        return partyRepository.findAll()
//    }


//    override fun createParty(reqCreatePartyDTO: ReqCreatePartyDTO): Party {
//        val party = Party(
//            partyId = UUID.randomUUID().toString(),
////            partyOwner = reqCreatePartyDTO.partyOwner,
//            partyOwner = "TestName",
//            partyName = reqCreatePartyDTO.partyName,
//            partyDescription = reqCreatePartyDTO.partyDescription,
//            partyType = reqCreatePartyDTO.partyType,
//            appointmentDate = reqCreatePartyDTO.appointmentDate,
//            appointmentTime = reqCreatePartyDTO.appointmantTime?.toString() ?: "",
//            memberAmount = reqCreatePartyDTO.memberAmount,
//            memberList = reqCreatePartyDTO.memberList.map { it.userId }, // Assuming UserDTO has a userId property
//            createDateTime = Date(),
//            updateDateTime = Date()
//        )
//
//        return partyRepository.save(party)
//    }

//    fun getPartyById(id: String): Party? {
//        return partyRepository.findById(id).orElse(null)
//    }
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