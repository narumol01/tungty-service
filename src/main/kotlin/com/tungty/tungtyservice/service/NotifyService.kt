package com.tungty.tungtyservice.service

import com.tungty.tungtyservice.DTO.notify.ReqAddNotifyDTO
import com.tungty.tungtyservice.entity.NotifyEntity
import reactor.core.publisher.Flux

interface NotifyService {
    fun findAllNotify(): Flux<NotifyEntity>
    fun findAllByUserIdNotify(userId: String): Flux<NotifyEntity>
    fun addNotify(notifydata: ReqAddNotifyDTO): String

}