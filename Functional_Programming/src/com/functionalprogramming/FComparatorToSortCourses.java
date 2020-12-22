package com.functionalprogramming;

import java.util.Comparator;
import java.util.List;

public class FComparatorToSortCourses {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
        System.out.println("----- Sort a list of courses in ascending order using Comparator -----");
        listSortedInAscendingOrder(courses);
        System.out.println("----- Sort a list of courses in descending order using Comparator -----");
        listSortedInDescendingOrder(courses);
        System.out.println("----- Sort a list of courses based on Course length using Comparator -----");
        listSortedBasedOnCourseLength(courses);
    }
    private static void listSortedInAscendingOrder(List<String> list) {
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    private static void listSortedInDescendingOrder(List<String> list) {
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void listSortedBasedOnCourseLength(List<String> list) {
        list.stream().sorted(Comparator.comparing(x -> x.length())).forEach(System.out::println);
    }
}
