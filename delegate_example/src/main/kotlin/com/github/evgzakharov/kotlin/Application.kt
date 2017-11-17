package com.github.evgzakharov.kotlin

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main(args: Array<String>) {

    val someValue: String by SomeOwnDelegate("value")

    println(someValue)
}

class SomeOwnDelegate(private val srcValue: String) : ReadOnlyProperty<Nothing?, String> {
    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        println(property)

        return srcValue.toUpperCase()
    }
}
