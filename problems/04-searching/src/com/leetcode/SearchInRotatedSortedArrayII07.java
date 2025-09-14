/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 */

package com.leetcode;

public class SearchInRotatedSortedArrayII07 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 7;

        boolean ans = search(nums, target);
        System.out.println(ans);
    }

    static boolean search(int[] arr, int target){

        // Pivot + binary search → usually O(log n)
        int pivot = findPivot(arr);
        if (pivot == -1){
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        if (arr[pivot] == target){
            return true;
        }

        if (target >= arr[0]){
            return binarySearch(arr, target, 0, pivot - 1);
        }

        return binarySearch(arr, target, pivot + 1, arr.length - 1);


        // Linear scan → O(n) (worst-case: you look at every element).
//        for (int i = 0; i < arr.length; i++) {
//            if (target == arr[i]){
//                return true;
//            }
//        }
//
//        return false;
    }

    static boolean binarySearch(int[] arr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start) / 2;

            if (target > arr[mid]){
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            }else {
                return true;
            }
        }

        return false;
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(end > mid && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if (mid > start && arr[mid - 1] > arr[mid]){
                return mid - 1;
            }

            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if (end > start && arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                if (end > start && arr[end - 1] > arr[end]){
                    return end - 1;
                }
                end--;
            } else if (arr[mid] > arr[start] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
