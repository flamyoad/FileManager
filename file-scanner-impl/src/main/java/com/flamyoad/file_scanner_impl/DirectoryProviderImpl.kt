package com.flamyoad.file_scanner_impl

import android.os.Environment
import com.flamyoad.common.CustomDispatcher
import com.flamyoad.file_scanner.DirectoryProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class DirectoryProviderImpl(
    private val dispatcher: CustomDispatcher
): DirectoryProvider {

    override fun rootDirectories(): Flow<List<File>> {
        val dirs = mutableListOf<File>()
        return flow {
            dirs += getInternalStorage()
            emit(dirs)
        }
    }

    // https://developer.android.com/reference/android/os/FileObserver
    override fun observeDir(file: File): Flow<List<File>> {
        return flow {
            val dirs = mutableListOf<File>()
            file.listFiles()?.onEach {
                    dirs += it
                    emit(dirs)
                }
        }.flowOn(dispatcher.io())
    }

    /**
     * SD Card, Mountable USB drives etc, which may be mounted / unmounted at will.
     */
    private fun externalStorage(): Flow<List<File>> {
        return emptyFlow()
    }

    private fun getInternalStorage() = Environment.getExternalStorageDirectory()
}