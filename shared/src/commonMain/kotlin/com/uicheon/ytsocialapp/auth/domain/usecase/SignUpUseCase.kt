package com.uicheon.ytsocialapp.auth.domain.usecase

import co.touchlab.kermit.Logger
import com.uicheon.ytsocialapp.auth.domain.model.AuthResultData
import com.uicheon.ytsocialapp.auth.domain.repository.AuthRepository
import com.uicheon.ytsocialapp.common.util.Result
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpUseCase : KoinComponent {
    private val repository: AuthRepository by inject()


    suspend operator fun invoke(
        email: String,
        name: String,
        password: String
    ): Result<AuthResultData> {
        Logger.i("invoke() called with email=$email, name=$name, password=$password")

        if (name.isBlank() || name.length < 3) {
            return Result.Error(
                message = "Invalid name"
            )
        }
        if (email.isBlank() || "@" !in email) {
            return Result.Error(
                message = "Invalid email"
            )
        }
        if (password.isBlank() || password.length < 4) {
            return Result.Error(
                message = "Invalid password or too short"
            )
        }
        return repository.signUp(name, email, password)
    }
}