package com.example.demo.colection.stream;

// Java program to demonstrate
// the use of stream in java
import java.util.*;
import java.util.stream.*;

class Demo {
    public static void main(String args[])
    {
        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        // demonstration of map method
        List<Integer> square
                = number.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        System.out.println("demonstration of map method: "+ square);

        // create a list of String
        List<String> names = Arrays.asList(
                "Reflection", "Collection", "Stream");

        // demonstration of filter method
        List<String> result
                = names.stream()
                .filter(s -> s.startsWith("S"))
                .collect(Collectors.toList());

        System.out.println("demonstration of filter method: "+ result);
        System.out.println("From : "+ names);

        // demonstration of sorted method
        List<String> show
                = names.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("demonstration of sorted method: "+show);
        System.out.println("From : "+ names);

        // create a list of integers
        System.out.println("create a list of integers");
        List<Integer> numbers
                = Arrays.asList(2, 3, 4, 5, 2);

        // collect method returns a set
        Set<Integer> squareSet
                = numbers.stream()
                .map(x -> x * x)
                .collect(Collectors.toSet());

        System.out.println("collect method returns a set: "+ squareSet);
        System.out.println("From : "+ numbers);

        // demonstration of forEach method
        number.stream()
                .map(x -> x * x)
                .forEach(y -> System.out.println("forEach method: "+y));
        System.out.println("From : "+ number);

        // demonstration of reduce method
        int even
                = number.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (ans, i) -> ans + i);
        System.out.println("demonstration of reduce method: "+ even);
        System.out.println("From : "+ number);
    }
}
