/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

  Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 */

package com.leetcode;

public class FindMinimumInRotatedSortedArray05 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(findMin(nums));
    }

    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Case 1: mid element is greater than end → min must be on right
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
            // Case 2: mid element is smaller than end → min could be mid or left
            else if (nums[mid] < nums[end]) {
                end = mid;
            }
            // Case 3: mid equals end → cannot decide which side, shrink search space
            else {
                end--; // only needed if duplicates exist
            }
        }

        // When start == end, we have found the minimum element
        return nums[start];
    }
}
