package com.functionalprogramming;

import java.util.List;
import java.util.regex.Pattern;

public class BListOfCourseIndividually {
    public static void main(String[] args) {
        System.out.println("----- Print All Courses individually -----");
        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
        printAllCourseIndividually(courses);
        System.out.println("----- Print Courses Containing the word Spring with Regex -----");
        filterCourseSpringWithRegex(courses);
        System.out.println("----- Print Courses Containing the word Spring -----");
        filterCourseSpring(courses);
        System.out.println("----- Print Courses Whose Name has atleast 4 letters -----");
        filterCourseBasedOnLength(courses);
        System.out.println(.1+.2);
    }

    private static void filterCourseBasedOnLength(List<String> courses) {
        courses.stream()
                .filter(course -> course.length()>=4)
                .forEach(System.out::println);
    }

    private static void filterCourseSpringWithRegex(List<String> courses) {
        courses.stream()
                .filter(course -> Pattern.compile("spring", Pattern.CASE_INSENSITIVE).matcher(course).find())
                .forEach(System.out::println);
    }

    private static void filterCourseSpring(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }

    private static void printAllCourseIndividually(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }
}
