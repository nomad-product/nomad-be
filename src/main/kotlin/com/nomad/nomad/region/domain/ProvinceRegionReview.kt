package com.nomad.nomad.region.domain

import com.nomad.nomad.common.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "province_region_reviews")
class ProvinceRegionReview(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "user_name", nullable = false)
    val userName: String? = null,

    @Column(name = "rating", nullable = false, length = 5)
    val rating: Double? = null,

    @Lob
    @Column(name = "content", nullable = false)
    val content: String? = null,

    @ManyToOne
    val provinceRegion: ProvinceRegion? = null,
) : BaseEntity()
