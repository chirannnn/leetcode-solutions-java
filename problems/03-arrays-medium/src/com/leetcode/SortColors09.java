/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 */

package com.leetcode;

import java.util.Arrays;

public class SortColors09 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        System.out.println(Arrays.toString(sort(nums)));
    }

    static int[] sort(int[] nums){

        // optimal - Dutch national flag algo
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 2){
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }else {
                mid++;
            }
        }

        return nums;

        // brute-force (two-pass)
//        int count0 = 0;
//        int count1 = 0;
//        int count2 = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) count0++;
//            else if(nums[i] == 1) count1++;
//            else count2++;
//        }
//
//        int index = 0;
//        while (count0 --> 0) nums[index++] = 0;
//        while (count1 --> 0) nums[index++] = 1;
//        while (count2 --> 0) nums[index++] = 2;
//        return nums;

        /*
        above loop and the below loop are the same
        while(count0 > 0){
            nums[index] = 0;
            index++;
            count0--;
        }
         */

    }
}
