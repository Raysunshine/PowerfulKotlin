package org.raysun.kmp.domain.repository

import org.raysun.kmp.domain.resp.Composition

interface MuseumRepository {

    suspend fun getComposition(): List<Composition>
}