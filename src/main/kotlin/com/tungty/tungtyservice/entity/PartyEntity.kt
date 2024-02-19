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
    var partyCode: String,
    val partyOwner: String,
    var partyName: String,
    var partyDescription: String,
    var partyType: String,
    var partyCategory: String,
    var appointmentDate: String,
    var appointmentTime: String,
    val memberAmount: Int,
//        @ElementCollection
//    val memberList: List<UserDTO>,
    var memberList: List<String>,

    val createDateTime: String,
    var updateDateTime: String
)