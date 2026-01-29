/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

Example 2:
Input: nums = [0,0,0,0,0], goal = 0
Output: 15

Constraints:
1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */

package com.leetcode;

public class BinarySubarraysWithSum_08 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1}; int goal = 2;

        System.out.println(numSubarraysWithSum(nums, goal));
    }

    static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    static int atMost(int[] nums, int k) {
        if (k < 0) return 0;

        int n = nums.length;

        int l = 0, r = 0, sum = 0, count = 0;
        while (r < n) {
            sum += nums[r];

            while (l <= r && sum > k) {
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
