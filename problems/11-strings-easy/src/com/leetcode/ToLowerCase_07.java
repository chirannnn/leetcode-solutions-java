/*
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"

Example 2:
Input: s = "here"
Output: "here"

Example 3:
Input: s = "LOVELY"
Output: "lovely"

Constraints:
1 <= s.length <= 100
s consists of printable ASCII characters.
 */

package com.leetcode;

public class ToLowerCase_07 {
    public static void main(String[] args) {
        String s = "LOVELY";

        System.out.println(toLowerCase(s));
    }

    static String toLowerCase(String s) {
//        return s.toLowerCase();

        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char) (ch[i] + 32);
            }
        }
        return new String(ch);
    }
}
