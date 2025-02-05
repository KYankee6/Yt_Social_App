package com.uicheon.ytsocialapp.android.di

import com.uicheon.ytsocialapp.android.auth.login.LoginViewModel
import com.uicheon.ytsocialapp.android.auth.signup.SignUpViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
}