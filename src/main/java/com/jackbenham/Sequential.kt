package com.jackbenham

interface Sequential<T : Sequential<T>> {
    fun next(): T = add(1)
    fun prev(): T = add(-1)
    fun add(offset: Int): T
}