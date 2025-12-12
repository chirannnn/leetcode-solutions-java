/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

package com.leetcode;

public class LongestCommonPrefix_18 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }
}
