package com.flamyoad.explorer_impl.ui.filelist

import androidx.lifecycle.ViewModel
import com.flamyoad.file_scanner.DirectoryProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class FileListViewModel @Inject constructor(
    private val directoryProvider: DirectoryProvider
): ViewModel() {



}