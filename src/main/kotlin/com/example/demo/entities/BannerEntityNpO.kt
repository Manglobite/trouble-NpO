package com.example.demo.entities

import jakarta.persistence.*

@Table(name = "bannernpo")
@Entity
class BannerEntityNpO(
    @Column(name = "image", nullable = false)
    val img: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val slot: SlotEntity?
) : BaseEntity<Long>()