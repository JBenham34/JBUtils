package com.jackbenham

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

class SequentialFiniteTest {
    @Test
    fun testNext() {
        assertEquals(ExampleIntSequentialFinite(1), ExampleIntSequentialFinite(0).next())
        assertEquals(ExampleIntSequentialFinite(2), ExampleIntSequentialFinite(1).next())
        assertEquals(ExampleIntSequentialFinite(3), ExampleIntSequentialFinite(2).next())
        assertEquals(ExampleIntSequentialFinite(4), ExampleIntSequentialFinite(3).next())
        assertEquals(ExampleIntSequentialFinite(5), ExampleIntSequentialFinite(4).next())
        assertEquals(ExampleIntSequentialFinite(1), ExampleIntSequentialFinite(0).next())
        assertEquals(ExampleIntSequentialFinite(3), ExampleIntSequentialFinite(1).next().next())
    }

    @Test
    fun testPrev() {
        assertEquals(ExampleIntSequentialFinite(0), ExampleIntSequentialFinite(1).prev())
        assertEquals(ExampleIntSequentialFinite(1), ExampleIntSequentialFinite(2).prev())
        assertEquals(ExampleIntSequentialFinite(2), ExampleIntSequentialFinite(3).prev())
        assertEquals(ExampleIntSequentialFinite(3), ExampleIntSequentialFinite(4).prev())
        assertEquals(ExampleIntSequentialFinite(4), ExampleIntSequentialFinite(5).prev())
        assertEquals(ExampleIntSequentialFinite(0), ExampleIntSequentialFinite(1).prev())
        assertEquals(ExampleIntSequentialFinite(1), ExampleIntSequentialFinite(3).prev().prev())
    }

    @Test
    fun testHasNext() {
        assertTrue(ExampleIntSequentialFinite(0).hasNext())
        assertTrue(ExampleIntSequentialFinite(1).hasNext())
        assertTrue(ExampleIntSequentialFinite(2).hasNext())
        assertTrue(ExampleIntSequentialFinite(8).hasNext())
        assertTrue(ExampleIntSequentialFinite(9).hasNext())
        assertFalse(ExampleIntSequentialFinite(10).hasNext())
    }

    @Test
    fun testHasPrev() {
        assertFalse(ExampleIntSequentialFinite(0).hasPrev())
        assertTrue(ExampleIntSequentialFinite(1).hasPrev())
        assertTrue(ExampleIntSequentialFinite(2).hasPrev())
        assertTrue(ExampleIntSequentialFinite(8).hasPrev())
        assertTrue(ExampleIntSequentialFinite(9).hasPrev())
        assertTrue(ExampleIntSequentialFinite(10).hasPrev())
    }

    class ExampleIntSequentialFinite(private val i_: Int) : SequentialFinite<ExampleIntSequentialFinite> {
        @Suppress("TestFunctionName")
        override fun add(offset: Int): ExampleIntSequentialFinite {
            return ExampleIntSequentialFinite(max(min( i_ + offset, 10), 0))
        }

        @Suppress("TestFunctionName")
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            other as ExampleIntSequentialFinite
            return i_ == other.i_
        }

        @Suppress("TestFunctionName")
        override fun hashCode(): Int {
            return i_
        }

        @Suppress("TestFunctionName")
        override fun first(): ExampleIntSequentialFinite = ExampleIntSequentialFinite(0)

        @Suppress("TestFunctionName")
        override fun last(): ExampleIntSequentialFinite = ExampleIntSequentialFinite(10)
    }
}
