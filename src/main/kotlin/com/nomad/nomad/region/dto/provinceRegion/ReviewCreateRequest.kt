package com.nomad.nomad.region.dto.provinceRegion

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class ReviewCreateRequest(
    @NotNull
    @Max(5, message = "평점은 5점 만점입니다.")
    @Min(0, message = "평점은 0점 이상입니다.")
    val rating: Double,
    @NotNull
    @NotBlank
    val content: String,
    @NotNull
    @NotBlank
    val userName: String,
)
