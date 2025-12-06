/*
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

Example 1:
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.

Example 2:
Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.

Constraints:
2 <= s.length <= 1000
s.length is even.
s consists of uppercase and lowercase letters.
 */

package com.leetcode;

public class DetermineIfStringHalvesAreAlike_08 {
    public static void main(String[] args) {
        String s = "Failure";

        System.out.println(halvesAreAlike(s));
    }

    static boolean halvesAreAlike(String s) {
        // method 1
        int n = s.length();
        int mid = n / 2;
        return vowelsCount(s, 0, mid - 1) == vowelsCount(s, mid, n - 1);

        // method 2
//        int n = s.length();
//        int mid = n / 2;
//
//        int count = 0;
//        for (int i = 0; i < mid; i++) {
//            char ch1 = s.charAt(i);
//            char ch2 = s.charAt(i + mid);
//
//            if ("aeiouAEIOU".indexOf(ch1) != -1) {
//                count++;
//            }
//            if ("aeiouAEIOU".indexOf(ch2) != -1) {
//                count--;
//            }
//        }
//        return count == 0;
    }

    static int vowelsCount(String s, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            char ch = s.charAt(i);
            if ("aeiouAEIOU".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}
