package com.functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;

public class GCollectorForListOfElements {
    public static void main(String[] args) {
        System.out.println("----- List of even numbers using collector -----");
        collectEvenNumbersInList();
        System.out.println("----- List containing length of string using collector -----");
        collectCourseLengthInList();
    }

    private static void collectEvenNumbersInList() {
        List<Integer> list = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<Integer> result = list.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void collectCourseLengthInList() {
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
        List<Integer> result = courses.stream()
                .map(x -> x.length())
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
