/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:
Input: nums = [10,2]
Output: "210"

Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330"
 */

package com.leetcode;

import java.util.Arrays;

public class LargestNumber_07 {
    public static void main(String[] args) {
        int[] nums = {10,2};

        System.out.println(largestNumber(nums));
    }

    static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String str : arr) {
            result.append(str);
        }
        return result.toString();
    }
}
