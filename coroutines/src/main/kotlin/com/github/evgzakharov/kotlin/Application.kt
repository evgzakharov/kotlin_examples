package com.github.evgzakharov.kotlin

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    val job1 = launch { one() }
    val job2 = launch { two() }

    println("step 3")

    listOf(job1, job2).forEach { it.join() }
}

suspend fun one(): Unit {
    delay(100)
    println("step 1")
}


suspend fun two(): Unit {
    delay(200)
    println("step 2")
}