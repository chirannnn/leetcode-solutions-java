/*
You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

Example 1:
Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.

Example 2:
Input: nums = [0,0]
Output: -1
Explanation: No numbers fit the criteria for x.
If x = 0, there should be 0 numbers >= x, but there are 2.
If x = 1, there should be 1 number >= x, but there are 0.
If x = 2, there should be 2 numbers >= x, but there are 0.
x cannot be greater since there are only 2 numbers in nums.

Example 3:
Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values that are greater than or equal to 3.
 */

package com.leetcode;

public class SpecialArrayWithXElementsGreaterThanOrEqualX_16 {
    public static void main(String[] args) {
        int[] nums = {0,4,3,0,4};

        System.out.println(specialArray(nums));
    }

    static int specialArray(int[] nums) {

        // We need to find a number x such that:
        // "there are exactly x elements in nums that are >= x"

        // Important: How do we know what values x can take?
        // - x is the count of elements itself, so it cannot be less than 1
        // - and cannot be more than nums.length (since that's the maximum count of elements we can have)
        // That’s why we only check x from 1 to nums.length

        // brute-force
        for (int x = 1; x <= nums.length; x++) {
            int count = 0;

            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }

            // - If exactly x elements are >= x, then this x satisfies the condition
            // - This is what the problem statement is asking for
            if (count == x) {
                return x;
            }
        }

        return -1;
    }
}
