/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:
Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_05 {
    public static void main(String[] args) {
        int[][] intervals = {{4,7}, {1,4}};

        int[][] result = merge(intervals);

        for (int[] arr : result) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    static int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int index = 0;
        List<int[]> list = new ArrayList<>();
        while (index < n) {
            int currEnd = intervals[index][1];
            int newStart = intervals[index][0];
            while (index < n - 1 && currEnd >= intervals[index + 1][0]) {
                currEnd = Math.max(currEnd, intervals[index + 1][1]);
                index++;
            }
            list.add(new int[] {newStart, currEnd});
            index++;
        }

        index = 0;
        int[][] ans = new int[list.size()][2];
        for (int[] arr : list) {
            ans[index++] = arr;
        }
        return ans;
    }
}
