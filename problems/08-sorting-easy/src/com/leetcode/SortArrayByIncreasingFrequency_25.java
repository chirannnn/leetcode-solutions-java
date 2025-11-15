/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]
 */

package com.leetcode;

import java.util.Arrays;

public class SortArrayByIncreasingFrequency_25 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};

        System.out.println(Arrays.toString(frequencySort(nums)));
    }
    /*
Problem:
Sort the array by:
1) Increasing frequency (lower frequency comes first)
2) If two numbers have the same frequency → sort them in decreasing order (bigger number first)
*/
    static int[] frequencySort(int[] nums) {
        // STEP 1: Create frequency array of size 201
        // Why 201? Because numbers range from -100 to +100
        // So we shift values by +100 to map them to 0...200
        int[] freq = new int[201];

        for (int num : nums) {
            freq[num + 100]++;
        }

        // STEP 2: Convert primitive int[] to Integer[]
        // Because Arrays.sort with Comparator DOES NOT work on int[]
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // STEP 3: Sort using a custom comparator
        Arrays.sort(arr, (a, b) -> {

            // Case 1: If frequencies are the same
            if (freq[a + 100] == freq[b + 100]) {
                // Sort in DECREASING order when frequency is equal
                // (b - a) → bigger number comes first
                return b - a;
            }
            // Case 2: Frequencies are different
            // Sort in INCREASING frequency order
            // Smaller frequency comes first → (freq[a] - freq[b])
            return freq[a + 100] - freq[b + 100];
        });

        // STEP 4: Copy sorted Integer[] back into int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }
}
