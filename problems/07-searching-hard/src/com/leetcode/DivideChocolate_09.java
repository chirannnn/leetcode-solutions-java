/*
You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the
array sweetness.

You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces
using K cuts, each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your
friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.

Example 1:
Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

Example 2:
Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.

Example 3:
Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]

Constraints:

    0 <= K < sweetness.length <= 10^4
    1 <= sweetness[i] <= 10^5
 */

package com.leetcode;

public class DivideChocolate_09 {
    public static void main(String[] args) {
        int[] sweetness = {1,2,2,1,2,2,1,2,2};
        int k = 2;

        System.out.println(maximizeSweetness(sweetness, k));
    }

    /*
🧠 Problem Intuition:
---------------------
We have a chocolate bar made of chunks, each with sweetness.
We must cut it into K+1 contiguous pieces and give K pieces to friends.
We keep the *minimum sweetness piece* for ourselves 😎

We want that minimum piece to be as sweet as possible.
So we will cut smartly to **maximize the minimum sweetness we get**.

---

🎯 Goal:
--------
Maximize the minimum possible sweetness among the (K+1) pieces.

Equivalent viewpoint:
✅ We want to make as many pieces as possible where each piece has sweetness ≥ X
✅ Find the largest X for which this is possible

This is **Binary Search on Answer**.

---

🪜 Approach (Binary Search on Sweetness Value):
-----------------------------------------------
1️⃣ Search space of sweetness we can get:
   - start = 1                → smallest sweetness possible
   - end = sum(sweetness[])   → if we all cut nothing (one piece)

2️⃣ Binary Search on X (our sweetness):
   mid = (start + end) / 2

3️⃣ Feasibility Check (Greedy):
   - try to create pieces each having sweetness ≥ mid
   - accumulate sweetness
   - when sum ≥ mid → cut here (we got one valid piece)
   - count how many pieces we can form

4️⃣ Adjust range:
   - If pieces ≥ K+1 → mid is achievable ✔️
       → try to increase (start = mid + 1)
   - Else → mid too high ❌
       → decrease (end = mid - 1)

5️⃣ Final answer = best successful mid

---

✅ Example:
-----------
sweetness = [1,2,3,4,5,6,7,8,9], K = 5
We need 6 pieces total.

If we try mid = 6:
Pieces formed = [1,2,3] [4,5] [6] [7] [8] [9] → 6 pieces ✅
So 6 sweetness possible.

Try higher until it breaks → returns 6.

---

⚙️ Complexity:
--------------
Time  → O(n log(sum))
Space → O(1)

---

✨ Summary:
-----------
Classic **maximize the minimum** using Binary Search on feasible sweetness.
Greedy counting helps us test if a sweetness target is achievable.
Optimal chocolate sharing with maximum self-benefit 😋🍫
*/

    static int maximizeSweetness(int[] sweetness, int k) {
        int start = 1;
        int end = 0;

        for (int num : sweetness) {
            end += num;
        }

        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int pieces = 0;
            for (int num : sweetness) {
                if (sum + num >= mid) {
                    pieces++;
                    sum = 0;
                } else {
                    sum += num;
                }
            }

            if (pieces >= k + 1) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
