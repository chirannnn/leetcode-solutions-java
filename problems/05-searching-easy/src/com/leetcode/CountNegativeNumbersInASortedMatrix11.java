/*
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0
 */

package com.leetcode;

public class CountNegativeNumbersInASortedMatrix11 {
    public static void main(String[] args) {
        int[][] grid = {{3,2}, {1,0}};

        System.out.println(countNegatives(grid));
    }

    static int countNegatives(int[][] grid) {

        int rows = grid.length - 1;
        int cols = grid[0].length - 1;

        int rStart = 0;
        int cStart = cols;
        int count = 0;

        while (rStart <= rows && cStart >= 0) {
            if (grid[rStart][cStart] < 0) {
                count = count + (rows - rStart + 1); // count += (rows - rStart + 1)
                cStart--;
            } else {
                rStart++;
            }
        }

        return count;


        // brute-force
//        int count = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] < 0) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
    }
}
