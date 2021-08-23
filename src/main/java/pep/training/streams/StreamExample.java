package pep.training.streams;

import java.util.stream.IntStream;

/**
 * 
 * Stream Advantages - 
 * 1. more efficeient
 * 2. heavy use of lambda expressions
 * 3. parallel streams  makes it very easy for multithreading
 * 4. Declarative style of coding
 * 
 *  *****************			*****************			*****************
 *  *				*			*				*			*				*
 *  *    source		*************   Interim Ops ************* Terminal Ops	*
 *  *				*			*				*			*				*
 *  *****************			*****************			*****************
 *  
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
