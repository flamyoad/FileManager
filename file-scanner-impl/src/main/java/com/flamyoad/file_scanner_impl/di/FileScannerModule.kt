package com.flamyoad.file_scanner_impl.di

import com.flamyoad.file_scanner.DirectoryScanner
import com.flamyoad.file_scanner_impl.DirectoryScannerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GalleryModule {

    @Provides
    fun provideDirScanner(): DirectoryScanner {
        return DirectoryScannerImpl()
    }
}