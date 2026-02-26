/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:
Input: nums = [-1,0]
Output: [-1,0]

Example 3:
Input: nums = [0,1]
Output: [1,0]

Constraints:
2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.
 */

package com.leetcode;

import java.util.Arrays;

public class SingleNumberIII_04 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};

        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    static int[] singleNumber(int[] nums) {
        int XOR = 0;
        for (int num : nums) {
            XOR ^= num;
        }

        int rightMostSetBit = (XOR & (XOR - 1)) ^ XOR;

        int n1 = 0, n2 = 0;
        for (int num : nums) {
            if ((num & (rightMostSetBit)) == 0) {
                n1 ^= num;
            } else {
                n2 ^= num;
            }
        }
        return new int[] {n1, n2};
    }
}
