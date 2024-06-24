package org.raysun.kmp.feature.detail.model

import org.raysun.kmp.domain.resp.Composition

sealed class DetailScreenAction {
    data class OnCompositionChanged(val detail: Composition) : DetailScreenAction()
}