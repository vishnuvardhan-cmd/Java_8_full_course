package com.dailycodelearner;

import com.dailycodelearner.lambda.LambdaExample;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static int addtion(int a,int b){
        return a+b;
    }

    public void print(String msg){
        System.out.println(msg);
    }
    public static void main(String args[]){

        //using lamba expression
        BiFunction<Integer,Integer,Integer> biFunction=(a,b)->Main.addtion(a,b);
        System.out.println(biFunction.apply(10,20));

        //using method reference calling static method of a class
        BiFunction<Integer,Integer,Integer> biFunctionMethodRef=Main::addtion;
        System.out.println(biFunction.apply(10,20));

        Main m=new Main();

        //using lambda expression
        Consumer<String> consumer=(msg)->m.print(msg);
        consumer.accept("vishnu");
        //using instance method of an object
        Consumer<String> consumerMethodRef=m::print;
        consumerMethodRef.accept("vishnu");

        //using lambda expression
        Consumer<String> consumerString=(msg)-> System.out.println(msg.toUpperCase());
        consumerString.accept("vishnu");
        //using instance method of an arbitary object
        Consumer<String> consumerStringMethodRef=System.out::println;
        consumerStringMethodRef.accept("vishnu");

        List<String> fruits= List.of("apple","banna","mango","apple");

        //using lambda expression
        Function<List<String>, Set<String>> setFunction=(fruit)->new HashSet<>(fruit);
        System.out.println(setFunction.apply(fruits));

        //using constructor
        Function<List<String>, Set<String>> setFunctionMethodRef=HashSet::new;
        System.out.println(setFunction.apply(fruits));
    }
}
