/*
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.

The right interval for an interval i is an interval j such that startj >= endi and startj is minimized. Note that i may equal j.

Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

Example 1:
Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:
Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.

Example 3:
Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
*/

package com.leetcode;

import java.util.Arrays;

public class FindRightInterval07 {
    public static void main(String[] args) {

        /*
        Problem: Find Right Interval

        - Each interval has a start and end: [start, end]
        - For each interval, we want to find the "right interval":
          1. A right interval is an interval whose start >= current interval's end
             (it comes **after or at the end** of the current interval on the number line)
          2. Among all possible right intervals, pick the one with the **smallest start**
             (the closest interval to the right)
          3. If no right interval exists, use -1
         */

        int[][] intervals = {{3,4}, {2,3}, {1,2}};

        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    static int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int minStart = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < n; j++) {
                int start = intervals[j][0];

                if (start >= end && start < minStart) {
                    index = j;
                    minStart = start;
                }
            }

            result[i] = index;
        }

        return result;
    }
}
