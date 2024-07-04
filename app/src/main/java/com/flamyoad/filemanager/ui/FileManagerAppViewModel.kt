package com.flamyoad.filemanager.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.io.File

internal class FileManagerAppViewModel: ViewModel() {

    private val historyStack = ArrayDeque<File>()

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