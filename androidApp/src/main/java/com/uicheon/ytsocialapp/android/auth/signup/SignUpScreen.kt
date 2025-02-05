package com.uicheon.ytsocialapp.android.auth.signup

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uicheon.ytsocialapp.android.R
import com.uicheon.ytsocialapp.android.common.components.CustomTextField
import com.uicheon.ytsocialapp.android.common.theming.ButtonHeight
import com.uicheon.ytsocialapp.android.common.theming.ExtraLargeSpacing
import com.uicheon.ytsocialapp.android.common.theming.LargeSpacing
import com.uicheon.ytsocialapp.android.common.theming.MediumSpacing
import com.uicheon.ytsocialapp.android.common.theming.SmallSpacing
import com.uicheon.ytsocialapp.android.common.theming.SocialAppTheme

@Composable
fun SingUpScreen(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    onUserNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onNavigateToLogin: () -> Unit,
    onNavigateToHome: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(
                    color = if (isSystemInDarkTheme()) {
                        MaterialTheme.colorScheme.background
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                )
                .padding(
                    top = ExtraLargeSpacing + LargeSpacing,
                    start = LargeSpacing + MediumSpacing,
                    end = LargeSpacing + MediumSpacing,
                    bottom = LargeSpacing
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(LargeSpacing)

        ) {
            CustomTextField(
                value = uiState.username,
                onValueChange = onUserNameChange,
                hint = R.string.username_hint
            )

            CustomTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
                hint = R.string.email_hint,
                keyboardType = KeyboardType.Email
            )
            CustomTextField(
                value = uiState.password,
                onValueChange = onPasswordChange,
                hint = R.string.password_hint,
                keyboardType = KeyboardType.Password,
                isPasswordTextField = true
            )

            Button(
                onClick = {
                    onSignUpClick()
                },
                modifier = modifier
                    .fillMaxWidth()
                    .height(ButtonHeight),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = stringResource(id = R.string.signup_button_hint))
            }

            GoToSignIn {
                onNavigateToLogin()
            }

        }

        if (uiState.isAuthenticating) {
            CircularProgressIndicator()
        }
    }

    LaunchedEffect(
        key1 = uiState.authenticationSucceeded,
        key2 = uiState.authErrorMessage,
        block = {
            if (uiState.authenticationSucceeded) {
                onNavigateToHome()
            }

            if (uiState.authErrorMessage != null) {
                Toast.makeText(context, uiState.authErrorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    )
}

@Composable
fun GoToSignIn(
    modifier: Modifier = Modifier,
    onNavigateToLogin: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(SmallSpacing)
    ) {
        Text("Have already an account?", style = MaterialTheme.typography.labelSmall)
        Text(
            text = "Login",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier.clickable { onNavigateToLogin() }
        )
    }

}


@Preview
@Composable
fun SigunScreenPreview() {
    SocialAppTheme {
        SingUpScreen(
            uiState = SignUpUiState(),
            onUserNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onNavigateToLogin = {},
            onNavigateToHome = {},
            onSignUpClick = {}
        )
    }
}