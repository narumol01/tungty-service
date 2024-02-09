package com.tungty.tungtyservice.entity

//import com.tungty.tungtyservice.dto.UserDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// Party Entity
@Document(collection = "PartyCollection")
data class PartyEntity(
    @Id
//    val _id: String,
    val partyId: String,
    val partyCode: String,
    val partyOwner: String,
    val partyName: String,
    val partyDescription: String,
    val partyType: String,
    val partyCategory: String,
    val appointmentDate: String,
    val appointmentTime: String,
    val memberAmount: Int,
//        @ElementCollection
//    val memberList: List<UserDTO>,
    val memberList: List<String>,

    val createDateTime: String,
    val updateDateTime: String
)