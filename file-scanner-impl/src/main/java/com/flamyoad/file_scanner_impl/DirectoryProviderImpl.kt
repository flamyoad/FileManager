package com.flamyoad.file_scanner_impl

import android.os.Environment
import com.flamyoad.common.CustomDispatcher
import com.flamyoad.file_scanner.DirectoryProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class DirectoryProviderImpl(
    val dispatcher: CustomDispatcher
): DirectoryProvider {

    override fun rootDirectories(): List<File> {
        return listOf(
            getInternalStorage()
        )
    }

    override fun internalStorage(): Flow<List<File>> {
        return flow {
            val dirs = mutableListOf<File>()
            getInternalStorage().listFiles()
                ?.filter { it.isDirectory }
                ?.onEach {
                    dirs += it
                    emit(dirs)
                }
        }.flowOn(dispatcher.io())
    }

    /**
     * SD Card, Mountable USB drives etc
     */
    override fun externalStorage(): Flow<List<File>> {
        TODO("Not yet implemented")
    }

    private fun getInternalStorage() = Environment.getExternalStorageDirectory()
}