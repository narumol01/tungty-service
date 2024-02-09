package com.tungty.tungtyservice.DTO

data class ResponseGetMyChatDTO(
    var errMessage: String?,
    var chatIdList: List<String>
)
