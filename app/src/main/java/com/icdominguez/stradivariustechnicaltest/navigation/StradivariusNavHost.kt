package com.icdominguez.stradivariustechnicaltest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.icdominguez.stradivariustechnicaltest.feature.detail.navigation.detailScreen
import com.icdominguez.stradivariustechnicaltest.feature.detail.navigation.navigateToUserDetail
import com.icdominguez.stradivariustechnicaltest.feature.home.navigation.usersRoute
import com.icdominguez.stradivariustechnicaltest.feature.home.navigation.usersScreen
import com.icdominguez.stradivariustechnicaltest.ui.StradivariusAppState

@Composable
fun StradivariusNavHost(
    appState: StradivariusAppState,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = usersRoute,
    ) {
        usersScreen(
            navigateToDetail = navController::navigateToUserDetail
        )
        detailScreen(
            onBackClick = navController::popBackStack,
        )
    }
}
