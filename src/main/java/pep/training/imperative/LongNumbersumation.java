package pep.training.imperative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LongNumbersumation {
	
	
	public static void main(String args[]) {
		
		Long[] a = {20000000L , 343434343l, 34534523452345L };
		System.out.println(Arrays.stream(a).mapToLong(Long::longValue).sum());
		
		
		int[] a1 = {1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7};
		char[] b = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String str = "torn";
		
		char[] c = str.toCharArray();
		
		List l = new ArrayList();
		l.size()
		Map<char, int> map = new HashMap();
		for(int i=0; i<=25; i++) {
			
		}
		
	}

}
