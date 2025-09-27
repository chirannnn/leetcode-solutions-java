/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

Example 1:
Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Example 2:
Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */

package com.leetcode;

public class KthMissingPositiveNumber08 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;

        System.out.println(fintKthPositive(arr, k));
    }

    static int fintKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // this formula calculates how many numbers are missing
            // before arr[mid]
            int missing = arr[mid] - (mid + 1);

            // if missing number before mid are >= k
            // the k th missing must be on the left side (or at mid)
            if (missing >= k) {
                end = mid - 1;
            } else {
                // if missing number before mid < k
                // the kth missing is after mid
                start = mid + 1;
            }
        }

        // Now start = number of present elements before kth missing number
        // k = number of missing number we want
        return start + k;
    }
}
