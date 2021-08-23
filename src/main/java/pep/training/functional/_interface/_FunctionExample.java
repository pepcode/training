package pep.training.functional._interface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _FunctionExample {
	
	public static void main(String[] agrs) {
		
		
		System.out.println("Imperative program :: "+ incrementByOne(1));
	
		System.out.println("IncrementByOneFunction :: "+ incrementByOneFunction.apply(1));
		
		System.out.println("incrementanddecrementbyoneFunction :: "+ incrementanddecrementbyoneFunction.apply(1));
		
		System.out.println("incrementanddecrementbyoneWithBiFunction :: "+ incrementanddecrementbyoneWithBiFunction.apply(1,1));
		
	}

	//declarative program
	static Function<Integer, Integer> incrementByOneFunction = n -> n+1;
	
	static Function<Integer,Integer> decrementByOneFunction = n -> n-1;
	
	//function within function
	static Function<Integer,Integer> incrementanddecrementbyoneFunction = incrementByOneFunction.andThen(decrementByOneFunction);
	
	//BiFunction
	static BiFunction<Integer,Integer, Integer> incrementanddecrementbyoneWithBiFunction = 
			(incrementby1, decrementby1) -> (incrementby1 + 1)-decrementby1;
	
	//Imperative program
	private static int incrementByOne(int number) {
		return number + 1;
	}
}
