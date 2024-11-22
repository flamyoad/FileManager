package com.flamyoad.explorer_impl

import android.content.Context
import app.cash.turbine.test
import com.flamyoad.common.CustomDispatcher
import com.flamyoad.common.UiState
import com.flamyoad.common.UnitTestDispatchers
import com.flamyoad.explorer_impl.ui.filelist.FileListViewModel
import com.flamyoad.file_scanner.DirectoryProvider
import com.flamyoad.file_scanner.FileHandle
import com.flamyoad.test_shared.MainDispatcherRule
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.io.File

class FileListViewModelTest {
    private val testDispatchers = UnitTestDispatchers()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(testDispatchers.test())

    private val directoryProvider: DirectoryProvider = mock()
    private val fileHandle: FileHandle = mock()

    private lateinit var viewModel: FileListViewModel

    @Before
    fun setup() {
        viewModel = FileListViewModel(directoryProvider, fileHandle, testDispatchers)
    }

    @Test
    fun currentPathFiles() {
        val path = File("/")
        val directories = listOf(File("a"), File("b"))
        whenever(directoryProvider.observeDir(path))
            .thenReturn(flowOf(directories))

        runTest {
            viewModel.currentPathFiles.test {
                assertEquals(UiState.Loading, awaitItem())
                viewModel.initPath(path)
                assertEquals(UiState.Success(directories), awaitItem())
            }
        }
    }

    @Test
    fun openFile() {
        val context: Context = mock()
        val file = File("/")
        viewModel.openFile(context, file)
        verify(fileHandle).open(context, file)
    }
}