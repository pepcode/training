package pep.training.imperative.crackthecode;

public class primeNumber {
	
	public static void main(String args[]) {
		
		primeNumber prime = new primeNumber();
		for(int i=0; i<= 100; i++) {
			boolean isPrime = prime.isPrimeWorst(i);
			if(isPrime) {
				System.out.print(i+",");
			}
			
		}
	}
	
	private boolean isPrimeWorst(int val) {
		boolean result = true;
		if(val<2) {
			result = false;
		}else if (val > 3) {
			for (int i = 2; i < (val-1); i++) {
				if(val%i == 0) {
					result = false;
					break;
				}
			}
			
		}
		return result;
	}

}
