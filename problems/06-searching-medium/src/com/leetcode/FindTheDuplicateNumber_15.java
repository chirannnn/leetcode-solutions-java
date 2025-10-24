/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
 */

package com.leetcode;

public class FindTheDuplicateNumber_15 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        System.out.println(findDuplicate(nums));
    }

    /*
🧩 Problem Understanding:
-------------------------
We are given an array of integers nums containing n + 1 numbers.
Each number is in the range [1, n] and there is **exactly one duplicate**.
We need to find the duplicate without modifying the array and using constant extra space.

Think of the array as a mysterious board game:
- Each index is a square on the board.
- The number at each square tells you which square to jump to next.
- Because there is a duplicate, there is a "loop" somewhere on this board.

🪜 Our Approach (Floyd's Tortoise and Hare / Cycle Detection):
-------------------------------------------------------------
Step 1: Start Two Players
- Slow player moves 1 square at a time.
- Fast player moves 2 squares at a time.
- Both start at the first square (nums[0]).

Step 2: Detect the Loop
- Move slow by 1 step: slow = nums[slow]
- Move fast by 2 steps: fast = nums[nums[fast]]
- Keep going until they meet. Meeting proves a loop exists. 🌀

Step 3: Find the Entrance of the Loop
- Reset one pointer to the start of the board (ptr1 = nums[0]).
- Keep the other pointer at the meeting point (ptr2 = slow).
- Move both pointers one square at a time.
- The point where they meet again is the **entrance of the loop**, which is the duplicate number. 🎯

💡 Example Walkthrough:
nums = [1,3,4,2,2]
- Board view: 0→1→3→2→4→2 (cycle starts at 2)
- Slow moves 1 step, fast moves 2 steps, they meet at index 2
- Reset pointer, both move 1 step, they meet at index 2 → duplicate = 2
*/


    static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int ptr1 = nums[0];
        int ptr2 = slow;

        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;

        // brute - force
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i != j && nums[i] == nums[j]) {
        //             return nums[i];
        //         }
        //     }
        // }

        // return -1;
    }
}
