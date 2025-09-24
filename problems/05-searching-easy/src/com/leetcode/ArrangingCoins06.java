/*
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 */

package com.leetcode;

public class ArrangingCoins06 {
    public static void main(String[] args) {
        int n = 8;

        System.out.println(arrangeCoins(n));
    }

    static int arrangeCoins(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2; // represents a guess for the No.of complete rows.

            long k = mid * (mid + 1) / 2; // is the total No of coins required to build a 'mid' rows.

            if (k == n) {
                return (int) mid;
            }

            if (k > n) {
                end = (int) mid - 1;
            } else {
                start = (int) mid + 1;
            }
        }

        return end; // end is the valid row (start is the invalid guess (too big))


        // brute-force
        // int rows = 1;

        // while (n >= rows) {
        //     n -= rows;
        //     rows++;
        // }

        // return rows - 1;
    }
}
