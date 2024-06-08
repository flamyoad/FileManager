package com.flamyoad.explorer_impl.ui.filelist

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flamyoad.file_scanner.DirectoryProvider
import com.flamyoad.file_scanner.FileHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import java.io.File
import javax.inject.Inject

@HiltViewModel
internal class FileListViewModel @Inject constructor(
    private val directoryProvider: DirectoryProvider,
    private val fileHandle: FileHandle
) : ViewModel() {

    private val currentPath = MutableStateFlow<File?>(null)

    val currentPathFiles = currentPath
        .filterNotNull()
        .flatMapLatest { directoryProvider.observeDir(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 500),
            initialValue = emptyList(),
        )

    fun initPath(path: File) {
        currentPath.update { path }
    }

    fun openFile(context: Context, file: File) {
        fileHandle.open(context, file)
    }
}