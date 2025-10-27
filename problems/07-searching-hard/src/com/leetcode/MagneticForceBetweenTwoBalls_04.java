/*
In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

Example 1:
Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.

Example 2:
Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.
 */

package com.leetcode;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls_04 {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;

        System.out.println(maxDistance(position, m));
    }

    /*
🐣 Problem: Magnetic Force Between Two Balls
--------------------------------------------
Rick has `n` baskets placed at certain positions and Morty needs to place `m` balls in them.
Each pair of balls has a "magnetic force" defined as |x - y| (the absolute distance between their positions).

Goal:
-----
Place the `m` balls such that the **minimum magnetic force** between any two balls is **as large as possible**.

We must find the maximum possible value of this minimum distance.

---

🧠 Intuition:
-------------
This problem is identical in spirit to the classic **Aggressive Cows** problem.

We can think of "magnetic force" as "distance between cows" — and we need to **maximize the smallest gap**.

We’ll use **Binary Search on Answer** to efficiently find that largest minimum force.

---

🪜 Step-by-Step Approach:
--------------------------
1️⃣ **Sort** the basket positions to make distance calculations easier.
2️⃣ Define search space:
     - `start = 1` (smallest possible gap)
     - `end = position[n-1] - position[0]` (largest possible gap)
3️⃣ Apply Binary Search:
     - For each `mid` (candidate distance), check if it’s possible to place `m` balls
       such that every pair of consecutive balls has at least `mid` distance.
     - Use helper `maxDist()`:
         - Place the first ball in the first basket.
         - For each next basket:
              If distance ≥ `mid`, place next ball.
         - If all `m` balls are placed → valid placement.
4️⃣ If placement is possible → try for **larger** gap (`start = mid + 1`).
   Else → try for **smaller** gap (`end = mid - 1`).
5️⃣ The last successful `mid` value is our final answer.

---

✅ Example:
-----------
Input: position = [1,2,3,4,7], m = 3
Sorted → [1,2,3,4,7]

Binary search:
mid = 3 → possible (balls at 1, 4, 7)
mid = 4 → not possible
→ answer = 3

---

⚙️ Complexity:
--------------
Time  → O(n log(maxDistance))
Space → O(1)

---

✨ Summary:
-----------
This is a **Binary Search on the answer** pattern problem.
We maximize the *minimum feasible distance* using greedy placement
and an efficient search strategy.
*/


    static int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int start = 1;
        int end = position[n - 1] - position[0];
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canPlace(position, m, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;

    }

    static boolean canPlace(int[] positions, int balls, int dist) {
        int currBalls = 1;
        int currPosition = positions[0];

        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - currPosition >= dist) {
                currBalls++;
                currPosition = positions[i];
            }

            if (currBalls == balls) {
                return true;
            }
        }
        return false;

    }
}
