package com.uudaddy.SpringBootReact.demo.beer;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Permutations {
    public static void main(String[] args) {
        // List of number to search in.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 9, 10, 14, 17, 19, 25);

        // Find the sum of values in the array to equal this number.
        int numberToFind = 6; // 8, 11, 17, 29, 32, 49, 107, 110

        for(int ii=0; ii<numbers.size(); ii++)
        {
            System.out.println(numbers.get(ii));
        }
        int sum = 0;
        int startIndex=0;
        Permutations.sum_of_values_in_array(numbers, numberToFind, sum, startIndex);

    }

    public static int sum_of_values_in_array(List<Integer> numbers, int number_to_find, int sum, int startIndex)
    {
        List<Integer> smaller_list = new ArrayList<Integer>();
        sum = sum+numbers.get(startIndex);

        if(sum == number_to_find)
        {
            System.out.println("found number, sum=" + sum);
            return sum;
        }
        else
        {
            // need to mark a number has already been used once...
            // how to tell, do I need to keep track of current index...
            // note we have not performed all the permutations yet...
            smaller_list.add(numbers.get(startIndex));
            if(startIndex<(numbers.size()-1))
            {
                startIndex++;
                System.out.println("startIndex: "+startIndex);
                System.out.println("current number: "+numbers.get(startIndex));
                System.out.println("continue recursive fun...");

                return sum_of_values_in_array(numbers, number_to_find, sum, startIndex);
            }
        }
        return sum;
    }
}
