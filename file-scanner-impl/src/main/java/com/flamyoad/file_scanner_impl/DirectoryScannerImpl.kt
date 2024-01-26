package com.flamyoad.file_scanner_impl

import android.os.Environment
import com.flamyoad.file_scanner.DirectoryScanner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class DirectoryScannerImpl: DirectoryScanner {

    override fun rootDirectories(): List<File> {
        return listOf(
            getInternalStorage()
        )
    }

    override suspend fun internalStorage(): Flow<List<File>> {
        return flow {
            val dirs = mutableListOf<File>()
            getInternalStorage().listFiles()
                ?.filter { it.isDirectory }
                ?.onEach {
                    dirs += it
                    emit(dirs)
                }
        }.flowOn(Dispatchers.IO) // todo: inject instead of hardcoding
    }

    /**
     * SD Card, Mountable USB drives etc
     */
    override suspend fun externalStorage(): Flow<List<File>> {
        TODO("Not yet implemented")
    }

    internal fun getInternalStorage() = Environment.getExternalStorageDirectory()
}