package com.tungty.tungtyservice.service.userService

import com.tungty.tungtyservice.DTO.ReqRegisterDTO

interface userService {
    fun createUser(reqRegisterDTO: ReqRegisterDTO) : String
}