package com.jfuentes.rickymortyapp.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.IOException

/**
 * Created by Juan Fuentes on 01/07/2021.
 */
class BaseExecutionServiceTest {

    private val dispatcher = Dispatchers.IO

    @Test
    fun `when lambda returns successfully then it should emit the result as success`() {
        runBlocking {
            val result = executeService(dispatcher) { true }
            assertEquals(Result.Success(true), result)
        }
    }

    @Test
    fun `when lambda throws unknown exception then it should emit GenericError`() {
        runBlocking {
            val result = executeService(dispatcher) { throw IllegalStateException() }
            assertEquals(Result.GenericError(), result)
        }
    }

    @Test
    fun `when lambda throws IOException then it should emit the result as NetworkError`() {
        runBlocking {
            val result = executeService(dispatcher) { throw IOException() }
            assertEquals(Result.NetworkError, result)
        }
    }
}