package com.github.evgzakharov.java;

import java.util.List;
import java.util.Map;

public class Application2 {
    public static void main(String[] args) {
        Pair<Long, Long> point1 = new Pair<>(10L, 20L);

        Point point2 = new Point(10L, 10L);

        Map<String, Map<String, List<Pair<Long, Long>>>> someVeryBigMap = null;

        List<Pair<Long, Long>> values = someVeryBigMap.get("first").get("second");

        //List<Point> values2 = someVeryBigMap.get("first").get("second");
    }
}

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }
}

class Point extends Pair<Long, Long> {
    public Point(Long first, Long second) {
        super(first, second);
    }
}
