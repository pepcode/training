package pep.training.imperative;
import java.lang.StringBuilder;

public class Palindrome {

    public static void main(String args[]) {

        Palindrome p = new Palindrome();
        //p.isPalindrome("shahs");

        //p.validPalindrome1("eccer");
        System.out.println(p.validPalindrome("cbbcc"));

    }

    /**
     * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        boolean output = false;
        StringBuilder sb = new StringBuilder(s);
        int size = sb.length();
        int count = 0;
        int failureCount = 0;
        while (count <= size && !output) {
            int left = 0;
            int right = sb.length() -1;
            boolean isPalindrome = true;
            System.out.println("sb :: " + sb );
            
            while(left < right) {
                if(sb.charAt(left) != sb.charAt(right)) {

                    System.out.println( sb.charAt(left) + " :: " + sb.charAt(right) + "  failureCount :: " + failureCount);
                    isPalindrome = false;
                    if(count <= size/2) {
                        failureCount++;
                    } else {
                        break;
                    } 
                }
                
                if(failureCount > 2) {
                    break;
                }
                
                left++;
                right--;
            }

            if(isPalindrome) {
                output = true;
                break;
            }else {
                if(count != size) {
                    sb = new StringBuilder(s);
                    sb.deleteCharAt(count);
                }
            }
            count++;
        }
        
        return output;
    }

    public boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = s.length() -1;
        boolean isPalindrome = true;
        while(left < right) {
            System.out.println( " " + sb.charAt(left) + " :: " + sb.charAt(right));
            if(s.charAt(left) != s.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(isPalindrome);
        return isPalindrome;

    }

    
    
}
