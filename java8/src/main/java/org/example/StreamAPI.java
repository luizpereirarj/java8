package org.example;

import java.util.Arrays;
import java.util.List;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4);
        numbers.stream()
                .filter(e -> e %2 ==0)
                .forEach(e->System.out.println(e));
    }
}
