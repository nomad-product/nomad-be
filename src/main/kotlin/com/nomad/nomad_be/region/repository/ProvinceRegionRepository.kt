package com.nomad.nomad_be.region.repository

import com.nomad.nomad_be.region.domain.ProvinceRegion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ProvinceRegionRepository : JpaRepository<ProvinceRegion, Long> {
}