/*
You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.

Example 1:
Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

Example 2:
Input: s = "1326#"
Output: "acz"

Constraints:
1 <= s.length <= 1000
s consists of digits and the '#' letter.
s will be a valid string such that mapping is always possible.
 */

package com.leetcode;

public class DecryptStringFromAlphabetToIntegerMapping_09 {
    public static void main(String[] args) {
        String s = "10#11#12";

        System.out.println(freqAlphabets(s));
    }

    static String freqAlphabets(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            char c;
            if (ch == '#') {
                int num = ((s.charAt(i - 2) - '0') * 10) + (s.charAt(i - 1) - '0');
                c = (char) ('a' + num - 1);
                i -= 2;
            } else {
                int num = (s.charAt(i) - '0');
                c = (char) ('a' + num - 1);
            }
            ans.append(c);
        }
        return ans.reverse().toString();
    }
}
