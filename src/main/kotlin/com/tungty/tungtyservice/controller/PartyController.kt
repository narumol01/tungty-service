package com.tungty.tungtyservice.controller

import com.tungty.tungtyservice.entity.MessageEntity
import com.tungty.tungtyservice.service.ChatService
import com.tungty.tungtyservice.service.TestService
import com.tungty.tungtyservice.service.addService
import com.tungty.tungtyservice.service.partyService.PartyCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/party")
class PartyController {

    //gencode
    @Autowired
    lateinit var partyCodeService: PartyCodeService

    //GenPartycode
    @PostMapping("genCode/{partyId}")
    fun genPartyCode(@PathVariable("partyId") partyId: String): String {
        println("genPartyCode at controller")
        return partyCodeService.genPartyCode(partyId)
    }
    //getPartycode
    @GetMapping("partyCode/{partyId}")
    fun getPartyCode(@PathVariable("partyId") partyId: String): String {
        println("Get PartyCode at controller")
        return "Get PartyCode at controller"
//        return partyCodeService.getPartyCode(partyId)
    }
}