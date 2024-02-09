package com.tungty.tungtyservice.service.partyService

import com.tungty.tungtyservice.DTO.ReqCreatePartyDTO
import com.tungty.tungtyservice.entity.PartyEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PartyService {
    fun genPartyCode(partyId:String) : String
    fun getPartyCode(partyId:String) : String
    fun createParty(reqCreatePartyDTO: ReqCreatePartyDTO) : String


    fun getAllParties() : Flux<PartyEntity>
    fun getPartyById(partyId:String): Mono<PartyEntity>



}