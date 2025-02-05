package com.uicheon.ytsocialapp.android.auth.login

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import com.uicheon.ytsocialapp.android.destinations.HomeScreenDestination
import com.uicheon.ytsocialapp.android.destinations.LoginDestination
import com.uicheon.ytsocialapp.android.destinations.SignUpDestination
import org.koin.androidx.compose.koinViewModel


@Destination
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
            navigator.navigate(HomeScreenDestination) {
                popUpTo(LoginDestination.route) {
                    inclusive = true
                }
            }
        },
        onSignInClick = viewModel::signIn,
        onNavigateToSignUp = {
            navigator.navigate(SignUpDestination) {
                popUpTo(LoginDestination.route) {
                    inclusive = true
                }
            }
        }
    )
}