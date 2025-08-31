/*
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix23 {
    public static void main(String[] args) {
        int[][] matrix = {{3,7,8}, {9,11,13}, {15,16,17}};

        System.out.println(luckyNumber(matrix));
    }

    static List<Integer> luckyNumber(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int colIndex = -1;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min){
                    min = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isLucky = true;
            for(int k = 0; k < m; k++){
                if (matrix[k][colIndex] > min){
                    isLucky = false;
                    break;
                }
            }

            if (isLucky){
                list.add(min);
            }
        }


        return list;
    }
}
