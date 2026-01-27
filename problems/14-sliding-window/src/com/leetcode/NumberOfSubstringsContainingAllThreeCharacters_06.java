/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".

Example 3:
Input: s = "abc"
Output: 1

Constraints:
3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
 */

package com.leetcode;

public class NumberOfSubstringsContainingAllThreeCharacters_06 {
    public static void main(String[] args) {
        String s = "abcabc";

        System.out.println(numberOfSubstrings(s));
    }

    static int numberOfSubstrings(String s) {
        // method 1
        int n = s.length();

        int l = 0, r = 0, count = 0;
        int[] hash = new int[3];
        while (r < n) {
            char ch = s.charAt(r);
            hash[ch - 'a']++;
            while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                count += n - r;
                hash[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return count;

        // method 2
//        int n = s.length();
//        int[] hash = {-1, -1, -1};
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//            hash[ch - 'a'] = i;
//            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1) {
//                count = count + (1 + (Math.min(hash[0], Math.min(hash[1], hash[2]))));
//            }
//        }
//        return count;
    }
}
