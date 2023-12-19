package com.nomad.nomad.region.dto.provinceRegion


data class ReviewIndexRequest(
    // TODO. desc(최신순), asc(평점순) 공통 enum으로 빼기
    var order: String = "desc",
    // TODO. recent(최신순), rating(평점순) validate를 진행하기.
    var orderBy: String = "recent",
    var page: Int = 1,
    var pageSize: Int = 10,
)
