package com.tungty.tungtyservice.DTO.party


import com.tungty.tungtyservice.DTO.party.PartyDTO

data class ResponseGetMyPartyDTO(
    var errMessage: String?,
    var myPartyList: List<PartyDTO>? = null
)
