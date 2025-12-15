/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

Constraints:
1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */

package com.leetcode;

public class MergeStringsAlternately_21 {
    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";

        System.out.println(mergeAlternately(word1, word2));
    }

    static String mergeAlternately(String word1, String word2) {
        // method 1
//        int n = word1.length();
//        int m = word2.length();
//
//        int min = Math.min(n, m);
//        int i = 0;
//        StringBuilder ans = new StringBuilder();
//        while (i < min) {
//            ans.append(word1.charAt(i));
//            ans.append(word2.charAt(i));
//            i++;
//        }
//
//        if (n > min) {
//            ans.append(word1.substring(i));
//        } else if (m > min) {
//            ans.append(word2.substring(i));
//        }
//        return ans.toString();


        //method 2
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                ans.append(word1.charAt(i));
                i++;
            }

            if (j < word2.length()) {
                ans.append(word2.charAt(j));
                j++;
            }
        }
        return ans.toString();
    }
}
