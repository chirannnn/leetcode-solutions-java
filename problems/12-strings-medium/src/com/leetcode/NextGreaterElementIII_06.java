/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

Example 1:
Input: n = 12
Output: 21

Example 2:
Input: n = 21
Output: -1

Constraints:
1 <= n <= 231 - 1
 */

package com.leetcode;

public class NextGreaterElementIII_06 {
    public static void main(String[] args) {
        int n = 12;

        System.out.println(nextGreaterElement(n));
    }

    static int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int len = arr.length;

        int index = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] - '0' < arr[i + 1] - '0') {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return -1;
        }

        for (int i = len - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                char temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        reverse(arr, index + 1, len - 1);

        long ans = Long.parseLong(new String(arr));
        if (ans > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) ans;
    }

    static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
