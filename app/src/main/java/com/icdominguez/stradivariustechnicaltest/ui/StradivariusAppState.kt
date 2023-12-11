package com.icdominguez.stradivariustechnicaltest.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.icdominguez.stradivariustechnicaltest.feature.detail.navigation.detailRoute
import com.icdominguez.stradivariustechnicaltest.feature.detail.navigation.navigateToUserDetail
import com.icdominguez.stradivariustechnicaltest.feature.home.navigation.navigateToUsers
import com.icdominguez.stradivariustechnicaltest.feature.home.navigation.usersRoute
import com.icdominguez.stradivariustechnicaltest.navigation.TopLevelDestination

@Composable
fun rememberStradivariusAppState(
    navController: NavHostController = rememberNavController(),
): StradivariusAppState {
    return remember(
        navController,
    ) {
        StradivariusAppState(navController = navController)
    }
}

@Stable
class StradivariusAppState(
    val navController: NavHostController,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            usersRoute -> TopLevelDestination.HOME
            detailRoute -> TopLevelDestination.DETAIL
            else -> null
        }

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.HOME -> navController.navigateToUsers(topLevelNavOptions)
            else -> {}
        }
    }
}
