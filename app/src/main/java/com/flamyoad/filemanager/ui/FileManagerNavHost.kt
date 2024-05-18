package com.flamyoad.filemanager.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.flamyoad.explorer_impl.HOME_PAGE_ROUTE
import com.flamyoad.explorer_impl.homePageRoute

@Composable
fun FileManagerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = HOME_PAGE_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homePageRoute()
    }
}