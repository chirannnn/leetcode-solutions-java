/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:
Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:
Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16

Constraints:
1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
 */

package com.leetcode;

public class CountNumberOfNiceSubarrays_09 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1}; int k = 3;

        System.out.println(numberOfSubarrays(nums, k));
    }

    static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static int atMost(int[] nums, int k) {
        int n = nums.length;

        int l = 0, r = 0, odd = 0, count = 0;
        while (r < n) {
            if (nums[r] % 2 == 1) odd++;

            while (odd > k) {
                if (nums[l] % 2 == 1) odd--;
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }
}
