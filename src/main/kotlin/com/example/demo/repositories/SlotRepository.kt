package com.example.demo.repositories

import com.example.demo.entities.SlotEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SlotRepository: JpaRepository<SlotEntity,Long> {

    fun findOneByName(name: String) : SlotEntity
}