/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10
 */

package com.leetcode;

public class SingleElementInASortedArray02 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};

        System.out.println(singleNonDuplicate(nums));
    }

    static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Check if mid is at the first element of a pair (even index)
            // If mid is even and equals next → pattern is normal → single is on the right
            // If mid is odd and equals previous → pattern is normal → single is on the right
            // Otherwise, pattern breaks → single is on the left (or at mid)
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1] || mid % 2 == 1 && nums[mid] == nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        // When loop ends, start == end → single element found
        return nums[start];
    }
}
