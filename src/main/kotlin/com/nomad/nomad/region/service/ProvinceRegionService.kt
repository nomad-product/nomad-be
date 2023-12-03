package com.nomad.nomad.region.service

import com.nomad.nomad.region.dto.RegionIndexResponse
import com.nomad.nomad.region.repository.ProvinceRegionRepository
import org.springframework.stereotype.Service

@Service
class ProvinceRegionService(
    val provinceRegionRepository: ProvinceRegionRepository,
) {
    fun findAll(): List<RegionIndexResponse> {
        return provinceRegionRepository.findAll()
            .map { RegionIndexResponse(it.id!!, it.name!!, it.thumbnailImage!!) }
            .toList()
    }
}
