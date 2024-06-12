package org.raysun.kmp.domain.usecase

import org.raysun.kmp.domain.repository.MuseumRepository
import org.raysun.kmp.domain.resp.Galleries

class GetGalleriesUseCase(
    private val museumRepository: MuseumRepository,
) {

    suspend operator fun invoke(): List<Galleries> = museumRepository.getGalleries()
}