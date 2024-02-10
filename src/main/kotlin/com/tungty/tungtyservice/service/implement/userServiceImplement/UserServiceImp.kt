package com.tungty.tungtyservice.service.implement.userServiceImplement

import com.tungty.tungtyservice.DTO.ReqRegisterDTO
import com.tungty.tungtyservice.entity.UserEntity
import com.tungty.tungtyservice.repository.user.UserRepository
import com.tungty.tungtyservice.service.userService.userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.SecureRandom
import java.util.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

@Service
class UserServiceImp : userService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun createUser(reqRegisterDTO: ReqRegisterDTO): String {
        try {
            val id = UUID.randomUUID().toString()

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            val current = LocalDateTime.now().format(formatter)

            // สร้าง salt สำหรับเพิ่มความปลอดภัยในการเข้ารหัส
            val salt = ByteArray(16)
            val random = SecureRandom()
            random.nextBytes(salt)

            // กำหนดค่าการกำหนดรหัส PBKDF2
            val iterations = 10000
            val keyLength = 512
            val spec = PBEKeySpec(reqRegisterDTO.password.toCharArray(), salt, iterations, keyLength)
            val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")

            // เข้ารหัสรหัสผ่าน
            val hashedPassword = factory.generateSecret(spec).encoded

            val user = UserEntity(
                    userId = id,
                    name = reqRegisterDTO.name,
                    surname = reqRegisterDTO.surname,
                    username = reqRegisterDTO.username,
                    password = Base64.getEncoder().encodeToString(hashedPassword),
                    studentId = reqRegisterDTO.studentId,
                    faculty = reqRegisterDTO.faculty,
                    field = reqRegisterDTO.field,
                    year = reqRegisterDTO.year,
                    profileImg = reqRegisterDTO.profileImg,
                    createDateTime = current.toString(),
                    updateDateTime = current.toString()
            )
            val result = userRepository.save(user)

            return result.block()?.toString() ?: "fail"

        } catch (error : Exception) {
            return error.toString()
        }
    }

}