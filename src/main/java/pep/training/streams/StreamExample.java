package pep.training.streams;

import java.util.stream.IntStream;

/**
 * more efficeient
 * heavy use of lambda expressions
 * parallel streams  makes it very easy for multithreading
 * 
 * source (collection, list, array  ) ->  
 * 		(zero or more Intermediate operations)filter or sort or map or skip or distinct or find -> 
 * 			collect or reduce or Foreach or max or min or count (terminal operations)
 * 
 * @author praveen
 *
 */

public class StreamExample {
	
	public static void String(String[] args) {
		IntStream
			.range(1,10)
			.forEach(System.out::println);
	}

}
