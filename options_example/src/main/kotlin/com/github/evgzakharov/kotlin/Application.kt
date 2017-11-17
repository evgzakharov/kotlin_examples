package com.github.evgzakharov.kotlin

import org.apache.commons.cli.Option
import org.apache.commons.cli.Options

private const val URL_PARAM = "url"
private const val USER_PARAM = "user"
private const val PASSWORD_PARAM = "password"
private const val ACTION = "action"
private const val REQUEST = "request"

fun main(args: Array<String>) {
    val javaStyleOptions = Options()

    val urlOption = Option(URL_PARAM, true, "jdbc url connection string")
    urlOption.isRequired = true
    javaStyleOptions.addOption(urlOption)

    val userParamOption = Option("u", USER_PARAM, true, "db user name")
    userParamOption.isRequired = true
    javaStyleOptions.addOption(userParamOption)

    val passwordOption = Option("p", PASSWORD_PARAM, true, "password for db user")
    passwordOption.isRequired = true
    javaStyleOptions.addOption(passwordOption)



    val smallBetterOptions = Options().apply {
        addOption(Option(URL_PARAM, true, "jdbc url connection string")
                        .apply { require(true) })

        addOption(Option("u", USER_PARAM, true, "db user name")
                .apply { require(true) })

        addOption(Option("p", PASSWORD_PARAM, true, "password for db user")
                .apply { require(true) })
    }


    val options = Options().combine {
        +Option(URL_PARAM, true, "jdbc url connection string")

        +Option("u", USER_PARAM, true, "db user name")

        +Option("p", PASSWORD_PARAM, true, "password for db user")
    }



    val bestCase = combineOptions {
        +Option(URL_PARAM, true, "jdbc url connection string")

        +Option("u", USER_PARAM, true, "db user name")

        +Option("p", PASSWORD_PARAM, true, "password for db user")
    }
}


fun combineOptions(func: BigOption.() -> Unit): Options {
    val options = Options()
    BigOption(options).func()

    return options
}

fun Options.combine(func: BigOption.() -> Unit): Options {
    BigOption(this).func()

    return this
}

class BigOption(private val options: Options) {
    operator fun Option.unaryPlus() {
        options.addOption(this).apply {
            isRequired = true
        }
    }

    operator fun Option.unaryMinus() {
        options.addOption(this).apply {
            isRequired = false
        }
    }
}