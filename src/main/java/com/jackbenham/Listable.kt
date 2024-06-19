package com.jackbenham

interface Listable<T> : HasLength {
    fun list() : List<T>
}