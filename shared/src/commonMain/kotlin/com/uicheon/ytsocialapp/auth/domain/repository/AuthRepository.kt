package com.uicheon.ytsocialapp.auth.domain.repository

import com.uicheon.ytsocialapp.auth.domain.model.AuthResultData
import com.uicheon.ytsocialapp.common.util.Result

internal interface AuthRepository {
    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Result<AuthResultData>


    suspend fun signIn(
        email: String,
        password: String
    ): Result<AuthResultData>
}