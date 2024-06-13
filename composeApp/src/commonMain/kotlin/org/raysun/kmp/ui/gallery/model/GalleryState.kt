package org.raysun.kmp.ui.gallery.model

import org.raysun.kmp.domain.resp.Galleries

data class GalleryState(
    val picList: List<Galleries> = emptyList(),
)