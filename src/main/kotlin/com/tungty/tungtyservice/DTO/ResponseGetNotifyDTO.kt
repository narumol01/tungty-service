package com.tungty.tungtyservice.DTO

data class ResponseGetNotifyDTO(
    var errMessage: String?,
    var partyDueAppointmentList: List<PartyDTO>
)
