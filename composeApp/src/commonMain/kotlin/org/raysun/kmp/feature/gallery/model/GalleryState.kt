package org.raysun.kmp.feature.gallery.model

import org.raysun.kmp.domain.resp.Galleries

data class GalleryState(
    val picList: List<Galleries> = emptyList(),
)