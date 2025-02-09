package com.uicheon.ytsocialapp.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.uicheon.ytsocialapp.android.common.components.AppBar
import com.uicheon.ytsocialapp.android.destinations.HomeScreenDestination
import com.uicheon.ytsocialapp.android.destinations.LoginDestination

@Composable
fun SocialApp(
    token: String?
) {
    val navHostController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    val isSystemInDark = isSystemInDarkTheme()
    val statusBarColor = if (isSystemInDark) {
        MaterialTheme.colorScheme.surface
    } else {
        MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
    }
    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = !isSystemInDark
        )
    }

    Scaffold(
        topBar = {
            AppBar(navHostController = navHostController)
        }
    ) { innerPaddings ->
        DestinationsNavHost(
            modifier = Modifier.padding(innerPaddings),
            navGraph = NavGraphs.root,
            navController = navHostController
        )
    }
    LaunchedEffect(key1 = token,
        block = {
            if (token != null && token.isEmpty()){
                navHostController.navigate(LoginDestination.route) {
                    popUpTo(HomeScreenDestination.route) {
                        inclusive = true
                    }
                }
            }
        })

}