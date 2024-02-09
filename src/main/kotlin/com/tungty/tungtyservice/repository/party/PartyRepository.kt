package com.tungty.tungtyservice.repository.party

import com.tungty.tungtyservice.entity.MessageEntity
import com.tungty.tungtyservice.entity.PartyEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository


@Repository
interface PartyRepository: ReactiveMongoRepository<PartyEntity, String> {
    // ...
    fun findByPartyId(partyId: String): PartyEntity
}