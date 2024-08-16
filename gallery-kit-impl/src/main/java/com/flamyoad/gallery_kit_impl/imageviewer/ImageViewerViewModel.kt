package com.flamyoad.gallery_kit_impl.imageviewer

import com.flamyoad.common.CustomDispatcher
import com.flamyoad.common.UiState
import com.flamyoad.common_ui.BaseViewModel
import com.flamyoad.file_scanner.DirectoryProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.update
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ImageViewerViewModel @Inject constructor(
    private val directoryProvider: DirectoryProvider,
    private val dispatcher: CustomDispatcher
): BaseViewModel() {

    private val currentDirectory = MutableStateFlow<File?>(null)

    val selectedImageIndex = MutableStateFlow<Int?>(null)

    val allPictures: StateFlow<UiState<List<File>>> = currentDirectory
        .filterNotNull()
        .flowOn(dispatcher.io())
        .flatMapLatest { directoryProvider.observeDir(it) }
        .map { UiState.Success(it) as UiState<List<File>> } // oh no...we shoul;dnt have to
        .onCompletion {  }
        .catch { emit(UiState.Error(it)) }
        .toStateFlow(initialState = UiState.Loading)

    fun initDirectory(path: File) {
        currentDirectory.update { path }
    }
}