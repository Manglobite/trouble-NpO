package com.example.demo.repositories

import com.example.demo.entities.BannerEntityNpO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BannerNpORepository:JpaRepository<BannerEntityNpO,Long> {
}