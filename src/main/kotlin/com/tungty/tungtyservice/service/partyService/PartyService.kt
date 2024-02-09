package com.tungty.tungtyservice.service.partyService

import com.tungty.tungtyservice.dto.ReqCreatePartyDTO
import com.tungty.tungtyservice.entity.PartyEntity
import reactor.core.publisher.Flux

interface PartyService {
    fun genPartyCode(partyId:String) : String
    fun getPartyCode(partyId:String) : String
    fun createParty(reqCreatePartyDTO: ReqCreatePartyDTO) : String


    fun getAllParties() : Flux<PartyEntity>
    fun getPartyById(partyId:String): PartyEntity



}