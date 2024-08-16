package com.flamyoad.common_ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.io.File

@Composable
fun DirectoryItem(
    modifier: Modifier = Modifier,
    file: File,
    onClick: (File) -> Unit,
    iconSize: Dp = 24.dp
) {
    Row(
        modifier = modifier
            .clickable { onClick.invoke(file) }
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Rounded.Folder,
            "Directory",
            modifier = Modifier.size(iconSize)
        )
        Spacer(Modifier.width(12.dp))
        Text(file.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}