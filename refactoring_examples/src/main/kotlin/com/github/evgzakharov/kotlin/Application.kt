package com.github.evgzakharov.kotlin

fun main(args: Array<String>) {
    val simpleUser = User(surname = "Банкович", name = "Альфа")

    val (extendedUser, id) = extendUser(simpleUser)

    println("extended user: $extendedUser with id: $id")
}

data class User(val id: Long? = null, val name: String, val surname: String)

data class ExtendedUser(val name: String, val surname: String, val extendInfo: String)

private fun extendUser(user: User): Pair<ExtendedUser, Long?> {
    val extendedInfo = if (user.id == null) {
        "user id not find"
    } else {
        "user with id=${user.id}"
    }

    return ExtendedUser(user.name, user.surname, extendedInfo) to user.id
}