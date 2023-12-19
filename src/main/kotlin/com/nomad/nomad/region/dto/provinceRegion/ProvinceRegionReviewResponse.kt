package com.nomad.nomad.region.dto.provinceRegion

import java.time.LocalDateTime

/**
 * DTO for {@link com.nomad.nomad.region.domain.RegionReview}
 */
data class ProvinceRegionReviewResponse(
    val id: Long? = null,
    val userName: String? = null,
    val rating: Double? = null,
    val content: String? = null,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null,
)
