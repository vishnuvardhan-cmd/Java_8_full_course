package methodref;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface MyInterface{
    void print(String msg);
}
public class MethodRefDemo {

    public void display(String msg){
        msg=msg.toLowerCase();
        System.out.println(msg);
    }
    public static void main(String args[]){

        //Method Ref to static method

        //lambda expression

        Function<Integer,Double> function=(input)->Math.sqrt(input);
        System.out.println(function.apply(4));

        List<Integer> integers= Arrays.asList(2,3,4,5,8,7,9,2,12);
        Optional<Integer> reduce = integers.stream().reduce((a, b) -> Math.max(a, b));
        System.out.println(reduce.get());

        //using method ref

        Function<Integer,Double> functionMethodRef=Math::sqrt;
        System.out.println(function.apply(4));


        Optional<Integer> reducemf = integers.stream().reduce(Math::max);
        System.out.println(reducemf.get());

        //method reference to an instance method by using an object

        MethodRefDemo methodRefDemo=new MethodRefDemo();
        MyInterface myInterface=(String msg)->methodRefDemo.display(msg);
        myInterface.print("hi");

        //usring method ref
        MyInterface myInterfacemf=methodRefDemo::display;
        myInterfacemf.print("hi");

        reducemf.ifPresent(System.out::println );

        //method reference instance method of an arbitary object

        //using lambda expression
        Function<String,String> stringFunction=(msg)->msg.toLowerCase();
        System.out.println(stringFunction.apply("Hi..!"));

        List<String> strings = Arrays
                .asList("how", "to", "do", "in", "java", "dot", "com");

        List<String> sorted=strings.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(Collectors.toList());

        System.out.println(sorted);


        //using method ref
        Function<String,String> stringFunctionmf=String::toLowerCase;
        System.out.println(stringFunctionmf.apply("Hi..!"));

        List<String> sortedmf=strings.stream().sorted(String::compareTo).toList();

        System.out.println(sortedmf);
        //method ref using constructor and new

        List<String> fruit=List.of("apple","bananna","mango");
        //using lambda expression
        Function<List<String>, Set<String>> listSetFunction=(fruits)->new HashSet<>(fruits);
        System.out.println(listSetFunction.apply(fruit));

        //using methodref
        Function<List<String>, Set<String>> listSetFunctionmf=HashSet::new;
        System.out.println(listSetFunctionmf.apply(fruit));




    }
}
