package pep.training.imperative;

import java.util.List;
import java.util.ArrayList;


public class PrimeNumber {

    private boolean isPrime(int num){
        boolean isPrime = false;
        if(num > 1) {
            if(num < 4) {
                isPrime = true;
            } else {

                for(int i = 2; i < num/3; i++){
                    if(num % i != 0){
                        isPrime = true; 
                    } else {
                        isPrime = false;
                        break;
                    }
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args){

        PrimeNumber prime = new PrimeNumber();
        int num = 10;
        List<Integer> output = new ArrayList<>();
        // for (int i = 1; i<=num; i++) {
        //     if(prime.isPrime(i)) {
        //         output.add(i);
        //     }
        // }

        System.out.println(prime.isPrime(5));

        System.out.println(output.toString());


    }
    
}
