package org.raysun.kmp.domain.resp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResult<T>(
    @SerialName("errorCode")
    val errorCode: Int? = 0,
    @SerialName("data")
    val data: T? = null,
    @SerialName("errorMsg")
    val errorMsg: String? = "",
)
