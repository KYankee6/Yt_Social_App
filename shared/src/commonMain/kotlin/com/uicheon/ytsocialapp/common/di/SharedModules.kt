package com.uicheon.ytsocialapp.common.di

import com.uicheon.ytsocialapp.auth.data.AuthRepositoryImpl
import com.uicheon.ytsocialapp.auth.data.AuthService
import com.uicheon.ytsocialapp.auth.domain.repository.AuthRepository
import com.uicheon.ytsocialapp.auth.domain.usecase.SignInUseCase
import com.uicheon.ytsocialapp.auth.domain.usecase.SignUpUseCase
import com.uicheon.ytsocialapp.common.util.provideDispatcher
import org.koin.dsl.module

private val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    factory { AuthService() }
    factory { SignUpUseCase() }
    factory { SignInUseCase() }

}

private val utilityModule = module {
    factory { provideDispatcher() }
}

fun getSharedModules() = listOf(authModule, utilityModule)