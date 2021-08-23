package pep.training.functionalinterface;

import java.util.function.Supplier;

/**
 * supplier is used to declare stuff for lambda
 * @author praveen
 *
 */
public class _SupplierExample {
	
	public static void main(String args[]) {
		System.out.println(getConnectionString());
		System.out.println(getConnectionStringSupplier.get());
	}
	
	
	static Supplier<String> getConnectionStringSupplier = () -> "jdbc://localhost:8080/test/supplier";
	
	private static String getConnectionString() {
		return "jdbc://localhost:8080/test";
	}

}
