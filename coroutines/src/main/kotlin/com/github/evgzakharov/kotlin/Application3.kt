package com.github.evgzakharov.kotlin

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    try {
        val result1 = async { action() }
        val result2 = async { failAction() }

        println("run actions")
        val results = listOf(result1.await(), result2.await())
    } catch (e: RuntimeException) {
        e.printStackTrace()
    }
}

suspend fun action(): String {
    delay(300)
    return "action 1"
}


suspend fun failAction(): String {
    delay(150)
    throw RuntimeException("panic")
}