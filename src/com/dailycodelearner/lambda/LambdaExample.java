package com.dailycodelearner.lambda;

interface Shape {
   public void draw();
}

public class LambdaExample {

    public static void shapeImplementation() {

        Shape rectangle = () -> System.out.println("reactangle shape : using draw");
        rectangle.draw();
        /**
         * passing lambda expression as parameter
         */
        print(() -> System.out.println("square shape : using draw"));

    }
    public static void print(Shape shape){
        shape.draw();
    }
}
