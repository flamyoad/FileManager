package com.flamyoad.filemanager.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import java.io.File
import javax.inject.Inject

@HiltViewModel
internal class FileManagerAppViewModel @Inject constructor(
    private val routeManager: RouteManager
): ViewModel() {

    private val historyStack = ArrayDeque<File>()

    val routeStream = routeManager.observeRoute()
        .shareIn(viewModelScope, started = SharingStarted.Lazily)

    private val historyDirectoryFlow = MutableStateFlow<List<File>>(emptyList())
    fun directoryHistoryFlow() = historyDirectoryFlow.asStateFlow()

    fun onMovedToDir(directoryPath: String) {
        val file = File(directoryPath)
        if (historyStack.contains(file)) {
            while (historyStack.isNotEmpty() && historyStack.last() != file) {
                historyStack.removeLast()
            }
        } else {
            historyStack.add(file)
        }
        historyDirectoryFlow.update { historyStack.toList() }
    }

    fun clearHistory() {
        historyStack.clear()
        historyDirectoryFlow.update { emptyList() }
    }
}