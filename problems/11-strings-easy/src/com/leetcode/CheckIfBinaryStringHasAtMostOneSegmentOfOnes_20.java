/*
Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones. Otherwise, return false.

Example 1:
Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.

Example 2:
Input: s = "110"
Output: true

Constraints:
1 <= s.length <= 100
s[i] is either '0' or '1'.
s[0] is '1'.
 */

package com.leetcode;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes_20 {
    public static void main(String[] args) {
        String s = "1101";

        System.out.println(checkOnesSegment(s));
    }

    static boolean checkOnesSegment(String s) {
//        return !s.contains("01");

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false;
            }
        }
        return true;
    }
}
