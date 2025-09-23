/*
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.

Example 1:
Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

Example 2:
Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 */

package com.leetcode;

public class ValidPerfectSquare05 {
    public static void main(String[] args) {
        int num = 8;

        System.out.println(isPerfectSquare(num));
    }

    static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long sqr = (long) mid * mid;

            if (sqr == num) {
                return true;
            }

            if (sqr > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
