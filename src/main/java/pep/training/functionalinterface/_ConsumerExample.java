package pep.training.functionalinterface;

import static pep.training.functionalinterface.Gender.FEMALE;
import static pep.training.functionalinterface.Gender.MALE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class _ConsumerExample {
	
	/**
	 * This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
	 * 
	 */
	static Consumer<Person> greetPersonByConsumer = person -> System.out.println("welcome " + person.name);
	
	public static void main(String args[]) {
		
		
		List<Person> people = new ArrayList<>();
		people.add(new Person ("Praveen", MALE));
		people.add(new Person ("Charanya", FEMALE));
		people.add(new Person ("Prajith", MALE));
		people.add(new Person ("Kosal", MALE));
		people.add(new Person ("Manoharan", MALE));
		people.add(new Person ("Malar", FEMALE));
		
		greetCustomer(people.get(0));
		greetPersonByConsumer.accept(people.get(1));
			
	}
	

	
	private static  void greetCustomer(Person p) {
		System.out.println("welcome " + p.name);
	}

}

class Person {
	
	public String name;
	public Gender gender;
	
	public Person(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

}

enum Gender {
	MALE, FEMALE
}
