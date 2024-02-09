package com.tungty.tungtyservice.service.partyService

import com.tungty.tungtyservice.entity.PartyEntity
import reactor.core.publisher.Flux

interface PartyService {
    fun genPartyCode(partyId:String) : String
    fun getPartyCode(partyId:String) : String
//    fun createParty() : String


    fun getAllParties() : Flux<PartyEntity>



}