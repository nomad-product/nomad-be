package com.nomad.nomad.region.service

import com.nomad.nomad.common.exception.NotFoundEntityException
import com.nomad.nomad.region.dto.ProvinceRegionReviewResponse
import com.nomad.nomad.region.dto.RegionIndexResponse
import com.nomad.nomad.region.dto.RegionShowResponse
import com.nomad.nomad.region.repository.ProvinceRegionRepository
import org.springframework.stereotype.Service

@Service
class ProvinceRegionService(
    val provinceRegionRepository: ProvinceRegionRepository,
) {
    fun findAll(): List<RegionIndexResponse> {
        return provinceRegionRepository.findAll()
            .map { RegionIndexResponse(it.id, it.name, it.thumbnailImage) }
            .toList()
    }

    fun findById(id: Long): RegionShowResponse {
        val provinceRegion = provinceRegionRepository.findById(id)
            .orElseThrow { NotFoundEntityException("해당 지역을 찾을 수 없습니다.") }
        return RegionShowResponse(
            provinceRegion.id,
            provinceRegion.name,
            provinceRegion.description,
            provinceRegion.mainImage,
        )
    }

    fun getReviews(id: Long): List<ProvinceRegionReviewResponse> {
        val provinceRegion = provinceRegionRepository.findById(id)
            .orElseThrow { NotFoundEntityException("해당 지역을 찾을 수 없습니다.") }

        return provinceRegion.reviews
            .map { ProvinceRegionReviewResponse(it.id,
                it.userName,
                it.rating,
                it.content,
                it.createdAt,
                it.updatedAt) }
            .toList()
    }
}
