package com.jackbenham

interface Builder<T> {
    fun build() : T?
}