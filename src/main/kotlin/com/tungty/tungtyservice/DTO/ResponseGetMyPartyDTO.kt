package com.tungty.tungtyservice.DTO

data class ResponseGetMyPartyDTO(
    var errMessage: String?,
    var myPartyList: List<PartyDTO>? = null
)
