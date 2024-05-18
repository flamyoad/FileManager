package com.flamyoad.explorer_impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.io.File

@Composable
internal fun HomePageScreen(
    modifier: Modifier = Modifier,
    viewModel: HomePageViewModel = hiltViewModel()
) {
    val rootDirectories by viewModel.rootDirectories.collectAsStateWithLifecycle(initialValue = emptyList())

    Column(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(rootDirectories) {
                DirectoryItem(it)
            }
        }
    }
}

@Composable
private fun DirectoryItem(file: File) {
    Row {
        Text(file.path, style = MaterialTheme.typography.headlineSmall)
    }
}