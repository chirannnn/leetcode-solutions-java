/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99

Constraints:
1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 */

package com.leetcode;

public class SingleNumberII_03 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};

        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        // method 1
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;


        // method 2
//        int[] arr = new int[32];
//        for (int num : nums) {
//            for (int i = 0; i < 32; i++) {
//                arr[i] += (num & 1);
//                num >>= 1;
//            }
//        }
//
//        int ans = 0;
//        for (int i = 0; i < 32; i++) {
//            if (arr[i] % 3 != 0) {
//                ans = (1 << i) | ans;
//            }
//        }
//        return ans;
    }
}
