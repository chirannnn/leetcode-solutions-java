/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix01 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println(spiral(matrix));
    }

    static List<Integer> spiral(int[][] mat){
        int top = 0;
        int bottom = mat.length - 1;
        int left = 0;
        int right = mat[0].length - 1;

        List<Integer> list = new ArrayList<>();
        while (top <= bottom && left <= right){

            // left -> right
            for (int i = left; i <= right; i++) {
                list.add(mat[top][i]);
            }
            top++;

            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                list.add(mat[i][right]);
            }
            right--;

            // right -> left
            if (top <= bottom){
                for (int i = right; i >= left; i--) {
                    list.add(mat[bottom][i]);
                }
                bottom--;
            }

            // bottom -> top
            if (left <= right){
                for (int i = bottom; i >= top; i--) {
                    list.add(mat[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
