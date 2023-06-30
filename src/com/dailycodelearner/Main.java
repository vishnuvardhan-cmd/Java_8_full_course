package com.dailycodelearner;

import com.dailycodelearner.lambda.LambdaExample;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String a[]) {
        /**
         * basic implementation of lambda expression
         */

        String email = "bvishnu123vardhan@gmail.com";
        //empty usage
        Optional<Integer> op = Optional.empty();
        System.out.println(op);
        //throws null pinter exception can't handle it

        /**
         *   Optional<Object> o1 = Optional.of(null);
         *         System.out.println(o1);
         */

        Optional<Object> o = Optional.ofNullable(null);
        if (o.isPresent()) {
            System.out.println(o.get());
        } else {
            System.out.println("no such value");
        }

        Optional<Object> o2 = Optional.ofNullable(email);
        Object o1 = o2.orElse("defaul@gmail.com");
        System.out.println(o2);

        Optional<Object> o3 = Optional.ofNullable(null);
        Object o4 = o3.orElseGet(()->"defaul@gmail.com");
        System.out.println(o4);

        Optional<List<String>> fruits=Optional.ofNullable(List.of("mango","apple","Grape","guava","banana"));
        if(fruits.isPresent()) {
            List<String> strings = fruits.get();
            List<String> stringStream = strings.stream().filter(f -> f.length() == 5).collect(Collectors.toList());
            System.out.println(stringStream);
        }
        Optional<String> result=Optional.of("abc");
        result.filter(res -> res.contains("a")).map(String::trim).ifPresent(res-> System.out.println(res));
    }

}
