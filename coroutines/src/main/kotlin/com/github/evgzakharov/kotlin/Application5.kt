package com.github.evgzakharov.kotlin

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    val channel = Channel<Int>()

    launch(coroutineContext) {
        repeat(100) { index ->
            channel.send(index)
        }
        channel.close()
    }

    launch(coroutineContext) {
        for (value in channel) {
            println(value)
        }
    }

    println("finish")
}
