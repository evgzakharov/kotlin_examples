package com.github.evgzakharov.kotlin

import java.io.File
import java.nio.file.CopyOption
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun main(args: Array<String>) {
    var ariaStark = 9
    println(ariaStark.whoAreYou)

    ariaStark = 15
    println(ariaStark.whoAreYou)
}

val Int.whoAreYou: String
    get() = if (this < 10) {
        "Aria Stark!"
    } else {
        "Nobody.."
    }

fun File.moveTo(destination: File, override: Boolean = true) {
    val copyOptions: MutableList<CopyOption> = mutableListOf()
    if (override) copyOptions += StandardCopyOption.REPLACE_EXISTING;

    Files.move(this.toPath(), destination.toPath(), *copyOptions.toTypedArray())
}

