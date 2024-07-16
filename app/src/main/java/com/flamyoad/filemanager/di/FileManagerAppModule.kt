package com.flamyoad.filemanager.di

import com.flamyoad.common.RouteEmitter
import com.flamyoad.common.RouteObserver
import com.flamyoad.filemanager.ui.RouteManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface FileManagerAppModule {

    @Binds
    fun bindRouteObserver(routeManager: RouteManager): RouteObserver

    @Binds
    fun bindRouteEmitter(routeManager: RouteManager): RouteEmitter

    companion object {
        @Provides
        @Singleton
        fun provideRouteManager(): RouteManager = RouteManager()
    }
}