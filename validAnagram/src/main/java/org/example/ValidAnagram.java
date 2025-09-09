package org.example;

import java.util.Arrays;

/*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Anagrams means length and character should be same
Input: s = "anagram", t = "nagaram"
Output: true
Solution Link -> https://neetcode.io/solutions/valid-anagram */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        boolean status = false;
        if(s.length() != t.length()) status =  false;

        //convert the string into character array to use the sort().
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static void main(String[] args) {
        ValidAnagram m = new ValidAnagram();
        System.out.println(m.isAnagram("anagram", "nagaram"));

    }
}