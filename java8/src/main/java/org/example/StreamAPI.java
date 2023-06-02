package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4);
        numbers.stream()
                .filter(e -> e %2 ==0)
                .forEach(e->System.out.println(e));

        numbers=Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
        numbers.stream()
                .skip(2) // intermmediate operation
                .forEach(e->System.out.println("Skip "+e));

        numbers.stream()
                .limit(2) // intermmediate operation
                .forEach(e->System.out.println("Limit "+e));

        numbers.stream()
                .distinct() // intermmediate operation based on equals and hashcode
                .forEach(e->System.out.println("Distinct "+e));

        numbers.stream()
                .filter(e -> e % 2 == 0) // intermmediate operation based on equals and hashcode
                .forEach(e->System.out.println("Filter "+e));

        numbers.stream()
                .map(e -> e * 2) // intermmediate operation based on equals and hashcode
                .forEach(e->System.out.println("Map "+e));

        System.out.println(numbers.stream()
                .map(e -> e * 2) // intermmediate operation based on equals and hashcode
                .count());

        System.out.println(numbers.stream()
                .min(Comparator.naturalOrder()).get());

        System.out.println(numbers.stream()
                .max(Comparator.naturalOrder()).get());

        List newList=numbers.stream().filter(e -> e % 2==0)
                .collect(Collectors.toList());
        System.out.println("Collector " + newList.toString());

        Map<Boolean,List<Integer>> newMap=numbers.stream()
                .collect(Collectors.groupingBy(e-> e%2==0));
        System.out.println("Collector Grouping By" + newMap.toString());

        String joining=numbers.stream()
                .map(e-> String.valueOf(e))
                .collect(Collectors.joining());
        System.out.println("Joining " + joining);

        joining=numbers.stream()
                .map(e-> String.valueOf(e))
                .collect(Collectors.joining(";"));
        System.out.println("Joining " + joining);

        numbers.parallelStream()
                .filter(e -> e %2 ==0)
                .forEach(e->System.out.println(e));
    }
}
