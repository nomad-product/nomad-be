package com.nomad.nomad.region.controller

import com.nomad.nomad.region.dto.RegionIndexResponse
import com.nomad.nomad.region.dto.RegionShowResponse
import com.nomad.nomad.region.service.ProvinceRegionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/regions")
class ProvinceRegionController(
    val provinceRegionService: ProvinceRegionService,
) {
    @GetMapping
    fun index(): ResponseEntity<List<RegionIndexResponse>> = ResponseEntity.ok(provinceRegionService.findAll())

    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): ResponseEntity<RegionShowResponse> = ResponseEntity.ok(
        provinceRegionService.findById(id),
    )
}
