package com.tungty.tungtyservice.DTO

import com.tungty.tungtyservice.DTO.PartyDTO

data class ResponseGetMyPartyDTO(
    var errMessage: String?,
    var myPartyList: List<PartyDTO>? = null
)
