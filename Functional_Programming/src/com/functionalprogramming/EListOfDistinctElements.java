package com.functionalprogramming;

import java.util.List;

public class EListOfDistinctElements {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("-----List of Distinct elements using distinct function-----");
        list.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
