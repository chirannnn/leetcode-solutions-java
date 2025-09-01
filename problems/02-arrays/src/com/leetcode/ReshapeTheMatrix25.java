/*
In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Example 2:
Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 */

package com.leetcode;

import java.util.Arrays;

public class ReshapeTheMatrix25 {
    public static void main(String[] args) {
        int[][] mat = {{1,2}, {3,4}};
        int r = 2;
        int c = 4;

        int[][] ans = reshape(mat, r, c);
        for (int[] arr : ans){
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] reshape(int[][] mat, int r, int c){
        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) return mat;

        int[][] ans = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[row][col] = mat[i][j];
                col++;

                if (col == c){
                    col = 0;
                    row++;
                }
            }
        }
        return ans;
    }
}
