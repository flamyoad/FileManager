package com.flamyoad.explorer_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.flamyoad.explorer_impl.ui.filelist.FileListScreen
import com.flamyoad.explorer_impl.ui.homepage.HomePageScreen
import kotlinx.serialization.Serializable
import java.io.File

@Serializable
object HomePageRoute

@Serializable
data class FileListRoute(
    val directoryPath: String
)

fun NavGraphBuilder.homePageRoute(onNavigateToFileList: (String) -> Unit) {
    composable<HomePageRoute> {
        HomePageScreen(
            onNavigateToFileList = onNavigateToFileList
        )
    }
}

fun NavGraphBuilder.fileListRoute() {
    composable<FileListRoute> { backstackEntry ->
        val route: FileListRoute = backstackEntry.toRoute()
        FileListScreen(directory = File(route.directoryPath))
    }
}