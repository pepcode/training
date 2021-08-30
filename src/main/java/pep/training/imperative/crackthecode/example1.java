package pep.training.imperative.crackthecode;

import static java.lang.Math.cbrt;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Print all positive integer solutions to equation a^3 + b^3 = c^3 + d^3 
 * where a,b,c and are integers between 1 and 1000
 * 
 * @author praveen
 *
 */
public class example1 {
	
	static final int n =25;
	
	public static void main(String args[]) {
		
		long stime = System.currentTimeMillis();
		brutefource();
		System.out.println("time taken :: " +  (System.currentTimeMillis()- stime));
		
		 stime = System.currentTimeMillis();
		bestType();
		System.out.println("time taken :: " +  (System.currentTimeMillis()-stime));
		
		stime = System.currentTimeMillis();
		bestType1();
		System.out.println("time taken :: " +  (System.currentTimeMillis()-stime));
	}
	
	/**
	 * time - O (n pow(3) )
	 */
	private static void bestType() {
		Map<String, Double> valueMap = new HashMap<>();
		for(int a=1; a<n; a++) {
			for(int b=1; b<n; b++) {
				valueMap.put(a+","+b, (cbrt(a) + cbrt(b)));
			}
		}
		
		for(int c=1; c<n; c++) {
			for(int d=1; d<n; d++) {
				double result = cbrt(c) + cbrt(d);
			
				for (Map.Entry<String, Double> entry : valueMap.entrySet()) {
				    if(entry.getValue() == result) {
						//System.out.println(entry.getKey() + "," +c + "," + d);
					}
				}
				
			}
		}
		
	}
	
	/**
	 * O (N pow 2)
	 */
	
	private static void bestType1() {
		Map<String, Double> valueMap = new HashMap<>();
		for(int a=1; a<n; a++) {
			for(int b=1; b<n; b++) {
				valueMap.put(a+","+b, (cbrt(a) + cbrt(b)));
			}
		}
		
		for (Map.Entry<String, Double> entry : valueMap.entrySet()) {
			for (Map.Entry<String, Double> entry1 : valueMap.entrySet()) {
			    if(entry.getValue() == entry1.getValue()) {
					//System.out.println(entry.getKey() + "," +c + "," + d);
				}
			}
		}
		
	}
	
	/**
	 * Big O timing - O(N pow(4))
	 */
	private static void brutefource() {
		for(int a=1; a<n; a++) {
			for(int b=1; b<n; b++) {
				for(int c=1; c<n; c++) {
					for(int d=1; d<n; d++) {
						if((cbrt(a) + cbrt(b)) == (cbrt(c) + cbrt(d))) {
							//System.out.println("a :: " + a + " b :: " + b+ " c :: " + c+ " d :: " + d);
						}
					}
				}
			}
		}
	}

}
