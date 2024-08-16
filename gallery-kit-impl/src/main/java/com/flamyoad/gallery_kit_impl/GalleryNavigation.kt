package com.flamyoad.gallery_kit_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.flamyoad.common.Route
import com.flamyoad.gallery_kit_impl.imageviewer.ImageViewerScreen
import kotlinx.serialization.Serializable
import java.io.File

@Serializable
data class ImageViewerRoute(
    val directoryPath: String,
    val selectedPicture: String
): Route

fun NavGraphBuilder.imageViewerRoute() {
    composable<ImageViewerRoute> {
        val route: ImageViewerRoute = it.toRoute()
        ImageViewerScreen(
            currentDirectory = File(route.directoryPath),
            selectedPicture = File(route.selectedPicture)
        )
    }
}