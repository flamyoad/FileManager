package com.flamyoad.file_scanner_impl.di

import com.flamyoad.common.BuildConfigWrapper
import com.flamyoad.common.CustomDispatcher
import com.flamyoad.file_scanner.ApkInstaller
import com.flamyoad.file_scanner.DirectoryProvider
import com.flamyoad.file_scanner.FileHandle
import com.flamyoad.file_scanner_impl.ApkInstallerImpl
import com.flamyoad.file_scanner_impl.DirectoryProviderImpl
import com.flamyoad.file_scanner_impl.FileHandleImpl
import com.flamyoad.gallery_kit.GalleryKit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FileScannerModule {

    @Provides
    @Singleton
    fun provideDirectoryProvider(
        dispatcher: CustomDispatcher
    ): DirectoryProvider {
        return DirectoryProviderImpl(dispatcher)
    }

    @Provides
    @Singleton
    fun provideFileHandle(
        apkInstaller: ApkInstaller,
        galleryKit: GalleryKit
    ): FileHandle {
        return FileHandleImpl(apkInstaller, galleryKit)
    }

    @Provides
    @Singleton
    fun provideApkInstaller(
        buildConfigWrapper: BuildConfigWrapper
    ): ApkInstaller {
        return ApkInstallerImpl(buildConfigWrapper)
    }
}