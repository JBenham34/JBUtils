package com.jackbenham

import java.util.stream.Stream

interface Streamable<T> {
    fun stream() : Stream<T>
}