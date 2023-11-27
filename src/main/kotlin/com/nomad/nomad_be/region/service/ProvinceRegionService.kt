package com.nomad.nomad_be.region.service

import com.nomad.nomad_be.region.dto.RegionIndexResponse
import com.nomad.nomad_be.region.repository.ProvinceRegionRepository
import org.springframework.stereotype.Service

@Service
class ProvinceRegionService(
    val provinceRegionRepository: ProvinceRegionRepository
) {
    fun findAll(): List<RegionIndexResponse> {
        return provinceRegionRepository.findAll()
            .map { RegionIndexResponse(it.id!!, it.name!!, it.thumbnailImage!!) }
            .toList()
    };
}