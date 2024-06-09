package com.jackbenham

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SequentialTest {
    @Test
    fun testNext() {
        assertEquals(ExampleIntSequential(1), ExampleIntSequential(0).next())
        assertEquals(ExampleIntSequential(2), ExampleIntSequential(1).next())
        assertEquals(ExampleIntSequential(3), ExampleIntSequential(2).next())
        assertEquals(ExampleIntSequential(4), ExampleIntSequential(3).next())
        assertEquals(ExampleIntSequential(5), ExampleIntSequential(4).next())
        assertEquals(ExampleIntSequential(-9), ExampleIntSequential(-10).next())
        assertEquals(ExampleIntSequential(0), ExampleIntSequential(-1).next())
        assertEquals(ExampleIntSequential(1), ExampleIntSequential(0).next())
        assertEquals(ExampleIntSequential(3), ExampleIntSequential(1).next().next())
    }

    @Test
    fun testPrev() {
        assertEquals(ExampleIntSequential(0), ExampleIntSequential(1).prev())
        assertEquals(ExampleIntSequential(1), ExampleIntSequential(2).prev())
        assertEquals(ExampleIntSequential(2), ExampleIntSequential(3).prev())
        assertEquals(ExampleIntSequential(3), ExampleIntSequential(4).prev())
        assertEquals(ExampleIntSequential(4), ExampleIntSequential(5).prev())
        assertEquals(ExampleIntSequential(-10), ExampleIntSequential(-9).prev())
        assertEquals(ExampleIntSequential(-1), ExampleIntSequential(0).prev())
        assertEquals(ExampleIntSequential(0), ExampleIntSequential(1).prev())
        assertEquals(ExampleIntSequential(1), ExampleIntSequential(3).prev().prev())
    }



    class ExampleIntSequential(private val i_: Int) : Sequential<ExampleIntSequential> {
        @Suppress("TestFunctionName")
        override fun add(offset: Int): ExampleIntSequential {
            return ExampleIntSequential(i_ + offset)
        }

        @Suppress("TestFunctionName")
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            other as ExampleIntSequential
            return i_ == other.i_
        }

        @Suppress("TestFunctionName")
        override fun hashCode(): Int {
            return i_
        }
    }
}
