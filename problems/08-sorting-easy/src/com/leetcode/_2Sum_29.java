/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */

package com.leetcode;

import java.util.Arrays;

public class _2Sum_29 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    // Note:
// This is the optimal solution without using HashMap.
// Time: O(n log n) due to sorting.
//
// After learning HashMap, Two Sum can be solved in O(n) time
// using a single pass HashMap approach, which is more optimal

    static int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> {
            return a[0] - b[0];
        });

        int start = 0;
        int end = n - 1;
        while (start < end) {
            int sum = pairs[start][0] + pairs[end][0];

            if (sum == target) {
                return new int[] {pairs[start][1], pairs[end][1]};
            }

            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] {};
    }
}
