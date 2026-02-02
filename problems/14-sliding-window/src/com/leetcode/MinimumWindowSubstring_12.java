/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */

package com.leetcode;

public class MinimumWindowSubstring_12 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s, t));
    }

    static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[] hash = new int[256];
        for (int i = 0; i < n; i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0, r = 0, count = 0, stIdx = -1, minLen = Integer.MAX_VALUE;
        while (r < m) {
            if (hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;

            while (count == n) {
                if (r - l + 1 < minLen) {stIdx = l; minLen = r - l + 1; }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }

        if (stIdx == -1) return "";
        return s.substring(stIdx, stIdx + minLen);
    }
}
