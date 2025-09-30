package org.example;

/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Leetcode -> https://leetcode.com/problems/valid-palindrome/description/
Solution Link -> https://neetcode.io/solutions/valid-palindrome */

public class ValidPalindrome {

    public boolean stringPalindrome(String str) {

        String reversed="";
        String lowerCase = str.toLowerCase(); //covert the string to lowercase
        String alphaNumeric = lowerCase.replaceAll("[^a-zA-Z0-9]", ""); // remove the space and non-alphanumeric characters

        //Reverse the string
        for (int i = alphaNumeric.length()-1; i >=0; i--) {
            reversed += alphaNumeric.charAt(i);
        }
        
        return alphaNumeric.equals(reversed);
    }

    public static void main(String[] args) {
        ValidPalindrome m =  new ValidPalindrome();
        System.out.println(m.stringPalindrome("0P"));

    }
}