package pep.training.imperative;

public class GreetingExample {
	
	public static void main(String args[]) {
		GreetMessage gmessage1 = new GreetMessageImpl();
		gmessage1.sayHello("testing");
		
		GreetMessage gmessage2 = new GreetMessageImpl2();
		gmessage2.sayHello("testing");
		
		GreetMessage gmessage3 = (m) -> System.out.println("greet3 :: " + m);
		gmessage3.sayHello("testing3");
	}
	

}

interface GreetMessage {
	public void sayHello(String message);
}


class GreetMessageImpl implements GreetMessage {

	@Override
	public void sayHello(String message) {
		System.out.println("hello :: "+ message);
		
	}
	
}

class GreetMessageImpl2 implements GreetMessage {

	@Override
	public void sayHello(String message) {
		System.out.println("Greet  :: "+ message);
		
	}
	
}
