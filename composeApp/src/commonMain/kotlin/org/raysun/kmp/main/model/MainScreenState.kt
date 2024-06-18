package org.raysun.kmp.main.model

data class MainScreenState(
    val detailDisplayMode: DetailDisplayMode = DetailDisplayMode.DETAIL_MODULE,
)

enum class DetailDisplayMode(
    val symbol: String,
    val description: List<String>
) {
    DETAIL_MODULE(
        symbol = "详情页",
        description = listOf(
            "在详情页中查看",
            "画作 以及 画作信息",
        )
    ),
    NEW_DIALOG(
        symbol = "模态弹窗",
        description = listOf(
            "在模态弹窗中查看",
            "画作 以及 画作信息",
        )
    ),
    NEW_WINDOW(
        symbol = "新窗口",
        description = listOf(
            "在新窗口中查看",
            "仅画作",
        )
    );
}