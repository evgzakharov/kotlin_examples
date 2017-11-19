package com.github.evgzakharov.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<String> countries = Arrays.asList(
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
        );

        Map<Character, Pair> collect = countries.stream()
                .collect(Collectors.groupingBy(
                        country -> country.charAt(0),
                        Collectors.mapping(
                                s -> s,
                                Collectors.toList())
                ))
                .entrySet().stream()
                .map(entry -> {
                    Collections.sort(entry.getValue());
                    return new Pair(entry.getKey(), entry.getValue());
                })
                .collect(Collectors.toMap(Pair::getCharacter, value -> value));

        System.out.println(collect);
     }
}

class Pair {
    private Character character;
    private List<String> values;

    public Pair(Character character, List<String> values) {
        this.character = character;
        this.values = values;
    }

    public Character getCharacter() {
        return character;
    }

    public List<String> getValues() {
        return values;
    }
}
