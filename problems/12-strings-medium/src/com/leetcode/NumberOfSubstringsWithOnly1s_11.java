/*
Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

Example 1:
Input: s = "0110111"
Output: 9
Explanation: There are 9 substring in total with only 1's characters.
"1" -> 5 times.
"11" -> 3 times.
"111" -> 1 time.

Example 2:
Input: s = "101"
Output: 2
Explanation: Substring "1" is shown 2 times in s.

Example 3:
Input: s = "111111"
Output: 21
Explanation: Each substring contains only 1's characters.

Constraints:
1 <= s.length <= 105
s[i] is either '0' or '1'.
 */

package com.leetcode;

public class NumberOfSubstringsWithOnly1s_11 {
    public static void main(String[] args) {
        String s = "111111";

        System.out.println(numSub(s));
    }

    static int numSub(String  s) {
        int MOD = 1_000_000_007;

        long k = 0;
        long count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                k++;
            } else {
                count += (k * (k + 1) / 2);
                k = 0;
            }
        }
        count += (k * (k + 1) / 2);
        return (int) (count % MOD);
    }
}
