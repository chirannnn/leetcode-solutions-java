/*
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

Example 1:
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Example 2:
Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Example 3:
Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 */

package com.leetcode;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber_20 {
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;

        int[] copy = nums.clone();
        Arrays.sort(copy);

        int[] ranks = new int[n];
        ranks[0] = 0;
        for (int i = 1; i < n; i++) {
            if (copy[i] != copy[i - 1]) {
                ranks[i] = i;
            } else {
                ranks[i] = ranks[i - 1];
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int index = search(copy ,nums[i]);
            result[i] = ranks[index];
        }
        return result;
    }

    static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
