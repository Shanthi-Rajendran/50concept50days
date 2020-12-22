package com.functionalprogramming;

import java.util.List;
import java.util.Optional;

public class DSumOfNumbersWithReduce {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        System.out.println("----- Sum of all numbers in the list -----");
        sumOfAllNumbersInList(list);
        System.out.println("----- Square every number in a list and find the sum of squares -----");
        sumOfSquareAllNumbersInList(list);
        System.out.println("----- Cube every number in a list and find the sum of cubes -----");
        sumOfCubeAllNumbersInList(list);
        System.out.println("----- Find Sum of Odd Numbers in a list -----");
        sumOfOddNumbersInList(list);
    }

    private static void sumOfAllNumbersInList(List<Integer> list) {
        System.out.println("--- Lambda ---");
        System.out.println(list.stream().reduce(0, (x, y) -> x + y));
        System.out.println("--- Method Reference ---");
        System.out.println(list.stream().reduce(Integer::sum));
    }

    private static void sumOfSquareAllNumbersInList(List<Integer> list) {
        System.out.println(list.stream().map(x -> x*x).reduce(0, (x,y) -> x+y));
        System.out.println(list.stream().reduce(0,(x,y) -> x+y*y));
    }

    private static void sumOfCubeAllNumbersInList(List<Integer> list) {
        System.out.println(list.stream().map(x -> x*x*x).reduce(0, (x,y) -> x+y));
        System.out.println(list.stream().reduce(0, (x,y) -> x+ y*y*y));
    }

    private static void sumOfOddNumbersInList(List<Integer> list) {
        System.out.println(list.stream().filter(x -> x%2!=0).reduce(0, (x,y) -> x+y));
        System.out.println(list.stream().reduce(0,(x,y) -> x+ ((y%2!=0)? y : 0)));
    }
}
