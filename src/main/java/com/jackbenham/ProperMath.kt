package com.jackbenham

object ProperMath {
    fun mod(a: Int, b: Int): Int {
        require(b > 0) { "The divisor (b) must be positive." }

        var result = a % b
        if (result < 0) result += b
        return result
    }
}