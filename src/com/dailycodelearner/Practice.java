package com.dailycodelearner;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Practice {
    public static void main(String args[]){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "vishnu", 23, 35000, "dev"));
        list.add(new Employee(4, "ravi", 37, 55000, "dev"));
        list.add(new Employee(2, "srikanth", 13, 45000, "qa"));
        list.add(new Employee(3, "krishna", 44, 25000, "qa"));
        Map<String,Set<Employee>> depGroup=list.stream().collect(Collectors.groupingBy(Employee::getDep,Collectors.toSet()));
        System.out.println(depGroup);

        int[] arr={1,2,3,4,5,6,4,1,4,1,5,7,4,2,1,75,321,52,2,43,8,62,1,68,4,9};
        List<Integer> sorted=stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);
        System.out.println(stream(arr).boxed().reduce((a,b)->a*b).get());


    }

}
