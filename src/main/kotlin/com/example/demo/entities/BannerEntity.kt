package com.example.demo.entities

import jakarta.persistence.*

@Table(name = "banner")
@Entity
@NamedEntityGraph(
    name = "with_all_associations",
    includeAllAttributes = true
)
class BannerEntity(
    @Column(name = "image", nullable = false)
    val img: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val slot: SlotEntity?
) : BaseEntity<Long>()