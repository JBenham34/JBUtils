package com.jackbenham

interface KeyedCreator<K, V : Keyed<K>> {
    fun fromKey(key : K) : V?
}