package com.github.evgzakharov.kotlin

import com.github.evgzakharov.java.SimpleUser
import java.io.File

fun main(args: Array<String>) {
    val user = SimpleUser("Vasia", "Pupkin", 12)

    val test: String? = null

    println("0:" + user.prettyPrint())

    val result: SimpleUser = user.apply {
        name = "Bankir"
        surname = "Bankovich"
        age = 55
    }

    println("1:" + user.prettyPrint())
    println("2:" + result.prettyPrint())

    val nameWithSurname = user.let { "name:${it.name} surname: ${it.surname}" }

    println("3:" + nameWithSurname)

    val newUser = user.also { it.age = 120 }

    println("4:" + newUser.prettyPrint())

    val newUserName = user.run { name }

    println("5:" + newUserName)

    val result2: Unit = with(user) {
        name = "Aria"
        surname = "Stark"
        age = 15
    }

    println("6:" + user)

    val users: Map<Int, String> = mapOf(
            1 to "Vasia",
            2 to "Petia",
            3 to "Svetlana"
    )

    val countries: List<String> = listOf("Russia", "Usa")
    val mutableCountries: MutableList<String> = mutableListOf("Russia", "Usa")

    val set: Set<Int> = setOf(1, 2, 3)
    val mutableSet: MutableSet<Int> = mutableSetOf(1, 2, 3)
}

fun SimpleUser.prettyPrint(): String = "name: $name, surname: $surname, age: $age"


class Person {
    var name: String = ""
    var surname: String = ""

    //в явном виде указываем что может не быть адреса
    val address: Address? = null
}


fun userTest() {

    val simpleUser = SimpleUser("", "", 3)

    val any: Any? = null
    when (any) {
        null -> println("null")
        is Person -> println("person name: ${any.name}")
        else -> print("else")
    }

}


class Address {
    val street: String = ""
}