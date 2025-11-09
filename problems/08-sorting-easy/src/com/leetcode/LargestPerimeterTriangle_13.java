/*
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

Example 1:
Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.

Example 2:
Input: nums = [1,2,1,10]
Output: 0
Explanation:
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
 */

package com.leetcode;

import java.util.Arrays;

public class LargestPerimeterTriangle_13 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,10};

        System.out.println(largestPerimeter(nums));
    }

    static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = n - 1; i >=2; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];

            if (b + c > a) {
                return a + b + c;
            }
        }
        return 0;
    }
}
