package com.tungty.tungtyservice.controller

import com.tungty.tungtyservice.DTO.notify.ReqAddNotifyDTO
import com.tungty.tungtyservice.entity.NotifyEntity
import com.tungty.tungtyservice.job.NotifyJob
import com.tungty.tungtyservice.service.NotifyService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.sql.DriverManager

@RestController
@RequestMapping("/notify")
class NotifyController {

    @Autowired
    lateinit var notifyService: NotifyService

//    @Autowired
//    lateinit var notifyJob: NotifyJob

    @GetMapping("/getAll/{userId}")
    fun getAllNotify(@PathVariable userId: String): Flux<NotifyEntity> {
        return notifyService.findAllByUserIdNotify(userId)
    }

    @GetMapping("/getAll")
    fun getAll(): Flux<NotifyEntity>{
        System.out.println("This is an informational message");
        return notifyService.findAllNotify()
    }

//    @PostMapping("/doJob")
//    fun createNotifyJob(){
//        System.out.println("Say ...");
//        notifyJob.addNewTask( "2024-03-1 03:25")
//    }

    @PostMapping("/createNotify")
    fun createNotify(@RequestBody body: ReqAddNotifyDTO): String{
        // using this service when edit party, delete party and create party
        // they gonna set job in this service too
        return notifyService.addNotify(body)
    }

}