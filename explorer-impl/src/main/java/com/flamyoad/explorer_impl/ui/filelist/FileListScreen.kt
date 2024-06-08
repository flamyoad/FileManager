package com.flamyoad.explorer_impl.ui.filelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExtensionOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.flamyoad.common_ui.theme.widgets.DirectoryItem
import com.flamyoad.common_ui.theme.widgets.FileItem
import java.io.File

@Composable
internal fun FileListScreen(
    modifier: Modifier = Modifier,
    path: File,
    onNavigateToFileList: (String) -> Unit,
    viewModel: FileListViewModel = hiltViewModel()
) {
    LaunchedEffect(path) {
        viewModel.initPath(path)
    }

    val files by viewModel.currentPathFiles.collectAsStateWithLifecycle(initialValue = emptyList())
    if (files.isEmpty()) {
        EmptyScreen()
    } else {
        val context = LocalContext.current
        LazyColumn(modifier = modifier) {
            items(files) {
                if (it.isDirectory) {
                    DirectoryItem(file = it, onClick = { file ->
                        onNavigateToFileList(file.path)
                    })
                } else {
                    FileItem(file = it, onClick = { file ->
                        viewModel.openFile(context, file)
                    })
                }
            }
        }
    }
}

@Composable
private fun EmptyScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.ExtensionOff, "No files")
        Spacer(Modifier.height(4.dp))
        Text("No items")
    }
}
