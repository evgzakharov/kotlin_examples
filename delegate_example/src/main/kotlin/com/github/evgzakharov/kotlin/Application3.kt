package com.github.evgzakharov.kotlin

interface Base {
    fun print()
}

class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

class Derived(b: Base) : Base by b

class Derived2 : Base by BaseImpl(3)

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived(b).print() // prints 10
    Derived2().print() // prints 3
}

