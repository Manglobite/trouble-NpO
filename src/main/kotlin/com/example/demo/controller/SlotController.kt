package com.example.demo.controller

import com.example.demo.dto.request.SlotAdd
import com.example.demo.entities.BannerEntity
import com.example.demo.entities.SlotEntity
import com.example.demo.repositories.BannerRepository
import com.example.demo.repositories.SlotRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
class SlotController(
    private val slotRepository: SlotRepository,
    private val bannerRepository: BannerRepository
) {
    @GetMapping(path = ["slots"])
    fun getSlots(): MutableList<SlotEntity> = slotRepository.findAll()

    @PostMapping(path = ["slot"])
    fun addSlot(
        @RequestBody slot: SlotAdd
    ) {
        slotRepository.save(
            SlotEntity(
                name = slot.name
            )
        )
    }
}