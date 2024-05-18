package com.flamyoad.explorer_impl.ui

import android.os.Environment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flamyoad.file_scanner.DirectoryProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import java.io.File
import javax.inject.Inject

@HiltViewModel
internal class HomePageViewModel @Inject constructor(
    private val directoryProvider: DirectoryProvider
) : ViewModel() {

    val rootDirectories: StateFlow<List<File>> = directoryProvider.rootDirectories()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList(),
       )
}