package org.raysun.kmp.network

import kotlinx.serialization.Serializable

@Serializable
data class ResultWrapper<T>(
    val errorCode: Int,
    val errorMsg: String,
    val data: T
)

@Serializable
data class HotKey(
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)