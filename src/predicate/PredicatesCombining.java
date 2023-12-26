package predicate;
import java.util.function.*;

public class PredicatesCombining {

	public static void test(Predicate<Integer> p,int[] x) {
		for(int x1:x) {
			if(p.test(x1)) {
			System.out.println(x1);
		}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x= {0,5,10,15,20,25,30,35,40,45,50};
		Predicate<Integer> p1=i->i>10;
		Predicate<Integer> p2=i->i%2==0;
		System.out.println("The numbers greater than 10");
		test(p1,x);
		System.out.println("The even numbers");
		test(p2,x);
		System.out.println("The numbers not greater than 10");
		test(p1.negate(),x);
		System.out.println("The numbers greater than 10 and even also");
		test(p1.and(p2),x);
		System.out.println("The numbers greater than 10 or even");
		test(p1.or(p2),x);
	}

}
