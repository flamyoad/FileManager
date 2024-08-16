package com.flamyoad.filemanager.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.dropUnlessResumed
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.flamyoad.common.Route
import com.flamyoad.explorer_impl.FileListRoute
import com.flamyoad.explorer_impl.HomePageRoute
import com.flamyoad.explorer_impl.fileListRoute
import com.flamyoad.explorer_impl.homePageRoute
import com.flamyoad.gallery_kit_impl.imageViewerRoute

@Composable
fun FileManagerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HomePageRoute,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(500)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tween(500)
            )
        },
        modifier = modifier
    ) {
        homePageRoute(
            onNavigateToFileList = { directory ->
                navController.navigateSafely(FileListRoute(directory))
            }
        )
        fileListRoute(
            onNavigateToFileList = { directory ->
                navController.navigateSafely(FileListRoute(directory))
            }
        )
        imageViewerRoute()
    }
}

// dropUnlessResumed is used to avoid navigating multiple times to the same destination or
// popping the backstack when the destination is already on top.
// https://github.com/seve-andre/jetpack-compose-template/pull/37
//@Composable
//fun NavController.navigateTo(
//    route: Route,
//): () -> Unit = dropUnlessResumed { this.navigate(route) }


// https://slack-chats.kotlinlang.org/t/18829110/hey-guys-i-m-trying-to-wrap-my-head-around-the-new-dropunles
// https://github.com/HedvigInsurance/android/blob/develop/app%2Fapp%2Fsrc%2Fmain%2Fkotlin%2Fcom%2Fhedvig%2Fandroid%2Fapp%2Fnavigation%2FRememberNavigator.kt#L20-L28
// Pros: Doesn't require @Composable context
fun NavController.navigateSafely(route: Route) {
    val currentBackStackEntry = this.currentBackStackEntry ?: return
    if (currentBackStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
        this.navigate(route)
    }
}