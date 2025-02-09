package com.uicheon.ytsocialapp.android.auth.signup

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uicheon.ytsocialapp.android.destinations.HomeScreenDestination
import com.uicheon.ytsocialapp.android.destinations.LoginDestination
import com.uicheon.ytsocialapp.android.destinations.SignUpDestination
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun SignUp(
    navigator: DestinationsNavigator
) {
    val viewModel: SignUpViewModel = koinViewModel()
    SingUpScreen(
        uiState = viewModel.uiState,
        onUserNameChange = viewModel::updateUsername,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onNavigateToLogin = {
            navigator.navigate(LoginDestination) {
                popUpTo(SignUpDestination.route) {
                    inclusive = true
                }
            }
        },
        onNavigateToHome = {
            navigator.navigate(HomeScreenDestination) {
                popUpTo(SignUpDestination.route) {
                    inclusive = true
                }
            }
        },
        onSignUpClick = viewModel::signUp
    )
}
