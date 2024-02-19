package com.tungty.tungtyservice.DTO

import com.tungty.tungtyservice.DTO.PartyDTO

data class ResponseJoinPrivatePartyDTO(
    var errMessage: String? =null,
    var joinedPartyId: PartyDTO? =null,
)
