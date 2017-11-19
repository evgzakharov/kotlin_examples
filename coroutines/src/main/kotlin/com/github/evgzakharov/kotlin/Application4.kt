//package com.github.evgzakharov.kotlin
//
//import kotlinx.coroutines.experimental.*
//import java.util.concurrent.TimeUnit
//import java.util.concurrent.TimeoutException
//
//fun main(args: Array<String>) = runBlocking {
//    try {
//        //or withTimeoutOrNull
//        val result = withTimeout(300, TimeUnit.MILLISECONDS) {
//            someAction()
//        }
//
//        println("result: $result")
//    } catch (e: TimeoutCancellationException) {
//        e.printStackTrace()
//    }
//}
//
//suspend fun someAction(): String {
//    delay(1000)
//    return "action 1"
//}
