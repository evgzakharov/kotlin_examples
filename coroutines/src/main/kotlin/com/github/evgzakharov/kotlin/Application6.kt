package com.github.evgzakharov.kotlin

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.Channel

data class WaitingTask(
        val url: String
)

data class ProcessingTask(
        val url: String,
        val source: String
)

data class FinishTask(
        val url: String,
        val source: String,
        val someOtherInfo: String
)

fun main(args: Array<String>) = runBlocking {
    val sqlThreads = 4
    val processThreads = 8

    val sqlContext = newFixedThreadPoolContext(sqlThreads, "sql-context")
    val processingContext = newFixedThreadPoolContext(processThreads, "process-context")

    val waitingTasksChannel = Channel<WaitingTask>()
    val processingTasksChannel = Channel<ProcessingTask>()
    val finishTasksChannel = Channel<FinishTask>()

    //emulate task sending
    val schedulingTask = launch {
        println("starting ${this.coroutineContext}")

        for (i in 1..1000) {
            waitingTasksChannel.send(WaitingTask("some new url $i"))
        }
    }

    //run 8 parallel execution task
    val processingTasks = (1..processThreads).map {
        launch(processingContext) {
            println("starting ${this.coroutineContext}")

            for (waitTask in waitingTasksChannel) {
                val processResult = downloadPage(waitTask)

                processingTasksChannel.send(processResult)
            }
        }
    }

    //run 4 parallel execution sql task
    val sqlTasks = (1..sqlThreads).map {
        launch(sqlContext) {
            println("starting ${this.coroutineContext}")

            for (processTask in processingTasksChannel) {
                val processResult = processTask(processTask)

                finishTasksChannel.send(processResult)
            }
        }
    }

    //run finish task
    val finishTask = launch {
        for (finishTask in finishTasksChannel) {
            println(finishTask)
        }
    }

    schedulingTask.join()
    waitingTasksChannel.close()

    processingTasks.forEach { it.join() }
    processingTasksChannel.close()

    sqlTasks.forEach { it.join() }
    finishTasksChannel.close()

    finishTask.join()
}

private fun processTask(processingTask: ProcessingTask): FinishTask {
    return FinishTask(processingTask.url, processingTask.source, "some other info")
}

private fun downloadPage(waitTask: WaitingTask): ProcessingTask {
    return ProcessingTask(waitTask.url, "source ${waitTask.url}")
}