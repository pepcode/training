package pep.training.imperative;

/** 
 *
 * Java program to calculate and print Fibonacci number using both recursion  and Iteration. 
 * Fibonacci number is sum of previous two Fibonacci numbers fn= fn-1+ fn-2 
 * first 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 
 * 
 */

public class Fibonacci {

    public int fibonacci(int n){
        if(n==1 || n==2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 10;
        Fibonacci fib = new Fibonacci();
        for (int i =1; i<=n; i++) {
            System.out.print(fib.fibonacci(i));
            if(i!=n) {
                System.out.print(", ");
            }
        }
        
    }

}