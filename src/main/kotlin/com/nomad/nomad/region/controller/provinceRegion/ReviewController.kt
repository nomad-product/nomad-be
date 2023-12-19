package com.nomad.nomad.region.controller.provinceRegion

import com.nomad.nomad.region.dto.provinceRegion.ProvinceRegionReviewResponse
import com.nomad.nomad.region.dto.provinceRegion.ReviewCreateRequest
import com.nomad.nomad.region.dto.provinceRegion.ReviewIndexRequest
import com.nomad.nomad.region.service.ProvinceRegionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/regions/{provinceRegionId}")
class ReviewController(
    val provinceRegionService: ProvinceRegionService,
) {
    @GetMapping("/reviews")
    fun index(
        @PathVariable provinceRegionId: Long,
        reviewIndexRequest: ReviewIndexRequest,
    ): ResponseEntity<List<ProvinceRegionReviewResponse>> {
        return ResponseEntity.ok(
            provinceRegionService.getReviews(provinceRegionId, reviewIndexRequest),
        )
    }

    @PostMapping("/reviews")
    fun create(
        @PathVariable provinceRegionId: Long,
        reviewCreateRequest: ReviewCreateRequest,
    ): ResponseEntity<Unit> {
        return ResponseEntity.ok(
            provinceRegionService.createReview(provinceRegionId, reviewCreateRequest),
        )
    }
}
