/*
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Example 2:
Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

Example 3:
Input: mat = [[5]]
Output: 5
 */

package com.leetcode;

public class MatrixDiagonalSum15 {
    public static void main(String[] args) {

//        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] mat = {{5}};
        System.out.println(diagonalSum(mat));
    }

    static int diagonalSum(int[][] mat){
        int n = mat.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += mat[i][i];         //primary diagonal
            total += mat[i][n - 1 - i]; //secondary diagonal
        }

        // If n is odd, the center element is counted twice, subtract it once
        if (n % 2 == 1){
            total -= mat[n/2][n/2];
        }

        return total;
    }
}
