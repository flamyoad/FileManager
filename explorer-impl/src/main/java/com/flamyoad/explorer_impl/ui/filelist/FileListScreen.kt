package com.flamyoad.explorer_impl.ui.filelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.flamyoad.explorer_impl.ui.homepage.HomePageViewModel
import java.io.File

@Composable
internal fun FileListScreen(
    modifier: Modifier = Modifier,
    directory: File,
    viewModel: HomePageViewModel = hiltViewModel()
) {

    Column(modifier = modifier.padding(12.dp)) {
        Text(directory.name)
    }
}