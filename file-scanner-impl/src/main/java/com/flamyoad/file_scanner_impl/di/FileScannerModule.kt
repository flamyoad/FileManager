package com.flamyoad.file_scanner_impl.di

import com.flamyoad.common.CustomDispatcher
import com.flamyoad.file_scanner.DirectoryProvider
import com.flamyoad.file_scanner_impl.DirectoryProviderImpl
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
    fun provideDirectoryProvider(dispatcher: CustomDispatcher): DirectoryProvider {
        return DirectoryProviderImpl(dispatcher)
    }
}