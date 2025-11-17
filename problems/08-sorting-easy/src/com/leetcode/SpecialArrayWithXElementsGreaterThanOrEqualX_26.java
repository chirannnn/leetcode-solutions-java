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

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX_26 {
    public static void main(String[] args) {
        int[] nums = {0,4,3,0,4};

        System.out.println(specialArray(nums));
    }

    static int specialArray(int[] nums) {
        // Step 1: Sort the array so we can binary-search counts easily
        Arrays.sort(nums);

        // Possible x values are from 1 to nums.length
        int start = 1;
        int end = nums.length;

        // Binary search on x (the answer we want to find)
        while (start <= end) {
            int mid = start + (end - start) / 2;   // mid = current x value

            // Count how many numbers in nums are >= mid
            int count = countGreaterOrEqual(nums, mid);

            // If exactly x numbers are >= x → found the answer
            if (count == mid) {
                return mid;
            }

            // If too many numbers are >= x, we need a bigger x
            // Example: count = 5 but mid = 3 → try larger x
            if (count > mid) {
                start = mid + 1;
            }
            // If too few numbers are >= x, x is too big → try smaller x
            else {
                end = mid - 1;
            }
        }

        // If no such x exists
        return -1;
    }

    // Helper function:
    // returns how many values in arr are >= x
    static int countGreaterOrEqual(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        // Binary search for the FIRST index where arr[i] >= x
        // (lower bound search)
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If arr[mid] >= x → possible answer, move left to find first occurrence
            if (arr[mid] >= x) {
                end = mid - 1;
            }
            // If arr[mid] < x → move right
            else {
                start = mid + 1;
            }
        }

        // After loop:
        // 'start' is the first index where arr[start] >= x.
        // So count = total length - start index.
        return arr.length - start;
    }

//    static int brute(int[] nums) {
    //        for (int x = 1; x <= nums.length; x++) {
    //            int count = 0;
    //            for (int num : nums) {
    //                if (num >= x) {
    //                    count++;
    //                }
    //            }
    //
    //            if (count == x) {
    //                return x;
    //            }
    //        }
    //        return -1;
//    }
}
