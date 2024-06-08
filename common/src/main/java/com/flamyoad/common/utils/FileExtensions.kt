package com.flamyoad.common.utils

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap
import java.io.File

fun File.isApk(): Boolean = extension == "apk"

fun File.getApkIcon(context: Context): Bitmap? {
    val packageManager = context.packageManager
    val packageInfo = packageManager.getPackageArchiveInfo(this.path, 0)
            ?: return null

    packageInfo.applicationInfo.sourceDir = this.path
    packageInfo.applicationInfo.publicSourceDir = this.path

    return packageInfo.applicationInfo.loadIcon(packageManager).toBitmap()
}