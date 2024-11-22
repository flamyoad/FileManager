package com.flamyoad.common.di

import com.flamyoad.common.CustomDispatcher
import com.flamyoad.common.AppCoroutineDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CustomDispatcherModule {

    @Provides
    @Singleton
    fun provideCustomDispatcher(): CustomDispatcher {
        return AppCoroutineDispatchers()
    }
}