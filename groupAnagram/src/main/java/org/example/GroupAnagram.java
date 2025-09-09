package org.example;

import java.util.*;

/*Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Solution Link -> https://neetcode.io/solutions/group-anagrams */

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        //create a hashmap to store values in key-value pairs.
        Map<String, List<String>> groupStr =  new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray(); //convert the string[] into char[] for using the sort().
            Arrays.sort(c);

            //computeIfAbsent() computes the new key if the key(c) is not in the hashMap and create new empty arraylist is created.
            // if key is available and calls the add() and insert the value into the particular key.
            groupStr.computeIfAbsent(new String(c), c1-> new ArrayList<>()).add(strs[i]);

        }
        return new ArrayList<>(groupStr.values()); // values() used to return the collection of values(not key) in the hashmap.
    }

    public static void main(String[] args) {
        GroupAnagram m =  new GroupAnagram();
        System.out.println(m.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
        System.out.println(m.groupAnagrams(new String[] {""}));
        System.out.println(m.groupAnagrams(new String[] {"a"}));


    }
}