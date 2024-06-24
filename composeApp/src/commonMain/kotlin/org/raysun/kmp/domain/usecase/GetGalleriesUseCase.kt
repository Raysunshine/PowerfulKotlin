package org.raysun.kmp.domain.usecase

import org.raysun.kmp.domain.repository.MuseumRepository
import org.raysun.kmp.domain.resp.Composition

class GetCompositionUseCase(
    private val museumRepository: MuseumRepository,
) {

    suspend operator fun invoke(): List<Composition> = museumRepository.getComposition()
}