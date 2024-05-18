package com.flamyoad.common.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Named
import javax.inject.Qualifier

@Retention(AnnotationRetention.SOURCE)
@Qualifier
annotation class ViewModelCoroutineScope

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelCoroutinesModule {

    @ViewModelCoroutineScope
    @ViewModelScoped
    @Provides
    fun provideViewModelCoroutineScope(): CoroutineScope {
        return CoroutineScope(Dispatchers.Main + SupervisorJob())
    }
}