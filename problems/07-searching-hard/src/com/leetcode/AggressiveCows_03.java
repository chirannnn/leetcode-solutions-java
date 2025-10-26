/*
You are given an array with unique elements of stalls[], which denote the positions of stalls. You are also given an integer k which denotes the number of aggressive cows. The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples:

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows in this case is 3, which is the largest among all possible ways.


Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows in this case is 4, which is the largest among all possible ways.


Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
The minimum distance between cows in this case is 1, which is the largest among all possible ways.
 */

package com.leetcode;

import java.util.Arrays;

public class AggressiveCows_03 {
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;

        System.out.println(aggressiveCows(stalls, k));
    }

    /*
🐮 Problem: Aggressive Cows
---------------------------
You are given an array `stalls[]` with unique positions of stalls (unsorted),
and an integer `k` which represents the number of cows.

Your goal:
------------
Place the `k` cows in the stalls such that the **minimum distance** between any two cows
is **as large as possible**.

We need to find that maximum possible minimum distance.

---

🧩 Example:
------------
Input: stalls = [1, 2, 4, 8, 9], k = 3
Output: 3

Explanation:
------------
If we place cows at positions:
- Cow 1 → stall[0] = 1
- Cow 2 → stall[2] = 4
- Cow 3 → stall[3] = 8

Minimum distance between cows = 3 → this is the largest possible among all valid placements.

---

🧠 Intuition:
-------------
This is a **search problem on the answer (distance)** — not a direct binary search on array indices.

We know:
- The smallest possible distance between cows = 1 (closest stalls)
- The largest possible distance = max(stalls) - min(stalls)

Now, the question becomes:
👉 “Is it possible to place `k` cows such that each cow is at least `mid` distance apart?”

If yes → we can try to **increase** the distance (move `start = mid + 1`).
If not → we need to **reduce** the distance (move `end = mid - 1`).

We continue until we find the **largest distance** for which placement is possible.

---

🪜 Step-by-Step Approach:
--------------------------
1️⃣ Sort the stalls → ensures stall positions are in increasing order.
2️⃣ Apply Binary Search:
     - `start = 1`
     - `end = stalls[last] - stalls[0]`
3️⃣ For each `mid` (distance guess), check if we can place all `k` cows using:
     🐄 `canWePlace()` helper:
         - Place the first cow in the first stall.
         - For each next stall, if the gap ≥ `mid`, place the next cow.
         - If all cows are placed → return true.
4️⃣ If placement possible → try for a bigger distance (move `start = mid + 1`).
5️⃣ Else → try for smaller (move `end = mid - 1`).

6️⃣ The last successful `mid` value is our answer.

---

💡 Example Trace:
-----------------
stalls = [1, 2, 4, 8, 9], k = 3
Sorted → [1, 2, 4, 8, 9]

start = 1, end = 8
mid = 4 → Can we place? ✅ (1 → 4 → 8 works)
Try bigger → start = 5
mid = 6 → ❌ cannot place
→ end = 5 - 1 = 4

Answer = 4 (largest distance for which placement was possible).

---

⚙️ Complexity:
--------------
Time → O(n log(max_distance))
Space → O(1)

---

✨ Summary:
------------
We used **Binary Search on the answer** to efficiently find
the maximum minimum distance for placing cows.

This elegant approach avoids brute force checking of all combinations
and leverages the sorted nature of stall positions.

*/

    static int aggressiveCows(int[] stalls, int k) {
        if (stalls.length < k) {
            return -1;
        }

        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canWePlace(stalls, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;

    }

    static boolean canWePlace(int[] stalls, int cows, int dist) {
        int cowCount = 1;
        int currPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - currPosition >= dist) {
                cowCount++;
                currPosition = stalls[i];
            }

            if (cowCount == cows) {
                return true;
            }
        }
        return false;
    }
}
