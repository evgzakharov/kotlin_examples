package com.github.evgzakharov.kotlin

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    val result1 = async { action1() }
    val result2 = async { action2() }

    println("run acitions")

    val results = listOf(result1.await(), result2.await())

    println(results)
}

suspend fun action1(): String {
    delay(100)
    return "action 1"
}


suspend fun action2(): String {
    delay(200)
    return "action 2"
}