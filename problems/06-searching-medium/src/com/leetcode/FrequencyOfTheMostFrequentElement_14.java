/*
The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

Example 1:
Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.

Example 2:
Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.

Example 3:
Input: nums = [3,9,6], k = 2
Output: 1
 */

package com.leetcode;

public class FrequencyOfTheMostFrequentElement_14 {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;

        System.out.println(maxFrequency(nums, k));
    }

    /*
🧩 Problem Understanding:
-------------------------
We are given an array and a number k.
We can increase any element by 1 in each operation.
We want to find the maximum frequency of any number
we can achieve after at most k operations.

🪜 My Approach (Brute Force for now):
------------------------------------
👉 Step 1: For now, I am solving this problem in a brute-force way.
   I’ll improve it later using sorting and sliding window once I learn them.

👉 Step 2: I pick each element one by one (nums[i]) and assume:
           “Let’s try to make every other number equal to this one.”

👉 Step 3: For that target number, I go through the rest of the array.
           - If another number is smaller,
             I calculate how many operations it needs to become equal.
           - If I still have enough k left, I use those operations and increase the count.

👉 Step 4: I keep track of the maximum frequency I was able to make.

💡 Example:
nums = [1, 2, 4], k = 5
- Try making all numbers equal to 1 → needs too many operations ❌
- Try making all equal to 2 → needs some operations
- Try making all equal to 4 → possible ✅ gives max frequency = 3

⚙️ Complexity:
---------------
This is O(n^2) because for every element, I compare it with all others.

🚀 Future Plan:
----------------
After I properly learn:
  - Sorting (to bring numbers in increasing order)
  - Sliding Window (to efficiently count in ranges)
I’ll come back and solve this in an optimal O(n log n) solution.
*/

    static int maxFrequency(int[] nums, int k) {
        int n = nums.length;

        int maxFrq = 1;

        for (int i = 0; i < n; i++) {
            int target = nums[i];
            int used = 0;
            int count = 1;

            for (int j = 0; j < n; j++) {
//                if (i == j) continue;

                if (i != j && nums[j] < target) {
                    int diff = target - nums[j];

                    if (used + diff <= k) {
                        used += diff;
                        count++;
                    }
                }
            }

            if (count > maxFrq) {
                maxFrq = count;
            }
        }

        return maxFrq;
    }
}
