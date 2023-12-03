package com.nomad.nomad.region.repository

import com.nomad.nomad.region.domain.ProvinceRegion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProvinceRegionRepository : JpaRepository<ProvinceRegion, Long>
