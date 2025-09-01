/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

package com.leetcode;

public class MaximumSubarray24 {
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums){

        // optimal - Kadane’s Algorithm
        int n = nums.length;

        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {

            if (currSum + nums[i] > nums[i]){
                currSum = currSum + nums[i];
            }else {
                currSum = nums[i];
            }

            if (currSum > maxSum){
                maxSum = currSum;
            }
        }
        return maxSum;
    }
}
