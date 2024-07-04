package com.flamyoad.filemanager.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.flamyoad.explorer_impl.FileListRoute
import com.flamyoad.explorer_impl.HomePageRoute
import java.io.File

@Composable
internal fun FileManagerApp(
    navController: NavHostController = rememberNavController(),
    viewModel: FileManagerAppViewModel = hiltViewModel()
) {

    navController.addOnDestinationChangedListener { controller, currentDestination, _ ->
        // Route, NavDestination, NavBackStackEntry?? fwhat the fuck
        if (currentDestination.hasRoute(FileListRoute::class)) {
            val route = controller.currentBackStackEntry?.toRoute<FileListRoute>()
                ?: return@addOnDestinationChangedListener
            viewModel.onMovedToDir(route.directoryPath)
        } else if (currentDestination.hasRoute(HomePageRoute::class)) {
            viewModel.clearHistory()
        }
    }

    val history by viewModel.directoryHistoryFlow().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CustomTopAppBar(
                directoryHistory = history,
                onNavigateToDirectory = {
                    navController.popBackStack(FileListRoute(it.path), inclusive = false)
                },
                onNavigateToHome = {
                    navController.popBackStack(HomePageRoute, inclusive = false)
                }
            )
        }
    ) { innerPadding ->
        FileManagerNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
private fun CustomTopAppBar(
    directoryHistory: List<File>,
    onNavigateToDirectory: (File) -> Unit,
    onNavigateToHome: () -> Unit
) {
    TopAppBar(
        title = {
            AppBarDirectoryScrollView(
                folders = directoryHistory,
                onNavigateToDirectory = onNavigateToDirectory,
                onNavigateToHome = onNavigateToHome,
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More Vert")
            }
        }
    )
}

@Composable
private fun AppBarDirectoryScrollView(
    folders: List<File>,
    onNavigateToDirectory: (File) -> Unit,
    onNavigateToHome: () -> Unit
) {
    val lazyListState = rememberLazyListState()
    LaunchedEffect(folders) {
        lazyListState.animateScrollToItem(lazyListState.layoutInfo.totalItemsCount)
    }

    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        state = lazyListState
    ) {
        item {
            TextButton(onClick = { onNavigateToHome() }) {
                Text("Home")
            }
            if (folders.isNotEmpty()) {
                Icon(Icons.AutoMirrored.Default.ArrowForwardIos, "Next")
            }
        }
        itemsIndexed(items = folders) { index, item ->
            TextButton(onClick = { onNavigateToDirectory(item) }) {
                Text(item.name)
            }
            if (index < folders.lastIndex) {
                Icon(Icons.AutoMirrored.Default.ArrowForwardIos, "Next")
//                Icon(Icons.Default.ChevronRight, "To right")
            }
        }
    }
}