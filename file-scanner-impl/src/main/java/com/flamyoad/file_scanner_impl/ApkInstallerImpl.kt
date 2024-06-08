package com.flamyoad.file_scanner_impl

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.content.FileProvider
import com.flamyoad.common.BuildConfigWrapper
import com.flamyoad.file_scanner.ApkInstaller
import java.io.File

class ApkInstallerImpl(
    private val buildConfigWrapper: BuildConfigWrapper
) : ApkInstaller {

    @SuppressLint("NewApi")
    override fun install(context: Context, file: File) {
        if (!file.exists()) {
            return
        }

        if (buildConfigWrapper.sdkInt() >= Build.VERSION_CODES.O) {
            // For Android 8.0 and above, Ask for permission to install from unknown sources
            if (!context.packageManager.canRequestPackageInstalls()) {
                val installUnknownAppsIntent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES).apply {
                    data = Uri.parse("package:${context.packageName}")
                }
                // Better UX is to show a custom popup explaining this rationale, in that popup's CTA, we start intent to Settings
                // but that will be for another day.
                context.startActivity(installUnknownAppsIntent)
            } else {
                val fileUri = FileProvider.getUriForFile(context, "com.flamyoad.filemanager.fileprovider", file)
                val intent = Intent(Intent.ACTION_VIEW, fileUri).apply {
                    putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true)
                    setDataAndType(fileUri, "application/vnd.android.package-archive")
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                context.startActivity(intent)
            }
        } else if (buildConfigWrapper.sdkInt() >= Build.VERSION_CODES.N) {
            // Android 7.0 & Android 7.1, FileUriExposedException, so FileProvider is needed.
            val fileUri = FileProvider.getUriForFile(context, "com.flamyoad.filemanager.fileprovider", file)
            val intent = Intent(Intent.ACTION_VIEW, fileUri).apply {
                setDataAndType(fileUri, "application/vnd.android.package-archive")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(intent)
        } else {
            // Android 6 and below
            val uri = Uri.fromFile(file)
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(
                    uri,
                    "application/vnd.android.package-archive"
                )
            }
            context.startActivity(intent)
        }
    }
}