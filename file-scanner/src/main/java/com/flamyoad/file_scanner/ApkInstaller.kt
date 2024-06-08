package com.flamyoad.file_scanner

import android.content.Context
import java.io.File

interface ApkInstaller {
    fun install(context: Context, file: File)
}