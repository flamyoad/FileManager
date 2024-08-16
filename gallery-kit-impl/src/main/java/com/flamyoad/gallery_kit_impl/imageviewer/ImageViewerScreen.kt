package com.flamyoad.gallery_kit_impl.imageviewer

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import java.io.File

@Composable
internal fun ImageViewerScreen(
    modifier: Modifier = Modifier,
    viewModel: ImageViewerViewModel = hiltViewModel(),
    currentDirectory: File,
    selectedPicture: File,
) {

    LaunchedEffect(currentDirectory) {
        viewModel.initDirectory(currentDirectory)
    }

    val pagerState = rememberPagerState(pageCount = {
        10
    })

    HorizontalPager(state = pagerState) { page ->
        Text(text = page.toString())
    }

}