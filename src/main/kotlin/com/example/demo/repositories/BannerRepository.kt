package com.example.demo.repositories

import com.example.demo.entities.BannerEntity
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BannerRepository:JpaRepository<BannerEntity,Long> {
    @EntityGraph(value = "with_all", type = EntityGraph.EntityGraphType.FETCH, attributePaths = ["slot"])
    override fun findAll(): MutableList<BannerEntity>
}