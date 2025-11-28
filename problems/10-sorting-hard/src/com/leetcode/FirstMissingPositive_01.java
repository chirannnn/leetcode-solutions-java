/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 */

package com.leetcode;

public class FirstMissingPositive_01 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};

        System.out.println(firstMissingPositive(nums));
    }

    /*
We only care about positive numbers from 1 to n (array length) because:
- 0 and negative numbers cannot be the smallest missing positive.
- Numbers larger than n also cannot be placed in indices 0..n-1.
- Using cyclic sort, we place each valid number at index = number-1.
- After rearranging, the first mismatch gives the smallest missing positive.
*/

    static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index+1) {
                return index+1;
            }
        }
        return nums.length + 1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
