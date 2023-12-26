package predicate;
import java.util.function.*;
public class IntegerGreaterThan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Predicate<Integer> p=i->i>10;
		
		System.out.println(p.test(100));
		System.out.println(p.test(7));
	}

}
