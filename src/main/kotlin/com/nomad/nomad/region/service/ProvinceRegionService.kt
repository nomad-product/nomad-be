package com.nomad.nomad.region.service

import com.nomad.nomad.common.exception.NotFoundEntityException
import com.nomad.nomad.region.dto.ProvinceGetRegionReviewRequest
import com.nomad.nomad.region.dto.ProvinceRegionReviewResponse
import com.nomad.nomad.region.dto.RegionIndexResponse
import com.nomad.nomad.region.dto.RegionShowResponse
import com.nomad.nomad.region.repository.ProvinceRegionRepository
import com.nomad.nomad.region.repository.ProvinceRegionReviewRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProvinceRegionService(
    val provinceRegionRepository: ProvinceRegionRepository,
    val provinceRegionReviewRepository: ProvinceRegionReviewRepository,
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

    fun getReviews(
        id: Long,
        provinceGetRegionReviewRequest: ProvinceGetRegionReviewRequest,
    ): List<ProvinceRegionReviewResponse> {
        val provinceRegion = provinceRegionRepository.findById(id)
            .orElseThrow { NotFoundEntityException("해당 지역을 찾을 수 없습니다.") }
        val reviews = when (provinceGetRegionReviewRequest.orderBy) {
            "recent" -> {
                provinceRegionReviewRepository.findByProvinceRegionId(
                    provinceRegion.id!!,
                    Sort.by(Sort.Direction.valueOf(provinceGetRegionReviewRequest.order.uppercase()), "createdAt"),
                )
            }

            "rating" -> provinceRegionReviewRepository.findByProvinceRegionId(
                provinceRegion.id!!,
                Sort.by(Sort.Direction.valueOf(provinceGetRegionReviewRequest.order.uppercase()), "rating"),
            )

            else -> throw IllegalArgumentException("정렬 방식이 잘못되었습니다.")
        }
        return reviews.map {
            ProvinceRegionReviewResponse(
                it.id,
                it.userName,
                it.rating,
                it.content,
                it.createdAt,
                it.updatedAt,
            )
        }.toList()
    }
}
