/*
You are given two positive integer arrays nums1 and nums2, both of length n.

The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).

You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.

Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large, return it modulo 109 + 7.

|x| is defined as:

x if x >= 0, or
-x if x < 0.

Example 1:
Input: nums1 = [1,7,5], nums2 = [2,3,5]
Output: 3
Explanation: There are two possible optimal solutions:
- Replace the second element with the first: [1,7,5] => [1,1,5], or
- Replace the second element with the third: [1,7,5] => [1,5,5].
Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.

Example 2:
Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
Output: 0
Explanation: nums1 is equal to nums2 so no replacement is needed. This will result in an
absolute sum difference of 0.

Example 3:
Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
Output: 20
Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 */

package com.leetcode;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference_11 {
    // ====================== 📖 PROBLEM STORY ======================
//
// “We want to minimize the total absolute difference between nums1 and nums2.”
// - Total absolute difference = sum(|nums1[i] - nums2[i]|)
//
// “We are allowed to replace at most ONE element in nums1.”
// - So, we need to find which single element replacement gives the biggest saving.
//
// “Step 1: Calculate base total difference.”
// - This is our starting point (without any replacement).
//
// “Step 2: For each element, find the best replacement in nums1.”
// - Use binary search on sorted nums1 to find the closest value to nums2[i].
// - originalDiff = |nums1[i] - nums2[i]|
// - bestDiff = |closest replacement - nums2[i]|
// - reduction = originalDiff - bestDiff
// - This is how much we can **save** if we replace this element.
//
// “Step 3: Track the maximum saving across all elements.”
// - We can only replace one element, so pick the one giving the biggest reduction.
//
// “Step 4: Subtract max reduction from base total.”
// - baseTotal - maxReduction = minimum absolute sum difference achievable.
//
// “Step 5: Modulo 1e9+7”
// - Required because the result can be very large.
//
// ✅ Key insight:
// - Instead of trying all replacements (brute force), we just find the **closest value** in sorted nums1 for each target in nums2.
// - Only one replacement allowed, so the **max reduction** gives the answer.
//
// ==================================================================

    public static void main(String[] args) {
        int[] nums1 = {1,7,5};
        int[] nums2 = {2,3,5};

        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;

        long baseTotal = 0;
        for (int i = 0; i < n; i++) {
            baseTotal += Math.abs(nums1[i] - nums2[i]);
        }

        // Sort nums1 for binary search (to find closest element fast)
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long maxReduction = 0;
        for (int i = 0; i < n; i++) {
            int originalDiff = Math.abs(nums1[i] - nums2[i]);

            // find the closest element in nums1 to nums2[i]
            int closest = findClosest(sorted, nums2[i]);
            int bestDiff = Math.abs(closest - nums2[i]);

            // how much you save if you replace this element
            long reduction = originalDiff - bestDiff;
            if (reduction > maxReduction) {
                maxReduction = reduction;
            }
        }

        final int MOD = 1_000_000_007;
        return (int) ((baseTotal - maxReduction + MOD) % MOD);

    }

    static int findClosest(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // after loop: start is the right neighbor, end is the left neighbor
        int rightNeighbor = (start < arr.length) ? arr[start] : Integer.MAX_VALUE;
        int leftNeighbor = (end >= 0) ? arr[end] : Integer.MAX_VALUE;

        if (leftNeighbor == Integer.MAX_VALUE) return rightNeighbor;
        if (rightNeighbor == Integer.MAX_VALUE) return leftNeighbor;

        if (Math.abs(leftNeighbor - target) <= Math.abs(rightNeighbor - target)) {
            return leftNeighbor;
        } else {
            return rightNeighbor;
        }
    }

//    static int bruteForce(int[] nums1, int[] nums2) {
        // brute-force
        // int n = nums1.length;
        // int baseTotal = 0;

        // for (int i = 0; i < n; i++) {
        //     baseTotal += Math.abs(nums1[i] - nums2[i]);
        // }

        // int minSum = baseTotal;

        // for (int i = 0; i < n; i++) {
        //     int withOutI = baseTotal - (Math.abs(nums1[i] - nums2[i]));

        //     for (int j = 0; j < n; j++) {
        //         int newTotal = withOutI + (Math.abs(nums1[j] - nums2[i]));

        //         if (newTotal < minSum) {
        //             minSum = newTotal;
        //         }
        //     }
        // }

        // return minSum;
//    }

}
