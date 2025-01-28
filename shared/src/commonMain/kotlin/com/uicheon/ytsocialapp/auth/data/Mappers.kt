package com.uicheon.ytsocialapp.auth.data

import com.uicheon.ytsocialapp.auth.domain.model.AuthResultData

internal fun AuthResponseData.toAuthResultData(): AuthResultData{
    return AuthResultData(id, name, bio, avatar, token, followersCount, followingCount)
}