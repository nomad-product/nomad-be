package com.nomad.nomad.region.service

import com.nomad.nomad.common.exception.NotFoundEntityException
import com.nomad.nomad.region.domain.ProvinceRegionReview
import com.nomad.nomad.region.dto.provinceRegion.ProvinceRegionReviewResponse
import com.nomad.nomad.region.dto.provinceRegion.RegionIndexResponse
import com.nomad.nomad.region.dto.provinceRegion.RegionShowResponse
import com.nomad.nomad.region.dto.provinceRegion.ReviewCreateRequest
import com.nomad.nomad.region.dto.provinceRegion.ReviewIndexRequest
import com.nomad.nomad.region.repository.ProvinceRegionRepository
import com.nomad.nomad.region.repository.ProvinceRegionReviewRepository
import org.springframework.data.domain.PageRequest
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
        provinceRegionId: Long,
        reviewIndexRequest: ReviewIndexRequest,
    ): List<ProvinceRegionReviewResponse> {
        val provinceRegion = provinceRegionRepository.findById(provinceRegionId)
            .orElseThrow { NotFoundEntityException("해당 지역을 찾을 수 없습니다.") }
        val reviews = when (reviewIndexRequest.orderBy) {
            "recent" -> {
                val pageable = PageRequest.of(
                    reviewIndexRequest.page,
                    reviewIndexRequest.pageSize,
                    Sort.by(Sort.Direction.valueOf(reviewIndexRequest.order.uppercase()), "createdAt"),
                )
                provinceRegionReviewRepository.findByProvinceRegionId(
                    provinceRegion.id!!,
                    pageable,
                )
            }

            "rating" -> {
                val pageable = PageRequest.of(
                    reviewIndexRequest.page,
                    reviewIndexRequest.pageSize,
                    Sort.by(Sort.Direction.valueOf(reviewIndexRequest.order.uppercase()), "rating"),
                )
                provinceRegionReviewRepository.findByProvinceRegionId(
                    provinceRegion.id!!,
                    pageable,
                )
            }

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

    fun createReview(
        provinceRegionId: Long,
        reviewCreateRequest: ReviewCreateRequest,
    ) {
        val provinceRegion = provinceRegionRepository.findById(provinceRegionId)
            .orElseThrow { NotFoundEntityException("해당 지역을 찾을 수 없습니다.") }

        val review = ProvinceRegionReview(
            provinceRegion = provinceRegion,
            userName = reviewCreateRequest.userName,
            rating = reviewCreateRequest.rating,
            content = reviewCreateRequest.content,
        )

        provinceRegionReviewRepository.save(review)
    }
}
