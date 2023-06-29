package com.dailycodelearner;


import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String a[]){
        /**
         * functionInterfaces basic implementation
         * function<T,R> takes input and return output,contains apply method
         * conusmerinterface<t> takes input and uses it , contains accept method
         * supplier<R> returns output , contains get method
         */

        Function<String,Integer> function=(s)->s.length();
        System.out.println(function.apply("suresh"));
        Consumer<String> consumer=(s)-> System.out.println(s);
        consumer.accept("vishnu");
        Supplier<LocalDateTime> supplier=()->LocalDateTime.now();
        System.out.println(supplier.get());
    }
}
