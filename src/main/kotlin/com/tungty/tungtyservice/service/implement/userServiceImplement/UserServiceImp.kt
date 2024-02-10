package com.tungty.tungtyservice.service.implement.userServiceImplement

import com.tungty.tungtyservice.DTO.ReqRegisterDTO
import com.tungty.tungtyservice.entity.UserEntity
import com.tungty.tungtyservice.repository.user.UserRepository
import com.tungty.tungtyservice.service.userService.userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImp : userService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun createUser(reqRegisterDTO: ReqRegisterDTO): String {
        try {
            val id = UUID.randomUUID().toString()

            val user = UserEntity(
                    userId = id,
                    name = reqRegisterDTO.name,
                    surname = reqRegisterDTO.surname,
                    username = reqRegisterDTO.username,
                    password = reqRegisterDTO.password,
                    studentId = reqRegisterDTO.studentId,
                    faculty = reqRegisterDTO.faculty,
                    field = reqRegisterDTO.field,
                    year = reqRegisterDTO.year,
                    profileImg = reqRegisterDTO.profileImg,
                    createDateTime = reqRegisterDTO.createDateTime,
                    updateDateTime = reqRegisterDTO.updateDateTime
            )
            val result = userRepository.save(user)

            return result.block()?.toString() ?: "fail"

        } catch (error : Exception) {
            return error.toString()
        }
    }

}