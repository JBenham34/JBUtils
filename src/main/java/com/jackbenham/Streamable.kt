package com.jackbenham

import java.util.stream.Stream

interface Streamable<T> : HasLength {
    fun stream() : Stream<T>
}