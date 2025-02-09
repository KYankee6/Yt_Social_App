@file:OptIn(ExperimentalMaterial3Api::class)

package com.uicheon.ytsocialapp.android.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import com.uicheon.ytsocialapp.android.R
import com.uicheon.ytsocialapp.android.common.theming.SmallElevation
import com.uicheon.ytsocialapp.android.destinations.HomeScreenDestination
import com.uicheon.ytsocialapp.android.destinations.LoginDestination
import com.uicheon.ytsocialapp.android.destinations.SignUpDestination


@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    val currentDestination = navHostController.currentDestinationAsState().value

    Surface(
        modifier = modifier,
        shadowElevation = SmallElevation
    ) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = getAppbarTitle(currentDestination?.route)))
            },
            modifier = modifier,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            actions = {
                AnimatedVisibility(
                    visible = currentDestination?.route == HomeScreenDestination.route
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.person_circle_icon),
                            contentDescription = null
                        )
                    }
                }
            },
            navigationIcon = {
                if (shouldShowNavigationIcon(currentDestination?.route)) {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.round_arrow_back),
                            contentDescription = null
                        )
                    }
                } else {
                    null
                }
            }
        )
    }
}

private fun getAppbarTitle(currentDestinationRoute: String?): Int {
    return when (currentDestinationRoute) {
        LoginDestination.route -> R.string.login_destination_title
        SignUpDestination.route -> R.string.signup_destination_title
        HomeScreenDestination.route -> R.string.home_destination_title
        else -> R.string.no_destination_title
    }
}

private fun shouldShowNavigationIcon(currentDestinationRoute: String?): Boolean {
    return false
}