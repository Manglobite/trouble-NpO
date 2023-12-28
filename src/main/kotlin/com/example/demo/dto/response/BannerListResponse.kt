package com.example.demo.dto.response

import com.example.demo.entities.BannerEntity
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class BannerListResponse (
    val banners: List<BannerEntity>
)