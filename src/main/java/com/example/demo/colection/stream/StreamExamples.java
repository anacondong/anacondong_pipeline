package com.example.demo.colection.stream;
import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        // Example data
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<List<Integer>> nestedNumbers = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        // Map: Transform each element to upper case
        List<String> uppercaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names: " + uppercaseNames);

        // ForEach: Print each element
        System.out.println("Names:");
        names.stream()
                .forEach(System.out::println);

        // Filter: Select even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Reduce: Calculate sum of numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum of numbers: " + sum);

        // FlatMap: Flatten nested lists
        List<Integer> flattenedNumbers = nestedNumbers.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened numbers: " + flattenedNumbers);

        // Collect: Accumulate elements into a set
        Set<String> nameSet = names.stream()
                .collect(Collectors.toSet());
        System.out.println("Name set: " + nameSet);

        // Distinct: Filter out duplicate numbers
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);

        // Sorted: Sort numbers in ascending order
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);

        // Limit: Truncate the stream to 3 elements
        List<Integer> limitedNumbers = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited numbers: " + limitedNumbers);

        // Skip: Skip the first 2 elements
        List<Integer> skippedNumbers = numbers.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Skipped numbers: " + skippedNumbers);

        // AnyMatch, AllMatch, NoneMatch: Check conditions
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 3);
        boolean allMatch = numbers.stream().allMatch(n -> n > 0);
        boolean noneMatch = numbers.stream().noneMatch(n -> n == 0);
        System.out.println("Any match > 3: " + anyMatch);
        System.out.println("All match > 0: " + allMatch);
        System.out.println("None match == 0: " + noneMatch);
    }
}

