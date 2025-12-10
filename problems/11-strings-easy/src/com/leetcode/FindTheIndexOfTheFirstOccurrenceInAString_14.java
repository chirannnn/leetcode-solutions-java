/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */

package com.leetcode;

public class FindTheIndexOfTheFirstOccurrenceInAString_14 {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(strStr(haystack, needle));
    }

    static int strStr(String haystack, String needle) {
        // method 1
        int n = haystack.length();
        int m = needle.length();

        if (m > n) {
            return -1;
        }

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }
        return -1;


        // method 2
//        int n = haystack.length();
//        int m = needle.length();
//        for (int i = 0; i <= n - m; i++) {
//            if (haystack.charAt(i) == needle.charAt(0)) {
//                if (haystack.substring(i, m + i).equals(needle)) {
//                    return i;
//                }
//            }
//        }
//        return -1;

        // method 3
//        return haystack.indexOf(needle);
    }
}
