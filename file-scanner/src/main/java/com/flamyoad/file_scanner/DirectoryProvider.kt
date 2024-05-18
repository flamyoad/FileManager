package com.flamyoad.file_scanner

import kotlinx.coroutines.flow.Flow
import java.io.File

interface DirectoryProvider {
    fun rootDirectories(): Flow<List<File>>

    fun observeDir(file: File): Flow<List<File>>
}