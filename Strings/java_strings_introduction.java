import java.io.*;
import java.util.*;

/*
Objectives:
- Sum the lengths of  and .
- Determine if  is lexicographically larger than  (i.e.: does  come before  in the dictionary?).
- Capitalize the first letter in  and  and print them on a single line, separated by a space.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        sc.close();

        int sumLengths = A.length() + B.length();
        
        String lexicographComparation = (A.compareTo(B) > 0) ? "Yes" : "No";
        
        String str1Capitalized = capitalizeFirstLetter(A);
        String str2Capitalized = capitalizeFirstLetter(B);
        
        System.out.println(sumLengths);
        System.out.println(lexicographComparation);
        System.out.println(str1Capitalized + " " + str2Capitalized); 
    }
    
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    }


