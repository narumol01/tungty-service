package com.tungty.tungtyservice.DTO.party


import com.tungty.tungtyservice.DTO.party.PartyDTO

data class ResponseJoinPrivatePartyDTO(
    var errMessage: String? =null,
    var joinedPartyId: PartyDTO? =null,
)
