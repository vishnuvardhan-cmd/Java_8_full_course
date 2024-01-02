package lambda;

import java.util.Scanner;

interface Square{
    void doMath(int a);
}
public class LambdaExample {

    public static void main(String args[]) {
        Shape rectangle = () -> System.out.println("this is rectangle");
        rectangle.draw();
        Scanner sc=new Scanner(System.in);
        int a1;
        System.out.println("enter the value");
        a1=sc.nextInt();
        Square domath=(a)->System.out.println(a*a);
        domath.doMath(a1);
    }

}
