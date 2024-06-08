package com.flamyoad.common_ui.theme.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TextSnippet
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.flamyoad.common.utils.getApkIcon
import com.flamyoad.common.utils.isApk
import java.io.File

@Composable
fun FileItem(
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
        FileIcon(modifier = Modifier.size(iconSize), file)
        Spacer(Modifier.width(12.dp))
        Text(file.name)
    }
}

@Composable
private fun FileIcon(modifier: Modifier, file: File) {
    when {
        file.isApk() -> {
            val apkIcon = file.getApkIcon(LocalContext.current)
            if (apkIcon != null) {
                Image(apkIcon.asImageBitmap(), file.nameWithoutExtension, modifier)
            } else {
                Icon(Icons.Default.Android, file.nameWithoutExtension, modifier)
            }
        }
        else -> {
            Icon(Icons.AutoMirrored.Filled.TextSnippet, file.name, modifier)
        }
    }
}