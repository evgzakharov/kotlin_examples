package com.github.evgzakharov.kotlin

typealias Point = Pair<Long, Long>

typealias MapOfUsersCountryPoints = Map<String, Map<String, List<Point>>>

fun main(args: Array<String>) {

    val point1 = Pair(10L, 10L)

    val point2: Pair<Long, Long> = Pair(10L, 10L)
    val point3: Point = Pair(10L, 10)

    val point4 = Point(10L, 10L)


    val someVeryBigMap: Map<String, Map<String, List<Pair<Long, Long>>>>? = null

    val someVeryBigMap2: Map<String, Map<String, List<Point>>>? = null

    val someVeryBigMap3: MapOfUsersCountryPoints? = null

    val values: List<Point> = someVeryBigMap.geT("first").geT("second")

    val values2: List<Point> = someVeryBigMap2.geT("first").geT("second")

    val values3: List<Point> = someVeryBigMap3.geT("user1").geT("RU")
}



fun <T1, T2> Map<T1,T2>?.geT(key: T1): T2 = this!![key]!!