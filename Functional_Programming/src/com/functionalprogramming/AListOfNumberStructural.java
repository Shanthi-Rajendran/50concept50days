package com.functionalprogramming;

import java.util.List;

public class AListOfNumberStructural {
    public static void main(String[] args){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //printing list
        for(int number:list) {
            System.out.println(number);
        }
        //filter even
        for(int number:list) {
            if(number%2==0){
                System.out.println(number);
            }
        }
    }
}
