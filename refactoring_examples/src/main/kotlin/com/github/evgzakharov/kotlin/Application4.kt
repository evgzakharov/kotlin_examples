package com.github.evgzakharov.kotlin

import com.github.evgzakharov.java.SimpleUser

fun main(args: Array<String>) {
    val user = SimpleUser("Vasia", "Pupkin", 12)

    val test: String? = null

    test!!

    println("1:" + user.prettyPrint())

    val result: SimpleUser = user.apply {
        name = "Bankir"
        surname = "Bankovich"
        age = 55
    }

    println("2:" + user.prettyPrint())
    println("3:" + result.prettyPrint())

    val nameWithSurname = user.let { "name:${it.name} surname: ${it.surname}" }

    println("4:" + nameWithSurname)

    val newUser = user.also { it.age = 120 }

    println("5:" + newUser.prettyPrint())

    val newUserName = user.run { name }

    println("6:" + newUserName)

    val result2: Unit = with(user) {
        name = "Aria"
        surname = "Stark"
        age = 15
    }

    println("7:" + user)
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
    when(any) {
        null -> println("null")
        is Person -> println("person name: ${any.name}")
        else -> print("else")
    }

}


class Address {
    val street: String = ""
}