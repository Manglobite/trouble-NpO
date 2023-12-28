package com.example.demo.controller

import com.example.demo.entities.BannerEntity
import com.example.demo.entities.BannerEntityNpO
import com.example.demo.entities.SlotEntity
import com.example.demo.repositories.BannerNpORepository
import com.example.demo.repositories.BannerRepository
import com.example.demo.repositories.SlotRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path=["api/v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
class UtilController(
    private val slotRepository: SlotRepository,
    private val bannerRepository: BannerRepository,
    private val bannerNpORepository: BannerNpORepository
) {
    @GetMapping(path = ["fill"])
    fun fillTestData(){
        val slot1 =  slotRepository.saveAndFlush(SlotEntity("slot 1"))
        val slot2 = slotRepository.saveAndFlush(SlotEntity("slot 2"))
        val slot3 = slotRepository.saveAndFlush(SlotEntity("slot 3"))

        bannerRepository.save(BannerEntity("image 1", slot1))
        bannerRepository.save(BannerEntity("image 2", slot2))
        bannerRepository.save(BannerEntity("image 3", slot3))

        bannerNpORepository.save(BannerEntityNpO("image 1", slot1))
        bannerNpORepository.save(BannerEntityNpO("image 2", slot2))
        bannerNpORepository.save(BannerEntityNpO("image 3", slot3))

    }
}