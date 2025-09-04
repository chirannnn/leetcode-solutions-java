/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]
 */

package com.leetcode;

import java.util.Arrays;

public class SpiralMatrixII_02 {
    public static void main(String[] args) {
        int n = 3;

        int[][] ans = spiral2(n);
        for(int[] arr : ans){
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] spiral2(int n){
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int[][] mat = new int[n][n];
        int num = 1;
        while (top <= bottom && left <= right){

            // left -> right
            for (int i = left; i <=right; i++) {
                mat[top][i] = num;
                num++;
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = num;
                num++;
            }
            right--;

            // right -> left
            if (top <= bottom){
                for (int i = right; i >=left; i--) {
                    mat[bottom][i] = num;
                    num++;
                }
                bottom--;
            }

            //bottom -> top
            if (left <= right){
                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return mat;
    }
}
