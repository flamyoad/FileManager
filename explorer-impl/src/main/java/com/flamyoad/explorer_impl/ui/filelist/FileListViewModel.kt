package com.flamyoad.explorer_impl.ui.filelist

import android.content.Context
import com.flamyoad.common.CustomDispatcher
import com.flamyoad.common.UiState
import com.flamyoad.common_ui.BaseViewModel
import com.flamyoad.file_scanner.DirectoryProvider
import com.flamyoad.file_scanner.FileHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import java.io.File
import javax.inject.Inject

@HiltViewModel
internal class FileListViewModel @Inject constructor(
    private val directoryProvider: DirectoryProvider,
    private val fileHandle: FileHandle,
    private val dispatcher: CustomDispatcher,
) : BaseViewModel() {

    private val currentPath = MutableStateFlow<File?>(null)

    val currentPathFiles: StateFlow<UiState<List<File>>> = currentPath
        .filterNotNull()
        .flowOn(dispatcher.io())
        .flatMapLatest { directoryProvider.observeDir(it) }
        .map<List<File>, UiState<List<File>>> { UiState.Success(it) } // oh no...we shoul;dnt have to
        .catch { emit(UiState.Error(it)) }
        .toStateFlow(initialState = UiState.Loading, started = SharingStarted.Lazily)

    fun initPath(path: File) {
        currentPath.update { path }
    }

    fun openFile(context: Context, file: File) {
        fileHandle.open(context, file)
    }
}