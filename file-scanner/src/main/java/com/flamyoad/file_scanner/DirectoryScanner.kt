package com.flamyoad.file_scanner

import kotlinx.coroutines.flow.Flow
import java.io.File

interface DirectoryScanner {
    fun rootDirectories(): List<File>

    suspend fun internalStorage(): Flow<List<File>>

    suspend fun externalStorage(): Flow<List<File>>
}