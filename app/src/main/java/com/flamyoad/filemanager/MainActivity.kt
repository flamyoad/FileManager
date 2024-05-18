package com.flamyoad.filemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.flamyoad.common_ui.theme.FileManagerTheme
import com.flamyoad.filemanager.ui.FileManagerApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FileManagerTheme {
                FileManagerApp()
            }
        }
    }
}
