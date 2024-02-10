package com.tungty.tungtyservice.controller

import com.tungty.tungtyservice.DTO.ReqRegisterDTO
import com.tungty.tungtyservice.service.implement.userServiceImplement.UserServiceImp
import com.tungty.tungtyservice.service.userService.userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userServiceImp: UserServiceImp
    @PostMapping("register")
    fun createUser(@RequestBody reqRegisterDTO: ReqRegisterDTO) : String{
        return userServiceImp.createUser(reqRegisterDTO)
    }
}