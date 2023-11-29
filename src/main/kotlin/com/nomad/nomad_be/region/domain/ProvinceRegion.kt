package com.nomad.nomad_be.region.domain

import com.nomad.nomad_be.common.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "province_regions")
class ProvinceRegion : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "name", nullable = false)
    val name: String? = null

    @Column(name = "description", nullable = false)
    val description: String? = null

    @Column(name = "thumbnail_image", nullable = false)
    val thumbnailImage: String? = null

    @Column(name = "main_image", nullable = false)
    val mainImage: String? = null

    @OneToMany(mappedBy = "provinceRegion")
    val districtRegions: List<DistrictRegion>? = null
}