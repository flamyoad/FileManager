package com.flamyoad.explorer_impl.ui.homepage

import android.text.format.Formatter
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.flamyoad.common_ui.widgets.AnimatedProgressIndicator
import java.io.File

@Composable
internal fun HomePageScreen(
    modifier: Modifier = Modifier,
    onNavigateToFileList: (String) -> Unit,
    viewModel: HomePageViewModel = hiltViewModel()
) {
    val rootDirectories by viewModel.rootDirectories.collectAsStateWithLifecycle(initialValue = emptyList())

    Column(modifier = modifier.padding(12.dp)) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(rootDirectories) {
                DirectoryItem(it, onNavigateToFileList)
            }
        }
    }
}

@Composable
private fun DirectoryItem(
    file: File,
    onNavigateToFileList: (String) -> Unit
) {
    Card(
        Modifier
            .fillMaxWidth()
            .clickable { onNavigateToFileList.invoke(file.path) }) {
        val usableSpace = Formatter.formatFileSize(LocalContext.current, file.usableSpace)
        val totalSpace = Formatter.formatFileSize(LocalContext.current, file.totalSpace)

        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Rounded.Folder,
                "Folder",
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(file.path, style = MaterialTheme.typography.titleSmall)
                Spacer(Modifier.height(4.dp))
                AnimatedProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    progress = (file.usableSpace.toFloat() / file.totalSpace),
                    color = Color.Blue.copy(alpha = 0.4f),
                    trackColor = Color.Gray.copy(alpha = 0.5f),
                    animationDuration = 500,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "$usableSpace / $totalSpace",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
