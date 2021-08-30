package pep.training.streams;

import java.util.*;

public class RollArray {

    public static void main(String args[]) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(rotLeft(a,2));
        System.out.println(a);
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
            List<Integer> output = new ArrayList<Integer>();
            output.addAll(a);
            int arrSize = a.size();
            for(int i=1;i<=d; i++){

                System.out.println(output);
                for(int j=0; j<arrSize;j++) { 
                    int o = j+1; 
                    if(o < arrSize){
                        output.set(j, output.get(o));
                    } else {
                        o = arrSize-(j-1); //3 +2
                        output.set(j, a.get(o));
                    }
                    System.out.println("i:: " + i + "j:: " + j +" :: " + output);
                    
                }
            }
            
            return output;
        }
}