/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */

package com.leetcode;

public class AddBinary_01 {
    public static void main(String[] args) {
        String a = "1010", b = "1011";

        System.out.println(addBinary(a, b));
    }

    static String addBinary(String a, String b) {
        int m = a.length(), n = b.length();

        int i = m - 1, j = n - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0) + carry;

            res.append(sum & 1);
            carry = sum >> 1;
            i--; j--;
        }
        return res.reverse().toString();
    }
}
