/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

package com.leetcode;

import java.util.Arrays;

public class MajorityElement_02 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};

        System.out.println(majorityElement(nums));
    }

    static int majorityElement(int[] nums) {

        // Boyer–Moore majority vote algorithm
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;


//        Arrays.sort(nums);
//        return nums[nums.length /  2];
    }
}
