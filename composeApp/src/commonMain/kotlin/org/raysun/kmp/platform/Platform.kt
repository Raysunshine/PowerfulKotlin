package org.raysun.kmp.platform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform