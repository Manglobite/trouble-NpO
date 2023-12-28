package com.example.demo.entities

import jakarta.persistence.Column
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

abstract class BaseAuditEntity<T> : BaseEntity<T>() {

    @CreatedDate
    @Column(updatable = false, nullable = true)
    lateinit var created: LocalDateTime

    @LastModifiedDate
    @Column(nullable = true)
    lateinit var modified: LocalDateTime
}