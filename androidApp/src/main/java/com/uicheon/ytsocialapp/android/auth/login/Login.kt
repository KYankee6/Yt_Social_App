package com.uicheon.ytsocialapp.android.auth.login

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uicheon.ytsocialapp.android.destinations.HomeScreenDestination
import org.koin.androidx.compose.koinViewModel


@Destination(start = true)
@Composable
fun Login(
    navigator: DestinationsNavigator
) {
    val viewModel: LoginViewModel = koinViewModel()
    LoginScreen(
        uiState = viewModel.uiState,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToHome = {
            navigator.navigate(HomeScreenDestination)
        },
        onSignInClick = viewModel::signIn
    )
}