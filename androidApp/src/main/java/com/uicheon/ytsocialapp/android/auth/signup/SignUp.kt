package com.uicheon.ytsocialapp.android.auth.signup

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uicheon.ytsocialapp.android.destinations.HomeScreenDestination
import com.uicheon.ytsocialapp.android.destinations.LoginDestination
import com.uicheon.ytsocialapp.android.home.HomeScreen
import org.koin.androidx.compose.koinViewModel

@Destination(start = true)
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
            navigator.navigate(LoginDestination)
        },
        onNavigateToHome = {
            navigator.navigate(HomeScreenDestination)

        },
        onSignUpClick = viewModel::signUp
    )
}
