package com.example.demo.entities

import jakarta.persistence.*

@Table(name = "slot")
@Entity
class SlotEntity(
    @Column(name = "name", nullable = false)
    val name: String,
) : BaseEntity<Long>() {
}