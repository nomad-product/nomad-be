package com.nomad.nomad.region.domain

import com.nomad.nomad.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "district_regions")
class DistrictRegion : BaseEntity() {
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

    @ManyToOne
    @JoinColumn(name = "province_region_id", nullable = false)
    val provinceRegion: ProvinceRegion? = null
}
