package com.tungty.tungtyservice.DTO

import com.tungty.tungtyservice.DTO.PartyDTO

data class ResponseGetNotifyDTO(
    var errMessage: String?,
    var partyDueAppointmentList: List<PartyDTO>
)
