package com.tungty.tungtyservice.DTO

import java.util.StringJoiner

data class ResponseGetMyProfileDTO(
    var userId: String,
    var username: String,
    var name: StringJoiner,
    var faculty: String,
    var field: String,
    var year: String
)
