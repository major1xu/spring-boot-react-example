package com.uudaddy.SpringBootReact.demo.beer;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.function.Predicate;
// https://www.tutorialspoint.com/java8/java8_overview.htm
public class Java8FunctionalInterface {

    public static void main(String args[]) {
//https://www.tutorialspoint.com/java8/java8_functional_interfaces.htm
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.

        System.out.println("Print all numbers:");

        //pass n as parameter
        eval(list, n->true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero

        System.out.println("Print even numbers:");
        eval(list, n-> n%2 == 0 );

        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.

        System.out.println("Print numbers greater than 3:");
        eval(list, n-> n > 3 );
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {

        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    //sort using java 7
    private void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    //sort using java 8
    private void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
