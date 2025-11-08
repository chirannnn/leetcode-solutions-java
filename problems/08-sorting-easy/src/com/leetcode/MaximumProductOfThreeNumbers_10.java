/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6

Example 2:
Input: nums = [1,2,3,4]
Output: 24

Example 3:
Input: nums = [-1,-2,-3]
Output: -6
 */

package com.leetcode;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers_10 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(maximumProduct(nums));
    }

    static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int prod1 = nums[0] * nums[1] * nums[n - 1];
        int prod2 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        return Math.max(prod1, prod2);
    }
}
