package com.github.evgzakharov.kotlin

import java.util.*
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main2(args: Array<String>) {

    val someValue: String by SomeOwnDelegate()

    println(someValue)

    val lazyInitValue: String by lazy {
        println("init")

        "I has been created!"
    }

    println("do you created?")

    println(lazyInitValue)

    var state: Int by Delegates.observable(5) { property, old, new ->
        println("state has been changes, old value: $old, new value: $new")
    }

    state = 10
    state = 12

    println(state)


    val propertyMap = mapOf("userName" to "Vasua", "password" to "Gektor")

    val userName by propertyMap
    val password by propertyMap

    println("userName: $userName; password: $password")

    var ariaStark = 9
    println(ariaStark.whoAreYou)

    ariaStark = 15
    println(ariaStark.whoAreYou)


}

fun main(args: Array<String>) {
    var someMutableValue: String by SomeOwnDelegateMutable("someOtherValue")

    println(someMutableValue)
    someMutableValue = "anotherValue"
    println(someMutableValue)
}

class SomeOwnDelegateMutable(srcValue: String) : ReadWriteProperty<Nothing?, String> {
    private var realValue: String = srcValue
    private fun randomCase() {
        val random = Random().nextBoolean()

        realValue = if (random) {
            realValue.toUpperCase()
        } else {
            realValue.toLowerCase()
        }
    }

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        randomCase()
        return realValue
    }

    override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
        realValue = value
    }
}

data class User(val name: String, val surname: String)

val Int.whoAreYou: String by ExtensionDelegate()

class ExtensionDelegate : ReadOnlyProperty<Int, String> {
    override fun getValue(thisRef: Int, property: KProperty<*>) = if (thisRef < 10) {
        "Aria Stark!"
    } else {
        "Nobody.."
    }
}

class SomeOwnDelegate : ReadOnlyProperty<Nothing?, String> {
    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String = property.name
}
