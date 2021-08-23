package pep.training.functional._interface;

import java.util.function.Predicate;

/**
 * Predicate is used to get boolean output with single entry. can be mainly used for validations and grouping of validation
 * @author praveen
 *
 */
public class _PredicateExample {
	
	public static void main(String[] args) {
		System.out.println(isNumber.test("praveen"));
		System.out.println(isNumber.test("2017060803"));
		
		//check if isNumber and is 10digit
		System.out.println(isNumber.and(is10Digit)
				.test("201706003"));
		
		//check if isNumber or is 10digit
		System.out.println(isNumber.or(is10Digit)
						.test("201706003"));
				
		
	}
	
	static Predicate<String> isNumber = data -> data.matches("-?\\d+(\\.\\d+)?"); 
	
	static Predicate<String> is10Digit = data -> data.length() == 10;
	
}
