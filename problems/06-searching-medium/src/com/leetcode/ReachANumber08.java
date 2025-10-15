/*
You are standing at position 0 on an infinite number line. There is a destination at position target.

You can make some number of moves numMoves so that:

On each move, you can either go left or right.
During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.

Example 1:
Input: target = 2
Output: 3
Explanation:
On the 1st move, we step from 0 to 1 (1 step).
On the 2nd move, we step from 1 to -1 (2 steps).
On the 3rd move, we step from -1 to 2 (3 steps).

Example 2:
Input: target = 3
Output: 2
Explanation:
On the 1st move, we step from 0 to 1 (1 step).
On the 2nd move, we step from 1 to 3 (2 steps).
 */

package com.leetcode;

public class ReachANumber08 {
    public static void main(String[] args) {
        int target = 3;

        System.out.println(reachNumber(target));
    }

    static int reachNumber(int target) {

        //convert negative target to positive
        if(target < 0) {
            target *= -1;
        }

        int start = 0;
        int end = target;
        int move = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // ⚡ Triangular Number Formula:
            // sum of first n natural numbers = n*(n+1)/2
            // This gives total distance if we move 'mid' steps to the right
            long sum = (long) mid * (mid + 1) / 2;

            if (sum >= target) {
                move = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        long sum = (long) move * (move + 1) / 2;

        // 🧠 Check if (sum - target) is even
        // Flipping a step can only fix the distance if the gap is even.
        // If it's odd, take more steps until it becomes even.
        while ((sum - target) % 2 != 0) {
            move++;
            sum += move;
        }

        return move;


        // 📝 Alternate: Simple Step-by-Step Approach (O(√target))
        // int move = 0;
        // int sum = 0;

        // while (true) {
        //     move++;
        //     sum += move;

        //     if (sum >= target && (sum - target) % 2 == 0) {
        //         return move;
        //     }
        // }
    }
}
