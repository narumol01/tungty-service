package com.tungty.tungtyservice.service.partyService

import com.tungty.tungtyservice.DTO.party.ReqCreatePartyDTO
import com.tungty.tungtyservice.DTO.party.ReqEditPartyDTO
import com.tungty.tungtyservice.DTO.party.ReqJoinPartyDTO
import com.tungty.tungtyservice.DTO.party.ReqJoinPrivatePartyDTO
import com.tungty.tungtyservice.entity.PartyEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PartyService {
    fun genPartyCode(partyId:String) : String
    fun getPartyCode(partyId:String) : String
    fun createParty(reqCreatePartyDTO: ReqCreatePartyDTO) : String

    fun editParty(reqEditPartyDTO: ReqEditPartyDTO): String

    fun joinParty(reqJoinPartyDTO: ReqJoinPartyDTO):String
    fun joinPrivateParty(reqJoinPrivatePartyDTO: ReqJoinPrivatePartyDTO):String

    fun getMyParties(userId:String): Flux<PartyEntity>
    fun getAllParties() : Flux<PartyEntity>
    fun getPartyById(partyId:String): Mono<PartyEntity>



}