/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

Example 1:
Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.

Example 2:
Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 */

package com.leetcode;

import java.util.Arrays;

public class FindAPeakElementII_13 {
    public static void main(String[] args) {
        int[][] mat = {{1,4}, {3,3}};

        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }

    /*
        Approach: Binary Search on Columns (Optimal: O(m * log n))

        Story / Intuition:
        -----------------
        Imagine you are in a 2D matrix where each cell has a number. A "peak" is a cell that is
        bigger than its neighbors (up, down, left, right). Instead of checking every cell,
        we can use a smart "divide-and-conquer" strategy.

        Step 1: Pick the middle column.
        Step 2: Find the maximum element in this column (we only care about this column for now).
        Step 3: Compare this max with its left and right neighbors.
            - If it is bigger than both neighbors, it's a peak! ✅
            - If the left neighbor is bigger, move search to left half.
            - If the right neighbor is bigger, move search to right half.
        Step 4: Repeat until we find a peak.

        Why this works:
        ----------------
        - There are no equal adjacent cells.
        - There is always at least one peak in the matrix.
        - Moving toward the larger neighbor guarantees we move toward a peak.
    */

    static int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int midCol = left + (right - left) / 2;

            int maxRow = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int midValue = mat[maxRow][midCol];

            int leftNeighbor = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : -1;
            int rightNeighbor = (midCol + 1 < n) ? mat[maxRow][midCol + 1] : -1;

            if (midValue > leftNeighbor && midValue > rightNeighbor) {
                return new int[]{maxRow, midCol};
            }

            if (leftNeighbor > midValue) {
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
        }

        return new int[]{-1, -1};


        // brute - force
        // int m = mat.length;
        // int n = mat[0].length;

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         int top = (i > 0) ? mat[i - 1][j] : -1;
        //         int bottom = (i < m - 1) ? mat[i + 1][j] : -1;
        //         int right = (j < n - 1) ? mat[i][j + 1] : -1;
        //         int left = (j > 0) ? mat[i][j - 1] : -1;

        //         if (mat[i][j] > top && mat[i][j] > bottom && mat[i][j] > right && mat[i][j] > left) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }

        // return new int[]{-1, -1};
    }
}
