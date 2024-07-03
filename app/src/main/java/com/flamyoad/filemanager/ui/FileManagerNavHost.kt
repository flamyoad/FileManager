package com.flamyoad.filemanager.ui

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.flamyoad.explorer_impl.FileListRoute
import com.flamyoad.explorer_impl.HomePageRoute
import com.flamyoad.explorer_impl.fileListRoute
import com.flamyoad.explorer_impl.homePageRoute

@Composable
fun FileManagerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HomePageRoute,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        modifier = modifier
    ) {
        homePageRoute(
            onNavigateToFileList = { directory ->
                navController.navigate(FileListRoute(directory))
            }
        )
        fileListRoute(
            onNavigateToFileList = { directory ->
                navController.navigate(FileListRoute(directory))
            }
        )
    }
}