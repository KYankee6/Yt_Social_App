package com.uicheon.ytsocialapp.android.common.datastore

import com.uicheon.ytsocialapp.auth.domain.model.AuthResultData
import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    val id: Int = -1,
    val name: String = "",
    val bio: String = "",
    val avatar: String? = null,
    val token: String = "",
    val followersCount: Int = 0,
    val followingCount: Int = 0
)

fun UserSettings.toAuthResultData(): AuthResultData {
    return AuthResultData(
        id,
        name,
        bio,
        avatar,
        token,
        followersCount,
        followingCount
    )
}

fun AuthResultData.toUserSettings(): UserSettings {
    return UserSettings(
        id,
        name,
        bio,
        avatar,
        token,
        followersCount,
        followingCount
    )
}
