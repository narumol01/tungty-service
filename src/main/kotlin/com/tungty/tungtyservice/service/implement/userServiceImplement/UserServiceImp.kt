package com.tungty.tungtyservice.service.implement.userServiceImplement

import com.tungty.tungtyservice.DTO.ReqEditProfileDTO
import com.tungty.tungtyservice.DTO.ReqRegisterDTO
import com.tungty.tungtyservice.DTO.ReqLoginDTO
import com.tungty.tungtyservice.entity.UserEntity
import com.tungty.tungtyservice.repository.user.UserRepository
import com.tungty.tungtyservice.service.userService.userService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
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

    override fun getUserById(userId: String): Mono<UserEntity?> {
        return userRepository.findById(userId)
    }

    override fun getAllUsers(): Flux<UserEntity> {
        return userRepository.findAll()
    }

    override fun editUsers(reqEditProfileDTO: ReqEditProfileDTO): String {
        try {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            val current = LocalDateTime.now().format(formatter)
            // Fetch the existing party entity from the database
            val userId = reqEditProfileDTO.userId

            var existingUserMono: Mono<UserEntity> = userRepository.findById(userId)


            // สร้าง salt สำหรับเพิ่มความปลอดภัยในการเข้ารหัส
            val salt = ByteArray(16)
            val random = SecureRandom()
            random.nextBytes(salt)

            // กำหนดค่าการกำหนดรหัส PBKDF2
            val iterations = 10000
            val keyLength = 512
            val spec = PBEKeySpec(reqEditProfileDTO.password.toCharArray(), salt, iterations, keyLength)
            val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")

            // เข้ารหัสรหัสผ่าน
            val hashedPassword = factory.generateSecret(spec).encoded

            return existingUserMono.flatMap { existingUser ->
                // Update only the attributes that need to be changed
                existingUser.name = reqEditProfileDTO.name
                existingUser.surname = reqEditProfileDTO.surname
                existingUser.password = Base64.getEncoder().encodeToString(hashedPassword)
                existingUser.studentId = reqEditProfileDTO.studentId
                existingUser.faculty = reqEditProfileDTO.faculty
                existingUser.field = reqEditProfileDTO.field
                existingUser.year = reqEditProfileDTO.year
                existingUser.profileImg = reqEditProfileDTO.profileImg
                existingUser.updateDateTime = current.toString()

                // Save the updated user entity back to the database
                userRepository.save(existingUser)
            }.block()?.toString() ?: "fail"
        } catch (error: Exception) {
            return error.toString()
        }
    }
}