package com.flamyoad.gallery_kit_impl.di

import com.flamyoad.gallery_kit.GalleryKit
import com.flamyoad.gallery_kit_impl.GalleryKitImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GalleryModule {

    @Provides
    @Singleton
    fun provideGalleryKit(): GalleryKit {
        return GalleryKitImpl()
    }
}