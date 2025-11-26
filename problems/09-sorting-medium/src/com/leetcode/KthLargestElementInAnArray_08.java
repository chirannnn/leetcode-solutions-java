/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */

package com.leetcode;

import java.util.Arrays;

public class KthLargestElementInAnArray_08 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }

    static int findKthLargest(int[] nums, int k) {

        // ✅ This is my current solution – simple and correct
        // I'm sorting the whole array, then picking the kth element from the end.

        // 💡Later, after learning more, I will improve it using:
        // - Quick Select (faster, average O(n))
        // - Min Heap using Priority Queue (one-pass style, O(n log k))
        // Both work without using built-in sorting.

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
