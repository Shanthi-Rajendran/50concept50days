package com.functionalprogramming;

import java.util.List;

public class CListOfIntegerAndCourseWithMap {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println("----- Print the cubes of odd numbers -----");
        printCubeOfOddElements(list);
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
        System.out.println("----- Print the number of characters in each course name -----");
        printNumberOfCharacters(courses);
    }

    private static void printNumberOfCharacters(List<String> courses) {
        courses.stream()
                .map(x -> x.length())
                .forEach(System.out::println);
    }

    private static void printCubeOfOddElements(List<Integer> list) {
        list.stream()
                .filter(x -> x%2!=0)
                .map(x -> x*x*x)
                .forEach(System.out::println);
    }
}
