package com.tungty.tungtyservice.job

import com.tungty.tungtyservice.DTO.notify.ReqAddNotifyDTO
import com.tungty.tungtyservice.entity.NotifyEntity
import com.tungty.tungtyservice.repository.NotifyRepository
import com.tungty.tungtyservice.service.NotifyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.awt.SystemTray
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.atomic.AtomicInteger
import java.text.SimpleDateFormat


@Service
class NotifyJob() {

    @Autowired
lateinit var notifyRepository: NotifyRepository

    fun getCurrentTimeWithOffset(): String {
        val currentLocale = Locale.getDefault() // Get user's locale (optional)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", currentLocale) // Adjust format if necessary
        dateFormat.timeZone = TimeZone.getTimeZone("Asia/Bangkok") // Set time zone offset (+07:00 for Bangkok)
        return dateFormat.format(Date())
    }
    fun doGetData(element: NotifyEntity): Mono<NotifyEntity> {
//        if(element.appointmentTime == getCurrentTimeWithOffset()){
            System.out.println("In TIME!!!")
            element.status = "Unread"
//        }
        notifyRepository.save(element)
        Thread.sleep(1000);
        return element.toMono()
    }
    @Scheduled(cron = "0 * * ? * *")
    fun addNewTask() {
        System.out.println("Check !");
        try {
            val datasnoti = notifyRepository.findAll()
            val fildatsnoti = datasnoti.filter({ele -> ele.appointmentTime == "2024-03-13T03:22:00+07:00"}).collectList().block()!!
            fildatsnoti.forEach(System.out::println)
            for(noti in fildatsnoti){
                noti.status = "Unread"
                System.out.println("$noti !!")
                notifyRepository.save(noti)
                System.out.println("Do save TIME !!")
            }
//            System.out.println()

        } catch (e: Exception) {
            System.out.println("Error: $e")
        }

//        datanoti.doOnNext{ element ->
//            if (element.appointmentTime == getCurrentTimeWithOffset()){
//                System.out.println()
//                System.out.println("IT TIME!! IT TIME!! NOW GO CHANGE STATUS ${element.partyName}")
//                val chagestatus = NotifyEntity(
//                    _id = element._id,
//                    partyName = element.partyName,
//                    typeAction = element.typeAction,
//                    notifyDescription = element.notifyDescription,
//                    userId = element.userId,
//                    appointmentDate = element.appointmentDate,
//                    appointmentTime = element.appointmentTime,
//                    status = "Unread",
//                    partyId = element.partyId
//                )
//                System.out.println(chagestatus)
//                notifyRepository.save(
//                    chagestatus
//                )
//            }
//        }.subscribe()


//            .subscribe { element ->
//            System.out.println("Processing element: $element");
//            if(element.status == "Pending"){
//                System.out.println("THIS IS PENDING !!! BRO IT GONNA ALERT IN ${element.appointmentTime}")
//            }
//            System.out.println(getCurrentTimeWithOffset())
//            if (element.appointmentTime == getCurrentTimeWithOffset()){
//                System.out.println()
//                System.out.println("IT TIME!! IT TIME!! NOW GO CHANGE STATUS ${element.partyName}")
//                doAddData(element)
//                System.out.println(notifyRepository.findAll())
//            }

    }
}
