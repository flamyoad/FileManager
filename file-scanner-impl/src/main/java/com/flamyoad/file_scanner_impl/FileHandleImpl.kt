package com.flamyoad.file_scanner_impl

import android.content.Context
import com.flamyoad.common.utils.isApk
import com.flamyoad.file_scanner.ApkInstaller
import com.flamyoad.file_scanner.FileHandle
import java.io.File

class FileHandleImpl(
    private val apkInstaller: ApkInstaller
) : FileHandle {

    override fun open( context: Context, file: File) {
        when {
            file.isApk() -> apkInstaller.install(context, file)
        }
    }

    override fun move(oldFile: File, newFile: File) {
        TODO("Not yet implemented")
    }

    override fun copy(oldFile: File, newFile: File) {
        TODO("Not yet implemented")
    }

    override fun delete(file: File) {
        TODO("Not yet implemented")
    }
}