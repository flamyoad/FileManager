package com.flamyoad.explorer_impl.ui.filelist

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
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
import com.flamyoad.common_ui.widgets.DirectoryItem
import com.flamyoad.common_ui.widgets.FileItem
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import com.flamyoad.common.UiState
import com.flamyoad.common_ui.LoadingScreen
import java.io.File

@Composable
internal fun FileListScreen(
    modifier: Modifier = Modifier,
    path: File,
    onNavigateToFileList: (String) -> Unit,
    viewModel: FileListViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val fileListUiState by viewModel.currentPathFiles.collectAsStateWithLifecycle()

    var hasError by remember { mutableStateOf(false) }

    LaunchedEffect(path) {
        viewModel.initPath(path)
    }

    LaunchedEffect(hasError) {
        if (hasError) {
            Toast.makeText(context, "Error occurred", Toast.LENGTH_SHORT).show()
        }
        hasError = false
    }

    // https://stackoverflow.com/questions/69558033/kotlin-error-smart-cast-to-x-is-impossible-because-state-is-a-property-that
    when (val state = fileListUiState) {
        is UiState.Loading -> {
            LoadingScreen()
        }
        is UiState.Error -> {
            hasError = true
        }
        is UiState.Success -> {
            val files = state.value
            if (files.isEmpty()) {
                EmptyScreen() // todo swiperefreshlayout
            }
            LazyColumn(modifier = modifier) {
//                items(files, key = { file -> file.path }) {
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
        else -> {}
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