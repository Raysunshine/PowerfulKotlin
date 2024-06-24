package org.raysun.kmp.domain.resp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Composition(
    @SerialName("artistDisplayName")
    val artistDisplayName: String? = "",
    @SerialName("creditLine")
    val creditLine: String? = "",
    @SerialName("department")
    val department: String? = "",
    @SerialName("dimensions")
    val dimensions: String? = "",
    @SerialName("medium")
    val medium: String? = "",
    @SerialName("objectDate")
    val objectDate: String? = "",
    @SerialName("objectID")
    val objectID: Int? = 0,
    @SerialName("objectURL")
    val objectURL: String? = "",
    @SerialName("primaryImage")
    val primaryImage: String? = "",
    @SerialName("primaryImageSmall")
    val primaryImageSmall: String? = "",
    @SerialName("repository")
    val repository: String? = "",
    @SerialName("title")
    val title: String? = "",
)