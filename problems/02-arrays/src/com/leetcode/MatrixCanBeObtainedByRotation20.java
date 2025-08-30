/*
Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Example 1:
Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

Example 2:
Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.

Example 3:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
 */

package com.leetcode;

public class MatrixCanBeObtainedByRotation20 {
    public static void main(String[] args) {
        int[][] mat = {{0,1}, {1,1}};
        int[][] target = {{1,0}, {0,1}};

        System.out.println(findRotation(mat, target));
    }

    static boolean findRotation(int[][] mat, int[][] target){
        int n = mat.length;

        // Try 4 rotations (0°, 90°, 180°, 270°)
        for (int r = 0; r < 4; r++) {
            if (isSame(mat, target, n)){
                return true;
            }
            mat = rotate90(mat, n);
        }
        return false;
    }

    // Rotate matrix 90 degrees clockwise
    static int[][] rotate90(int[][] mat, int n){
        int[][] rotateArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotateArr[i][j] = mat[n - 1 - j][i];
            }
        }
        return rotateArr;
    }

    // Compare two matrices
    static boolean isSame(int[][] a, int[][] b, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
