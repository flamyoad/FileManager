package com.flamyoad.explorer_impl

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.flamyoad.explorer_impl.ui.HomePageScreen

const val HOME_PAGE_ROUTE = "homepage"

fun NavController.navigateToHomePage(navOptions: NavOptions) {
    navigate(HOME_PAGE_ROUTE, navOptions)
}

fun NavGraphBuilder.homePageRoute() {
    composable(route = HOME_PAGE_ROUTE) {
        HomePageScreen()
    }
}