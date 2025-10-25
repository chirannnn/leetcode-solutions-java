/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

Example 1:
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2:
Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

Example 3:
Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
 */

package com.leetcode;

public class CapacityToShipPackagesWithinDDays_16 {
    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4;

        System.out.println(shipWithinDays(weights, days));
    }

    /*
    🧩 Problem Understanding:
    -------------------------
    We are given an array `weights[]`, where each element represents the weight of a package.
    The ship must carry packages **in the same order** and deliver them within `days` days.

    We need to find the **minimum possible ship capacity** that makes this possible.

    🧠 Real-World Analogy:
    ----------------------
    Imagine you’re a ship captain shipping boxes to different islands.
    Each day, you can only carry up to a certain weight (the ship’s capacity).
    You must deliver all boxes in `days` days — no skipping or reordering!
    The goal is to find the *smallest ship* that can still finish the work on time. 🚢
    */

    /*
    🪜 Approach: Binary Search on the Answer
    ----------------------------------------
    Instead of guessing the capacity randomly, we search over a range of possible capacities.

    1️⃣ Search Space:
        - Minimum capacity = max(weights)
          → Because the ship must at least carry the heaviest package.
        - Maximum capacity = sum(weights)
          → Because one ship can carry everything in a single day.

    2️⃣ Binary Search Logic:
        - Guess a mid-capacity (`mid`).
        - Try shipping packages with this capacity.
        - Count how many days it takes.
          - If daysNeeded > days → ship too small → increase capacity.
          - Else → ship can handle it → try smaller capacity.

    3️⃣ Stopping Condition:
        - Loop continues until `start == end`.
        - That value is the **minimum ship capacity** required.

    💡 Example Walkthrough (weights = [1,2,3,1,1], days = 4):
        - start = 3, end = 8
        - mid = 5 → takes 3 days → possible → try smaller → end = 5
        - mid = 4 → takes 3 days → possible → end = 4
        - mid = 3 → takes 4 days → possible → end = 3 ✅
        → Minimum capacity = 3

    🧮 Complexity:
    --------------
    Time:  O(n * log(sum(weights)))   // Binary search with linear check
    Space: O(1)
    */
    static int shipWithinDays(int[] weights, int days) {

        int start = 0;
        int end = 0;

        for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }

        while (start < end) {
            int mid = start + (end - start) / 2; // Current capacity

            int currentLoad = 0;
            int dayNeeded = 1;
            for (int weight : weights) {
                if (currentLoad + weight > mid) {
                    currentLoad = weight;
                    dayNeeded++;
                } else {
                    currentLoad += weight;
                }
            }

            if (dayNeeded > days) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
