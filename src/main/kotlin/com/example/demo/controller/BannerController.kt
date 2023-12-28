package com.example.demo.controller

import com.example.demo.dto.request.BannerAdd
import com.example.demo.entities.BannerEntity
import com.example.demo.entities.BannerEntityNpO
import com.example.demo.repositories.BannerNpORepository
import com.example.demo.repositories.BannerRepository
import com.example.demo.repositories.SlotRepository
import jakarta.persistence.criteria.JoinType
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.provider.HibernateUtils
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(path = ["/api/v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
class BannerController(
    private val bannerRepository: BannerRepository,
    private val slotRepository: SlotRepository,
    private val bannerNpORepository: BannerNpORepository
) {
    @PostMapping(path = ["banner"])
    fun addBanner(
        @RequestBody banner: BannerAdd
    ) = bannerRepository.saveAndFlush(
        BannerEntity(
            img = banner.image,
            slot = slotRepository.findByIdOrNull(banner.slot)
        )
    ).id?.let {
        bannerRepository.findById(it)
    } ?: Optional.empty()


    @GetMapping(path = ["bannersNoProblem1"])
    fun getBannersNoBug1(): MutableList<BannerEntity> = bannerRepository.findAll()

    @GetMapping(path = ["bannersNpO"])
    fun getBannersNoP(): MutableList<BannerEntityNpO> = bannerNpORepository.findAll()

    @GetMapping(path = ["bannersNoProblem2"])
    fun getBannersNoBug2(): MutableList<BannerEntityNpO> = bannerNpORepository.findAll

    fun speca(): Specification<BannerEntity> {
        return Specification<BannerEntity> { root, cq, cb ->
            if (cq.resultType == BannerEntity::class.java) {
                root.fetch("slot", JoinType.LEFT)
            }
            cb.and()
        }
    }
}