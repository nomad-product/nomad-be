package com.nomad.nomad.region.repository

import com.nomad.nomad.region.domain.ProvinceRegionReview
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProvinceRegionReviewRepository : JpaRepository<ProvinceRegionReview, Long> {
    fun findByProvinceRegionId(id: Long, sort: Sort): List<ProvinceRegionReview>
}
