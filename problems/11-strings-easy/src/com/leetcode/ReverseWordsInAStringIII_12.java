/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "Mr Ding"
Output: "rM gniD"

Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
 */

package com.leetcode;

public class ReverseWordsInAStringIII_12 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        System.out.println(reverseWords(s));
    }

    static String reverseWords(String s) {
        // method 1
        char[] arr = s.toCharArray();
        int n = arr.length;

        int start = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (i == n || arr[i] == ' ') {
                int end = i - 1;

                while (start < end) {
                    char temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
                start = i + 1;
            }
        }
        return new String(arr);


        // method 2
//        String[] arr = s.split(" ");
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new StringBuilder(arr[i]).reverse().toString();
//        }
//        return String.join(" ", arr);
    }
}
