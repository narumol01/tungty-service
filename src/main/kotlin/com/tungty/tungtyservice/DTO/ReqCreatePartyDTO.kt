package com.tungty.tungtyservice.DTO

import java.sql.Time
import java.sql.Timestamp

data class ReqCreatePartyDTO(
    var partyName: String,
    var partyDescription: String,
    var partyType: String,
    var partyCategory: String,
    var appointmentDate: String,
    var appointmentTime: String,
    var memberAmount: Int,
//    var memberList: List<UserDTO>
    //pls change it back
    var memberList: List<String>

)
