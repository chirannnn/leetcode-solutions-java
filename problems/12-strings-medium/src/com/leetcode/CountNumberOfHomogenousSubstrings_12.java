/*
Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.

A string is homogenous if all the characters of the string are the same.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s = "abbcccaa"
Output: 13
Explanation: The homogenous substrings are listed as below:
"a"   appears 3 times.
"aa"  appears 1 time.
"b"   appears 2 times.
"bb"  appears 1 time.
"c"   appears 3 times.
"cc"  appears 2 times.
"ccc" appears 1 time.
3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.

Example 2:
Input: s = "xy"
Output: 2
Explanation: The homogenous substrings are "x" and "y".

Example 3:
Input: s = "zzzzz"
Output: 15

Constraints:
1 <= s.length <= 105
s consists of lowercase letters.
 */

package com.leetcode;

public class CountNumberOfHomogenousSubstrings_12 {
    public static void main(String[] args) {
        String s = "zzzzz";

        System.out.println(countHomogenous(s));
    }

    static int countHomogenous(String s) {
        int MOD = 1_000_000_007;

        long k = 1;
        long count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                k++;
            } else {
                count += (k * (k + 1) / 2);
                k = 1;
            }
        }
        count += (k * (k + 1) / 2);
        return (int) (count % MOD);
    }
}
