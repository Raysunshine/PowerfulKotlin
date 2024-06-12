package org.raysun.kmp.domain.resp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HotKey(
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("link")
    val link: String? = "",
    @SerialName("name")
    val name: String? = "",
    @SerialName("order")
    val order: Int? = 0,
    @SerialName("visible")
    val visible: Int? = 0
)