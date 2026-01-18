/*
Given a string s, return the last substring of s in lexicographical order.

Example 1:
Input: s = "abab"
Output: "bab"
Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".

Example 2:
Input: s = "leetcode"
Output: "tcode"

Constraints:
1 <= s.length <= 4 * 105
s contains only lowercase English letters.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LastSubstringInLexicographicalOrder_02 {
    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(lastSubstring(s));
    }

    static String lastSubstring(String s) {
        int n = s.length();

        char[] ch = s.toCharArray();
        int i = 0, j = 1, k = 0;
        while (j + k < n) {
            if (ch[i + k] < ch[j + k]) {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            } else if (ch[i + k] > ch[j + k]) {
                j += k + 1;
                k = 0;
            } else {
                k++;
            }
        }
        return s.substring(i);
    }
}
