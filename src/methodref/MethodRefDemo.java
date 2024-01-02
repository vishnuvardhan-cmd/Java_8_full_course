package methodref;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

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

        //using method ref

        Function<Integer,Double> functionMethodRef=Math::sqrt;
        System.out.println(function.apply(4));

        //method reference to an instance method by using an object

        MethodRefDemo methodRefDemo=new MethodRefDemo();
        MyInterface myInterface=(String msg)->methodRefDemo.display(msg);
        myInterface.print("hi");

        //usring method ref
        MyInterface myInterfacemf=methodRefDemo::display;
        myInterfacemf.print("hi");

        //method reference instance method of an arbitary object

        //using lambda expression
        Function<String,String> stringFunction=(msg)->msg.toLowerCase();
        System.out.println(stringFunction.apply("Hi..!"));

        //using method ref
        Function<String,String> stringFunctionmf=String::toLowerCase;
        System.out.println(stringFunctionmf.apply("Hi..!"));

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
