package com.uicheon.ytsocialapp.android.common.components.fake_data

data class FollowsUser(
    val id: Int,
    val name: String,
    val profileUrl: String,
    val isFollowing: Boolean = false
)


val sampleUsers = listOf(
    FollowsUser(
        id = 1,
        name = "Joonhyeok.yang",
        profileUrl = "https://picsum.photos/200"
    ),
    FollowsUser(
        id = 2,
        name = "woobin.yang",
        profileUrl = "https://picsum.photos/200"
    ),
    FollowsUser(
        id = 3,
        name = "Duekryul.yang",
        profileUrl = "https://picsum.photos/200"
    )
)