package com.functionalprogramming;

import java.util.List;

public class AListOfNumbersFunctional {
    public static void main(String[] args){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //printing list
        System.out.println("Printing list");
        list.stream().forEach(System.out::println);
        //filter even without lambda
        System.out.println("Filter even without lambda");
        list.stream().filter(AListOfNumbersFunctional::evenMethod)
                .forEach(System.out::println);
        //filter with lambda expression
        System.out.println("Filter with lambda expression");
        list.stream().filter(number -> number%2==0)
                .forEach(System.out::println);
    }

    private static boolean evenMethod(Integer integer) {
        return integer%2==0;
    }
}
