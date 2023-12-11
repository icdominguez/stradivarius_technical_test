package com.icdominguez.stradivariustechnicaltest.feature.home.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.icdominguez.stradivariustechnicaltest.feature.home.HomeViewModel
import com.icdominguez.stradivariustechnicaltest.feature.home.composables.UsersScreen

const val usersRoute = "users_route"

fun NavController.navigateToUsers(navOptions: NavOptions? = null) {
    this.navigate(usersRoute, navOptions)
}

fun NavGraphBuilder.usersScreen(
    navigateToDetail: () -> Unit,
) {
    composable(route = usersRoute) { navBackStackEntry ->
        val viewModel = hiltViewModel<HomeViewModel>(navBackStackEntry)
        UsersScreen(
            viewModel = viewModel,
            uiEvent = viewModel::uiEvent,
            navigateToDetail = navigateToDetail,
        )
    }
}
