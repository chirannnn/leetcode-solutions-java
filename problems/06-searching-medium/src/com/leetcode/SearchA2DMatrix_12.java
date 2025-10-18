/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */

package com.leetcode;

public class SearchA2DMatrix_12 {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }

    static boolean searchMatrix(int[][] matrix, int target) {

        // Binary Search on Flattened 2D Matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0; // starting index of our virtual 1D array
        int end = rows * cols - 1;  // ending index (total elements - 1)

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Convert the 1D mid index into 2D row and column
            // mid / cols → gives row index (how many rows are filled before mid)
            // mid % cols → gives column index (position inside that row)
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            }

            if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;


        // Staircase Search / Row-Column Search
        // int row = 0;
        // int col = matrix[row].length - 1;

        // while (row < matrix.length && col >= 0) {
        //     if (matrix[row][col] == target) {
        //         return true;
        //     }

        //     if (matrix[row][col] > target) {
        //         col--;
        //     } else {
        //         row++;
        //     }
        // }

        // return false;
    }
}
