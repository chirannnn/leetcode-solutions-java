/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes04 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeros(matrix);
    }

    static void setZeros(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0){
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColZero){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        for(int[] arr : matrix){
            System.out.println(Arrays.toString(arr));
        }


//        List<Integer> zeroRows = new ArrayList<>();
//        List<Integer> zeroCols = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0){
//                    zeroRows.add(i);
//                    zeroCols.add(j);
//                }
//            }
//        }
//
//        for(int row : zeroRows){
//            for (int i = 0; i < n; i++) {
//                matrix[row][i] = 0;
//            }
//        }
//
//        for(int col : zeroCols){
//            for (int i = 0; i < m; i++) {
//                matrix[i][col] = 0;
//            }
//        }
//
//        for(int[] arr : matrix){
//            System.out.println(Arrays.toString(arr));
//        }
    }
}
