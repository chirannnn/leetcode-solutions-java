/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that
the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

---

Example 1:
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation:
Possible splits:
[7,2,5] | [10,8] → largest sum = 18 ✅
[7,2] | [5,10,8] → largest sum = 23
[7] | [2,5,10,8] → largest sum = 25
→ Minimum possible largest sum = 18

Example 2:
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation:
Best split: [1,2,3] | [4,5]
Largest sum among subarrays = 9
*/

package com.leetcode;

public class SplitArrayLargestSum_06 {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        // Output: Minimum possible largest subarray sum
        System.out.println(splitArray(nums, k));
    }

    /*
🧠 Problem Intuition:
---------------------
We need to split the array into k contiguous parts such that the *maximum subarray sum* is minimized.

It’s similar to “Book Allocation Problem” — we’re finding the smallest possible “largest” sum.

---

🎯 Goal:
--------
Find the minimal possible largest subarray sum when nums[] is split into k parts.

---

🪜 Approach (Binary Search on Answer):
--------------------------------------
1️⃣ Define the search space:
   - start = max(nums) → at least one subarray will have the largest single element.
   - end = sum(nums) → one subarray holds everything.

2️⃣ Binary Search:
   - mid = (start + end) / 2
   - Check if we can split the array into ≤ k subarrays with each having sum ≤ mid.

3️⃣ Greedy Check:
   - Iterate through nums, accumulate sum.
   - If sum + current element > mid → start a new subarray (pieces++).
   - If pieces > k → not possible with this mid.

4️⃣ Adjust range:
   - If too many subarrays → increase mid (start = mid + 1)
   - Else → mid might be valid, try smaller (end = mid)

5️⃣ When loop ends → start == end = minimized largest sum.

---

✅ Example Walkthrough:
------------------------
nums = [7,2,5,10,8], k = 2
start = 10, end = 32

mid = 21 → possible (splits: [7,2,5,10] [8])
mid = 15 → not possible
mid = 18 → possible ✅
→ answer = 18

---

⚙️ Complexity:
--------------
Time  → O(n log(sum(nums)))
Space → O(1)

---

✨ Summary:
-----------
Classic **Binary Search on the feasible answer** problem.
Use greedy partitioning to check if a target “max sum” is possible,
and narrow down the range efficiently.
*/

    static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        // Initialize binary search range
        for (int num : nums) {
            start = Math.max(start, num); // minimum possible largest sum
            end += num; // maximum possible largest sum
        }

        // Binary Search for minimum largest sum
        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 1;

            // Try splitting array with limit = mid
            for (int num : nums) {
                if (sum + num > mid) {
                    pieces++;
                    sum = num; // start new subarray
                } else {
                    sum += num;
                }
            }

            // Adjust search space
            if (pieces > k) {
                start = mid + 1; // too many splits → increase limit
            } else {
                end = mid; // possible → try smaller limit
            }
        }

        return end; // minimized largest subarray sum
    }
}
