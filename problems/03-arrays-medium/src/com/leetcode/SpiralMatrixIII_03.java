/*
You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.

Example 1:
Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Example 2:
Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 */

package com.leetcode;

import java.util.Arrays;

public class SpiralMatrixIII_03 {
    public static void main(String[] args) {
        int rows = 5; int cols = 6; int rStart = 1; int cStart = 4;

        int[][] ans = spiral3(rows, cols, rStart, cStart);
        for (int[] arr : ans){
            System.out.print(Arrays.toString(arr) + " ");
        }
    }

    static int[][] spiral3(int rows, int cols, int rStart, int cStart){
        int total = rows * cols;
        int[][] result = new int[total][2];

        result[0][0] = rStart;
        result[0][1] = cStart;

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int index = 0;
        int dir = 0;
        int steps = 1;

        while (index + 1 < total){
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {

                    rStart += dirs[dir][0];
                    cStart += dirs[dir][1];
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                        index++;
                        result[index][0] = rStart;
                        result[index][1] = cStart;

                        if (index + 1 == 0) return result;
                    }
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }
        return result;
    }
}
