package com.flamyoad.explorer_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.flamyoad.common.Route
import com.flamyoad.explorer_impl.ui.filelist.FileListScreen
import com.flamyoad.explorer_impl.ui.homepage.HomePageScreen
import kotlinx.serialization.Serializable
import java.io.File

@Serializable
object HomePageRoute

@Serializable
data class FileListRoute(
    val directoryPath: String
): Route

fun NavGraphBuilder.homePageRoute(onNavigateToFileList: (String) -> Unit) {
    composable<HomePageRoute> {
        HomePageScreen(
            onNavigateToFileList = onNavigateToFileList
        )
    }
}

fun NavGraphBuilder.fileListRoute(onNavigateToFileList: (String) -> Unit) {
    composable<FileListRoute> { backstackEntry ->
        val route: FileListRoute = backstackEntry.toRoute()
        FileListScreen(
            path = File(route.directoryPath),
            onNavigateToFileList = onNavigateToFileList
        )
    }
}