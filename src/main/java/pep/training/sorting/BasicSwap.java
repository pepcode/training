package pep.training.sorting;

import java.util.Arrays;

public class BasicSwap {
	
	public static void main(String args[]) {
		
		int[] input = {1,4,3,6,7,2,4,8};
		
		long stime = System.nanoTime();
		swapMinMax(input);
		System.out.println("time taken :: " +  (System.nanoTime()- stime));
		
		
		stime = System.nanoTime();
		swapMinMax_best(input);
		System.out.println("time taken :: " +  (System.nanoTime()- stime));
		
	}
	
	private static void swapMinMax(int[] input) {
		
//		System.out.println(Arrays.toString(input));
		int minIdx =0;
		int maxIdx = 0;
		int size = input.length;
		for(int i=0; i<size;i++) {
			if(input[i] < input[minIdx]) {
				minIdx = i;
			}
		}
		
		for(int i=0; i<size;i++) {
			if(input[i] > input[maxIdx]) {
				maxIdx = i;
			}
		}
		
		int temp= input[minIdx];
		input[minIdx] = input[maxIdx];
		input[maxIdx] = temp;
		
//		System.out.println(Arrays.toString(input));
	}
	
	
	/**
	 * 
	 * @param input
	 */
	private static void swapMinMax_best(int[] input) {
		
//		System.out.println(Arrays.toString(input));
		int minIdx = 0, 
			maxIdx = 0;
		int size = input.length;

		for(int i=0; i<size;i++) {
			if(input[i] < input[minIdx]) {
				minIdx = i;
			}
			if(input[i] > input[maxIdx]) {
				maxIdx = i;
			}
		}
		
		int temp= input[minIdx];
		input[minIdx] = input[maxIdx];
		input[maxIdx] = temp;
//		System.out.println(Arrays.toString(input));
	}

}
