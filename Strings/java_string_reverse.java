import java.io.*;
import java.util.*;

/*
A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string , print Yes if it is a palindrome, print No otherwise.

-> Constraints

A will consist at most  lower case english letters.
*/

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        sc.close();
        /* Enter your code here. Print output to STDOUT. */
        
         if (isPalindrome(A)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
  
    }
    
  public static boolean isPalindrome(String s) {
      int leftPosition = 0;
      int rightPosition = s.length() -1;
      
      while (leftPosition < rightPosition) {
          if(s.charAt(leftPosition) != s.charAt(rightPosition)) {
              return false;
          }
          
          leftPosition++;
          rightPosition --;
      }
          
      return true;
      }
}





