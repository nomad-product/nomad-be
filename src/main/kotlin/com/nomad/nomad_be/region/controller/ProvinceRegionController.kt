package com.nomad.nomad_be.region.controller

import com.nomad.nomad_be.region.dto.RegionIndexResponse
import com.nomad.nomad_be.region.service.ProvinceRegionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/regions")
class ProvinceRegionController(
    val provinceRegionService: ProvinceRegionService
) {
    @GetMapping
    fun index(): ResponseEntity<List<RegionIndexResponse>> = ResponseEntity.ok(provinceRegionService.findAll());
}