package com.icdominguez.stradivariustechnicaltest.feature.detail.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.icdominguez.stradivariustechnicaltest.feature.detail.DetailViewModel
import com.icdominguez.stradivariustechnicaltest.feature.detail.composables.DetailScreen

const val detailRoute = "detail_route"

fun NavController.navigateToUserDetail() {
    this.navigate(detailRoute) {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.detailScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = detailRoute,
    ) { navBackStackEntry ->
        val viewModel = hiltViewModel<DetailViewModel>(navBackStackEntry)
        DetailScreen(
            viewModel = viewModel,
            uiEvent = viewModel::uiEvent,
            onBackClick = onBackClick,
        )
    }
}
