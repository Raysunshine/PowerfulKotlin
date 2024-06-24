package org.raysun.kmp.feature.gallery.model

import org.raysun.kmp.domain.resp.Composition

data class GalleryState(
    val compositionList: List<Composition> = emptyList(),
)