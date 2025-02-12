package com.uicheon.ytsocialapp.android.auth.signup

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uicheon.ytsocialapp.android.common.datastore.UserSettings
import com.uicheon.ytsocialapp.android.common.datastore.toUserSettings
import com.uicheon.ytsocialapp.auth.domain.usecase.SignUpUseCase
import com.uicheon.ytsocialapp.common.util.Result
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase,
    private val dataStore: DataStore<UserSettings>
) : ViewModel() {
    var uiState by mutableStateOf(SignUpUiState())
        private set

    fun signUp() {
        viewModelScope.launch {
            uiState = uiState.copy(isAuthenticating = true)

            val authResultData = signUpUseCase(uiState.email, uiState.username, uiState.password)

            uiState = when (authResultData) {
                is Result.Error -> {
                    Log.e("signUp()", "wtf? ${authResultData.message}")
                    uiState.copy(
                        isAuthenticating = false,
                        authErrorMessage = authResultData.message
                    )
                }

                is Result.Success -> {
                    dataStore.updateData {
                        authResultData.data!!.toUserSettings()
                    }
                    uiState.copy(isAuthenticating = false, authenticationSucceeded = true)
                }
            }
        }
    }

    fun updateUsername(input: String) {
        uiState = uiState.copy(username = input)
    }

    fun updateEmail(input: String) {
        uiState = uiState.copy(email = input)
    }

    fun updatePassword(input: String) {
        uiState = uiState.copy(password = input)
    }
}

data class SignUpUiState(
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var isAuthenticating: Boolean = false,
    var authErrorMessage: String? = null,
    var authenticationSucceeded: Boolean = false
)