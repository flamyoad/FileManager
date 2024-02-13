package com.flamyoad.file_scanner

import kotlinx.coroutines.flow.Flow
import java.io.File

interface DirectoryProvider {
    fun rootDirectories(): List<File>

    fun internalStorage(): Flow<List<File>>

    fun externalStorage(): Flow<List<File>>
}