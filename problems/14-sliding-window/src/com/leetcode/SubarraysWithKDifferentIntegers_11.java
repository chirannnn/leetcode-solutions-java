/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]

Example 2:
Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

Constraints:
1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
 */

package com.leetcode;

public class SubarraysWithKDifferentIntegers_11 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3}; int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k));
    }

    static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static int atMost(int[] nums, int k) {
        int n = nums.length;

        int[] hash = new int[n + 1];
        int l = 0, r = 0, distinct = 0, count = 0;
        while (r < n) {
            if (hash[nums[r]] == 0) distinct++;
            hash[nums[r]]++;

            while (distinct > k) {
                hash[nums[l]]--;
                if (hash[nums[l]] == 0) distinct--;
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }
}
