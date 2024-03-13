package com.tungty.tungtyservice.DTO.notify

data class ReqAddNotifyDTO(
//    val id: String?,
//    val type: String,
////    val flagActive: Boolean,
//    val partyId: String,
//    val partyName: String,
////    val createDate: String,
//    val userId: String,
//    val appointmentTime: String,
//    val appointmentDate: String


//    val id: String,
    val partyName: String,
    val typeAction: String,
    val notifyDescription: String,
    val userId: String,
    val appointmentDate: String,
    val appointmentTime: String,
    val status: String,
    val partyId: String

)
