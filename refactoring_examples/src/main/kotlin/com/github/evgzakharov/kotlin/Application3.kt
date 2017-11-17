package com.github.evgzakharov.kotlin

fun main(args: Array<String>) {
    val countries = listOf(
            "Armenia",
            "Croatia",
            "Ghana",
            "Australia",
            "Curacao",
            "Germany",
            "Greece",
            "Cuba",
            "Grenada",
            "Russia",
            "Aruba"
    )

    val sortedCountries: Map<Char, List<String>> = countries
            .groupBy { it.first() }
            .mapValues { (char, values) -> values.sorted() }

    println(sortedCountries)

    val maxCountriesInChar = sortedCountries
            .maxBy { it.value.size }
            ?.key

    println(maxCountriesInChar!!)
}