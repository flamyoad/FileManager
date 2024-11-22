package com.flamyoad.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher

interface CustomDispatcher {
    fun ui(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun computation(): CoroutineDispatcher
    fun test(): TestDispatcher
}

class AppCoroutineDispatchers : CustomDispatcher {
    override fun ui(): CoroutineDispatcher = Dispatchers.Main

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun computation(): CoroutineDispatcher = Dispatchers.Default

    override fun test(): TestDispatcher = StandardTestDispatcher()
}

class UnitTestDispatchers: CustomDispatcher {
    private val testDispatcher = StandardTestDispatcher()

    override fun ui(): CoroutineDispatcher = testDispatcher

    override fun io(): CoroutineDispatcher = testDispatcher

    override fun computation(): CoroutineDispatcher = testDispatcher

    override fun test(): TestDispatcher = testDispatcher
}