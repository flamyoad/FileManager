package com.flamyoad.explorer_impl.ui.filelist

import android.content.Context
import com.flamyoad.common.CustomDispatcher
import com.flamyoad.common.UiState
import com.flamyoad.common_ui.BaseViewModel
import com.flamyoad.file_scanner.DirectoryProvider
import com.flamyoad.file_scanner.FileHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
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

    /**
     *  https://bladecoder.medium.com/smarter-shared-kotlin-flows-d6b75fc66754
     *  https://bladecoder.medium.com/smarter-shared-kotlin-flows-d6b75fc66754
     *  https://medium.com/androiddevelopers/consuming-flows-safely-in-jetpack-compose-cde014d0d5a3
     *
     *  By using below!!!!
     *  UI: collectAsStateWithLifecycle
     *  ViewModel: SharingStarted.Lazily
     *
     *  When user exits screen for 5s, UIs can stop collecting flow, but we must not let VM restart the expensive flow,
     *  Because this is a Flow<List<T>>, we need em to keep pumping data like slaves/
     */
    val currentPathFiles: StateFlow<UiState<List<File>>> = currentPath
        .filterNotNull()
        .flowOn(dispatcher.io())
        .flatMapLatest { directoryProvider.observeDir(it) }
        .map<List<File>, UiState<List<File>>> { UiState.Success(it) } // oh no...we shoul;dnt have to
        .catch { emit(UiState.Error(it)) }
        .toStateFlow(
            initialState = UiState.Loading,
            started = SharingStarted.Lazily // ?? does each viewmodel survive composabble
//            started = SharingStarted.WhileSubscribed(100)
        )

    fun currentPathFiles(): Flow<UiState<List<File>>> = currentPathFiles

    fun initPath(path: File) {
        currentPath.update { path }
    }

    fun openFile(context: Context, file: File) {
        fileHandle.open(context, file)
    }

    // OH NO, VIEWMODEL FROM 1ST COMPOSABLE IS STILL ALIVE IF THE SAME COMPOSABLE IS OPENED 2ND TIME AND STACKED ON TOP.
    override fun onCleared() {
        super.onCleared()
    }
}