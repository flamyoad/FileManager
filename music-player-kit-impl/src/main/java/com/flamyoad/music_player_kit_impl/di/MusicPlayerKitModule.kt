package com.flamyoad.music_player_kit_impl.di

import com.flamyoad.music_player_kit.MusicPlayerKit
import com.flamyoad.music_player_kit_impl.MusicPlayerKitImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MusicPlayerKitModule {

    @Binds
    fun bindMusicPlayerKit(musicPlayerKitImpl: MusicPlayerKitImpl): MusicPlayerKit
}