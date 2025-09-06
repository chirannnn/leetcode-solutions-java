/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */

package com.leetcode;

import java.util.Arrays;

public class RotateArray08 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        System.out.println(Arrays.toString(rotate(nums, k)));
    }

    static int[] rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n;

        // optimal
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        return nums;

        // brute-force
//        for (int i = 0; i < k; i++) {
//            int last = nums[n - 1];
//            for (int j = n - 1; j > 0 ; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[0] = last;
//        }
//        return nums;
    }

    static int[] reverse(int[] arr, int start, int end){
        while (end > start){
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
