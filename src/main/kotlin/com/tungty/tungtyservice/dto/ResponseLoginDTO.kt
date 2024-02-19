package com.tungty.tungtyservice.DTO

data class ResponseLoginDTO (
    var errorMessage: String? = null,
    var token: String? = null,
    var userId: String? = null,
)

