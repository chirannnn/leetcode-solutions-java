/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */

package com.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams_04 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        groupAnagrams(strs).forEach(System.out::println);
    }

    static List<List<String >> groupAnagrams(String[] strs) {
        int n = strs.length;

        String[][] pairs = new String[n][2];
        for (int i = 0; i < n; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            pairs[i][0] = new String(ch);
            pairs[i][1] = strs[i];
        }

        Arrays.sort(pairs, (a, b) -> a[0].compareTo(b[0]));

        List<List<String>> result = new ArrayList<>();
        List<String> group = new ArrayList<>();
        group.add(pairs[0][1]);
        for (int i = 1; i < n; i++) {
            if (pairs[i][0].equals(pairs[i - 1][0])) {
                group.add(pairs[i][1]);
            } else {
                result.add(group);
                group = new ArrayList<>();
                group.add(pairs[i][1]);
            }
        }
        result.add(group);
        return result;
    }
}
