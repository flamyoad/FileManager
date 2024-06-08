package com.flamyoad.common.di

import com.flamyoad.common.BuildConfigWrapper
import com.flamyoad.common.BuildConfigWrapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BuildConfigModule {

    @Provides
    @Singleton
    fun provideBuildWrapper(): BuildConfigWrapper {
        return BuildConfigWrapperImpl()
    }
}