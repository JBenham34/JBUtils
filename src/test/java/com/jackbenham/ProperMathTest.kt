package com.jackbenham

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProperMathTest {
    @Test
    fun testMod() {
        assertEquals(3, ProperMath.mod(7, 4))
        assertEquals(3, ProperMath.mod(3, 4))
        assertEquals(3, ProperMath.mod(-1, 4))
        assertEquals(3, ProperMath.mod(-5, 4))

        assertEquals(4, ProperMath.mod(9, 5))
        assertEquals(0, ProperMath.mod(5, 5))
        assertEquals(2, ProperMath.mod(-3, 5))
    }
}