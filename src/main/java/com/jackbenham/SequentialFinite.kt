package com.jackbenham

interface SequentialFinite<T : SequentialFinite<T>> : Sequential<T> {
    fun first(): T
    fun last(): T
    fun hasNext(): Boolean
    fun hasPrev(): Boolean
}