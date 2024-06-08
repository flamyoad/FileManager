package com.flamyoad.file_scanner

import android.content.Context
import java.io.File

interface FileHandle {

    fun open(context: Context, file: File)

    fun move(oldFile: File, newFile: File)

    fun copy(oldFile: File, newFile: File)

    fun delete(file: File)
}