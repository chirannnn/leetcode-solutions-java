/*
You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.

Example 1:
Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].

Example 2:
Input: n = 6, index = 1,  maxSum = 10
Output: 3
 */

package com.leetcode;

public class MaximumValueAtAGivenIndexInABoundedArray09 {
    public static void main(String[] args) {
        int n = 4;
        int index = 2;
        int maxSum = 6;

        System.out.println(maxValue(n, index, maxSum));
    }

    static int maxValue(int n, int index, int maxSum) {
        int start = 1;
        int end = maxSum;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long sum = calculateSum(mid, n, index);

            if (sum <= maxSum) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    static long calculateSum(int peak, int n, int index) {
        long sum = peak;

        int leftLen = index;
        if (peak > leftLen) {
            sum += (long) ((peak - 1) + (peak - leftLen)) * leftLen / 2;
        } else{
            sum += (long) (peak - 1) * peak / 2 + (leftLen - (peak - 1));
        }

        int rightLen = n - index - 1;
        if (peak > rightLen) {
            sum += (long) ((peak - 1) + (peak - rightLen)) * rightLen / 2;
        } else {
            sum += (long) (peak - 1) * peak / 2 + (rightLen - (peak - 1));
        }

        return sum;
    }

    // if (peak > len) {
    //     // strictly decreasing sequence
    //     // Case 1: Peak is big enough to decrease down to fill all left / right positions
    //     // Formula: sum of arithmetic sequence from (peak - len) to (peak - 1)
    //     // sumSide = (first + last) * number of elements / 2
    //     return (long)(peak - 1 + peak - len) * len / 2;
    // } else {
    //     // decreasing down to 1, then fill remaining with 1s
    //     // Case 2: Peak is too small to fill all left / right positions
    //     // Step 1: decreasing sequence from (peak - 1) down to 1 → sum = (peak - 1) * peak / 2
    //     // Step 2: remaining positions are filled with 1s → len - (peak - 1)
    //     return (long)(peak - 1) * peak / 2 + (len - (peak - 1));
    // }

    // ====================== 📖 ALGORITHM STORY ======================
//
// “Let’s try guessing the peak...”
// - This code doesn’t actually build the full array directly.
// - Instead, it asks: “What if nums[index] was `mid`?”
// - We use Binary Search between 1 (minimum peak) and maxSum (maximum possible peak).
//
// “If this peak is possible, go higher… else go lower.”
// - For each guessed peak, we calculate the **minimum total sum** needed to build
//   a valid "mountain shape" around it:
//     • The peak sits at the given index.
//     • Numbers decrease step by step to the left and right.
//     • If the peak is not tall enough to reach all elements, the remaining spots are filled with 1’s.
//
// “Let’s check if this mountain fits under the budget.”
// - If total sum ≤ maxSum → this peak works, so we try a taller peak.
// - If total sum > maxSum → the peak is too high, try lowering it.
//
// “No need to build the actual array…”
// - We don’t construct the array element by element.
// - Instead, we use arithmetic series formulas to calculate the total required sum efficiently.
//
// “Left slope, peak, right slope — build smart, not brute force.”
// - We conceptually split the array into 3 parts:
//     1. Left slope
//     2. Peak
//     3. Right slope
// - Then sum their contribution using math formulas instead of loops.
//
// “When binary search finishes...”
// - The last valid peak we stored is the **highest peak value** that fits within `maxSum`.
// - This becomes our final `nums[index]` — the maximum value at the given index.
//
// ==================================================================

}
