package com.dailycodelearner;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

public class Main  {

    public static void main(String a[]) throws Exception {

        /*
        Grouping by characters
         */
        String input="vishnuvardhanbandlamudi";
        Map<String, List<String>> dataGrouping = stream(input.split("")).collect(groupingBy(s -> s));
        System.out.println(dataGrouping);
        /*
        grouping by characters with their counts
         */
        Map<String,Long> GroupingByCharacters= stream(input.split("")).collect(groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("GroupingByCharacters : "+GroupingByCharacters);
        /*
        duplicate elements
         */
        List<String> duplicateElements = stream(input.split("")).collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1).map(y -> y.getKey()).collect(toList());

         /*
        unique elements
         */
        List<String> uniqueElements = stream(input.split("")).collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream().filter(x -> x.getValue() ==1).map(y -> y.getKey()).collect(toList());
        System.out.println("unique elements : "+uniqueElements);

        /*
        first non repeating Element
         */
        String firstNonRepeatingElement = stream(input.split("")).collect(groupingBy(Function.identity(), LinkedHashMap::new,counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1).
                findFirst().get().getKey();
        System.out.println("first Element : "+firstNonRepeatingElement);


        /*
        first repeating Element
         */
        String firstRepeatingElement = stream(input.split("")).collect(groupingBy(Function.identity(), LinkedHashMap::new,counting()))
                .entrySet().stream().filter(x -> x.getValue() >1).
                findFirst().get().getKey();
        System.out.println("first Repeating Element : "+firstRepeatingElement);

        /*
        secondHighestNumber
         */
        int secondHighestNumber[]={4,2,2,5,2,5,6,4,64,57,85,3};
        //Collections.sort(Arrays.ofL(secondHighestNumber));
        List<Integer> second = stream(secondHighestNumber).boxed().sorted().collect(toList());
        System.out.println("secondHighestNumber : "+second.get(2));
         /*
        secondHighestNumberFromReverse
         */
        int secondHighestNumberFromReverse[]={4,2,2,5,2,5,6,4,64,57,85,3};
        //Collections.sort(Arrays.ofL(secondHighestNumber));
        Integer reverseNumber = stream(secondHighestNumber).boxed().sorted(Comparator.reverseOrder()).skip(1).
                findFirst().get();
        System.out.println("reverseNumber : "+reverseNumber);

        /*
        longest string
         */

        String[] longestString={"hkajhda","aknfalkjf","lkdsajflka","dajflwhei"};
        String longestStringfind = stream(longestString).reduce((o1, o2) -> o1.length() > o2.length() ? o1 : o2).get();
        System.out.println("longestString :"+longestStringfind);

        List<Book> books = new ArrayList<>() {{
            add(new Book(2, "physics", 360));
            add(new Book(4, "telugu", 3320));
            add(new Book(3, "gs", 60));
            add(new Book(1, "maths", 837));
        }};
        /*
         traditional sorting
         */

        Collections.sort(books, new GeneralSorting());
        System.out.println(books);

        /*
        aggreagate operations
         */
       List<Integer> lio=List.of(2,3,1,5,2,13,4,63);

        System.out.println( lio.stream().reduce(Integer::max));
        System.out.println( lio.stream().reduce(Integer::min));
        System.out.println( lio.stream().reduce(Integer::sum));
        /*
        java 8 sorting approach
         */
        books.stream().sorted(Comparator.comparing(Book::getName)).collect(toList());
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "vishnu", 23, 35000, "dev"));
        list.add(new Employee(4, "ravi", 37, 55000, "dev"));
        list.add(new Employee(2, "srikanth", 13, 45000, "qa"));
        list.add(new Employee(3, "krishna", 44, 25000, "qa"));
        list.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);


        /*
         *filter
         */


//
     Map<Long, List<Employee>> s = list.stream().collect(groupingBy(em->em.getSalary()));
        System.out.println(" employee : "+s);

//      Map<String,Long>  collect = Arrays.stream("vishnuvardhan".split(""))
//                .collect(groupingBy(Function.identity(),Collectors.counting()));
//      collect.keySet().stream().filter(e->collect.get(e)>1).forEach(System.out::println);
//        System.out.println(collect);
//
//
//        String s = Arrays.stream("vishnuvardhan".split(""))
//                .collect(groupingBy(Function.identity(),LinkedHashMap::new, counting()))
//                .entrySet()
//                .stream()
//                .filter(x -> x.getValue() == 1)
//                .findFirst()
//                .get().getKey();
//
//        System.out.println(s);

        Integer data = List.of(3, 2, 5, 53, 5, 2, 7, 4, 9).stream().collect(Collectors.toList()).stream().sorted().
                skip(1).findFirst().get();
        System.out.println(data);


        int arr[]={1,2,3,4};
        List<Integer> ints = stream(arr).boxed().collect(toList());
        ints.stream().forEach(System.out::println);
        ints.parallelStream().forEach(System.out::println);

        String[] a1={"hkajhda","aknfalkjf","lkdsajflka","dajflwhei"};
       List<String> a2= stream(a1).collect(toList());
        System.out.println(6<<3);
       /*
       comparable vs comparator
        */

        int[] a34={3, 2, 5, 53, 5, 2, 7, 4, 9};

        System.out.println(
        stream(a34).boxed().collect(groupingBy(a11->a11%2==0?"even":"odd")));

        List<String> s1=List.of("abc","bca","cab","def");

        IntStream.range(1,100).parallel().forEach(e->System.out.println(e+Thread.currentThread().getName()));
        A a11=new A();

       Thread t=new Thread(a11);
       t.start();


    }


}
 class A extends Thread{

    @Override
    public void run(){
        for(int i=0;i<30;i++){
            if((i%3==0) && (i%5==0)){
                System.out.println("fizzBuzz : "+Thread.currentThread().getName());
            }
            else if(i%3==0) {
                System.out.println("fizz : "+Thread.currentThread().getName());
            }
            else if(i%5==0){
                System.out.println("fizz : "+Thread.currentThread().getName());
            }
            else{
                System.out.println("no :" + i+" "+ Thread.currentThread().getName());
            }
        }
    }
}