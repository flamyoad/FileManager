package com.flamyoad.explorer_impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flamyoad.common.di.ViewModelCoroutineScope
import com.flamyoad.file_scanner.DirectoryProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import java.io.File
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
internal class HomePageViewModel @Inject constructor(
    private val directoryProvider: DirectoryProvider,
    @ViewModelCoroutineScope vmCoroutineScope: CoroutineScope,
) : ViewModel(vmCoroutineScope) {

    val rootDirectories: StateFlow<List<File>> = directoryProvider.rootDirectories()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = emptyList(),
       )
}