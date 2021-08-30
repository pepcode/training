package pep.training.sorting;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ArraySort {

    public static void main(String args[]){
         arrSort();
        //arrArraySort();
        // stringSortWithComparator();
        //stringSortCollectionSort();
    }

    private static void  arrSort() {

        int[] a = { 20,3,5,232,2,5,-1};
        int temp =0;

        for(int i=0; i<a.length; i++) {

            for (int j=i+1; j<a.length; j++) {
                System.out.println(Arrays.toString(a));
                if(a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                
            }

        }

        System.out.println(Arrays.toString(a));
    }

    private static void arrArraySort(){
        int[] a = { 20,3,5,232,2,5,-1};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //reverse order of Array Sort
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(Arrays.toString(a));
    }

    private static void stringSortCollectionSort(){

        String str[] = {"9" , "-100", "50", "0", "56.6","90","0.12", ".12","02.34","000.000"};
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, str); // add to List from array

        //Collections. sort
        Collections.sort(list);
        System.out.println(list);

        //reverse collections
        Collections.reverse(list);
        System.out.println(list);

    }

    private static void stringSortWithComparator(){

        String str[] = {"9" , "-100", "50", "0", "56.6","90","0.12", ".12","02.34","000.000"};
        
        // lowest to highest
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2){
                if(o1 == null || o2 == null) {
                    return 0;
                }
                BigDecimal d1 = new BigDecimal(o1);
                BigDecimal d2 = new BigDecimal(o2);
                return d1.compareTo(d2);
            }
        });
        System.out.println(Arrays.toString(str));

        //add reversed for comparator - highest to lowest
        Arrays.sort(str, (new Comparator<String>() {
            public int compare(String o1, String o2){
                if(o1 == null || o2 == null) {
                    return 0;
                }
                BigDecimal d1 = new BigDecimal(o1);
                BigDecimal d2 = new BigDecimal(o2);
                return d1.compareTo(d2);
            }
        }).reversed());
        System.out.println(Arrays.toString(str));
    }
    
}


