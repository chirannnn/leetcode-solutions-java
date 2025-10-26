/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

package com.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays_01 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /*
⚖️ Problem: Median of Two Sorted Arrays
---------------------------------------
We are given two sorted arrays `nums1` and `nums2`, and we need to find their median
as if they were merged into a single sorted array — without actually merging them.

Goal:
Return the median in O(log(min(m, n))) time complexity.

---

🧩 Real-World Analogy:
----------------------
Imagine two sorted queues of numbers placed side by side.
You want to find the "middle" element of both queues combined,
but without physically joining them — just by peeking cleverly!

We’ll use **binary search** on the smaller array to decide how to “split” both arrays
so that the left halves contain exactly half of the elements.

---

🧠 Intuition:
-------------
If we cut both arrays into left and right parts:
  Left Part:  contains smaller half of all numbers
  Right Part: contains larger half of all numbers

For the median to be correct:
  - Every element in the left parts ≤ every element in the right parts
  - The total number of elements in left parts = total number in right parts (or 1 more if odd)

So, we just need to find a partition that satisfies these conditions.

---

🪜 Step-by-Step Plan:
---------------------
1️⃣ Always perform binary search on the smaller array (`nums1`) to minimize complexity.

2️⃣ Choose a partition index `partitionX` in `nums1`.
     The corresponding partition in `nums2` will be `(x + y + 1) / 2 - partitionX`
     (so total left elements = total right elements).

3️⃣ Find four key values around the partitions:
     - maxLeftX, minRightX  → boundaries around partition in nums1
     - maxLeftY, minRightY  → boundaries around partition in nums2

4️⃣ Check if partitions are perfect:
     - Condition: maxLeftX ≤ minRightY && maxLeftY ≤ minRightX
       ✅ If true → we found the correct median split.
       - If total length is even → median = (max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2
       - If odd → median = max(maxLeftX, maxLeftY)

5️⃣ If not perfect:
     - If maxLeftX > minRightY → move search left (too far right).
     - Else → move search right (too far left).

---

💡 Example Walkthrough:
-----------------------
nums1 = [1, 3]
nums2 = [2]

Total length = 3 → median should be 2.

Binary Search:
- partitionX = 1 → partitionY = 1
- Left parts: [1] and [2]
- Right parts: [3] and []
  → maxLeftX = 1, minRightX = 3, maxLeftY = 2, minRightY = +∞

✅ Condition holds → median = max(1, 2) = 2.

---

⚙️ Complexity:
--------------
Time  → O(log(min(m, n)))   (binary search on smaller array)
Space → O(1)

---

✨ Summary:
------------
We used Binary Search on partitions instead of merging arrays.
This is a clean, optimal, and elegant solution that leverages
the sorted property of both arrays for logarithmic efficiency.
*/


    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = x;

        while (start <= end) {
            int partitionX = start + (end - start) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxleftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxleftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    int mid1 = Math.max(maxleftX, maxLeftY);
                    int mid2 = Math.min(minRightX, minRightY);

                    return (mid1 + mid2) / 2.0;
                } else {
                    return (Math.max(maxleftX, maxLeftY));
                }
            } else if (maxleftX > minRightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();

        // brute-force
//        int m = nums1.length;
//        int n = nums2.length;
//
//        int[] merged = new int[m + n];
//
//        for (int i = 0; i < m; i++) {
//            merged[i] = nums1[i];
//        }
//        for (int i = 0; i < n; i++) {
//            merged[m + i] = nums2[i];
//        }
//
//        Arrays.sort(merged);
//        int totalLength = merged.length;
//
//        if (totalLength % 2 == 1) {
//            return merged[totalLength / 2];
//        } else {
//            int mid1 = merged[totalLength / 2];
//            int mid2 = merged[totalLength / 2 - 1];
//
//            return (mid1 + mid2) / 2.0;
//        }
    }
}
