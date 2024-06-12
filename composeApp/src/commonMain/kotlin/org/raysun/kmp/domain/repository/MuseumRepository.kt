package org.raysun.kmp.domain.repository

import org.raysun.kmp.domain.resp.Galleries

interface MuseumRepository {

    suspend fun getGalleries(): List<Galleries>
}