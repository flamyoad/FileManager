package com.flamyoad.filemanager.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
internal fun FileManagerApp(
    navController: NavHostController = rememberNavController(),
    viewModel: FileManagerAppViewModel = hiltViewModel()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route
    Scaffold(
        topBar = {
            CustomTopAppBar(

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

) {
    TopAppBar(
        title = {
            AppBarDirectoryScrollView(
                folders = listOf("Home", "o0o")
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
    folders: List<String>
) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(items = folders) { index, item ->
            TextButton(onClick = {}) {
                Text(item)
            }
            if (index < folders.lastIndex) {
                Icon(Icons.AutoMirrored.Default.ArrowForwardIos, "Next")
//                Icon(Icons.Default.ChevronRight, "To right")
            }
        }
    }
}