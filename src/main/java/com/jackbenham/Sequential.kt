package com.jackbenham

interface Sequential<T : Sequential<T>> {
    fun next(): T
    fun prev(): T
    fun add(offset: Int): T
}