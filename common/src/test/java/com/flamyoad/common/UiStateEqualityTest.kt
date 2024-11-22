package com.flamyoad.common

import org.junit.Test

import org.junit.Assert.*
import java.io.File

class UiStateEqualityTest {

    @Test
    fun `all error State are equal`() {
        val state1 = UiState.Error()
        val state2 = UiState.Error()
        assertEquals(state1, state2)
    }

    @Test
    fun `success State with different items are not equal`() {
        val fileList1 = listOf(File("/a.txt"), File("/b.txt"))
        val state1 = UiState.Success(fileList1)

        val fileList2 = listOf(File("/a.txt"), File("/c.txt"))
        val state2 = UiState.Success(fileList2)

        assertNotEquals(state1, state2)
    }
}