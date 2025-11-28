/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.

Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */

package com.leetcode;

public class FindTheDuplicateNumber_09 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        System.out.println(findDuplicate(nums));
    }

    static int findDuplicate(int[] nums) {
        //Floyd's Tortoise and Hare algorithm
        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;


        // cyclic sort
//        int i = 0;
//        while (i < nums.length) {
//            int correctIndex = nums[i] - 1;
//            if (nums[i] != nums[correctIndex]) {
//                swap(nums, i, correctIndex);
//            } else {
//                i++;
//            }
//        }
//
//        for (int index = 0; index < nums.length; index++) {
//            if (nums[index] != index+1) {
//                return nums[index];
//            }
//        }
//        return -1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
