package com.tungty.tungtyservice.DTO.party



data class ReqEditPartyDTO(
    var partyId: String,
    var partyName: String,
    var partyDescription: String,
    var partyType: String,
    var partyCategory: String,
    var appointmentDate: String,
    var appointmentTime: String,
)
