package org.raysun.kmp.feature.detail.model

import org.raysun.kmp.domain.resp.Galleries

sealed class DetailScreenAction {
    data class OnGalleriesChanged(val detail: Galleries) : DetailScreenAction()
}