package strings;

import java.util.List;
import java.util.stream.Collectors;

public class VowelOccurenceCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="vishnuvardhan has a great potentialAaEJKLAJFIO";
		int count=0;
		for(int i=0;i<s.length();i++) {
			switch((s.charAt(i)+"").toLowerCase()) {
			
			case "a":count++;
					 break;
			case "e":count++;
			 		 break;
			case "i":count++;
			         break;
			case "o":count++;
			 		 break; 
			case "u":count++;
			 		 break;
			default :break;
			}
		}
		System.out.println(count);
		countOfVowelUsingStreams(s);
	}
	static int scount=0;
	public static void countOfVowelUsingStreams(String str) {
		List<Character> c=List.of('a','e','i','o','u','A','E','I','O','U');
		List<Character> list=str.chars().mapToObj(e->(char)e).collect(Collectors.toList());
//		int count =0;
		list.stream().map(e->c.contains(e)?scount++:scount);
		System.out.println(scount);
	}
}
