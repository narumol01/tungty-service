package com.tungty.tungtyservice.service.partyService

interface PartyCodeService {
    fun genPartyCode(partyId:String) : String
}