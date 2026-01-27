/*
Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

A substring is a contiguous non-empty sequence of characters within a string.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.

Constraints:
1 <= s.length <= 5 * 10^4
0 <= k <= 50

 */

package com.leetcode;

public class LongestSubstringWithAtMostKDistinctCharacters_05 {
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;

        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();

        int l = 0, r = 0, distinct = 0, maxLen = 0;
        int[] hash = new int[26];
        while (r < n) {
            char ch = s.charAt(r);
            if (hash[ch - 'a'] == 0) distinct++;
            hash[ch - 'a']++;

            while (distinct > k) {
                hash[s.charAt(l) - 'a']--;
                if (hash[s.charAt(l) - 'a'] == 0) distinct--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
