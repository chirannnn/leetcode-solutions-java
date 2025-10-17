/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 */

package com.leetcode;

public class KokoEatingBananas10 {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;

        System.out.println(minEatingSpeed(piles, h));
    }

    /*
Let's understand the solution, as we are going to be using Binary Search we have given an Array [3,6,7,11]
And we have to eat every single pile of bananas in less than or equals to hours = 8.
If we not able to do that Gurad will kill KOKO [just a joke].
     */

    static int minEatingSpeed(int[] piles, int h) {
        // Koko's Banana Adventure 🐵🍌
        // We have an array of piles: [3,6,7,11]
        // Koko has 'h' hours (e.g., 8) to eat all bananas
        // Goal: Find the minimum speed 'k' that lets her finish on time
        // (If not, the guard gets mad! Just a joke 😆)

        //Find the largest pile
        // Why? Because Koko cannot eat faster than the biggest pile.
        // This sets the upper limit of our search range
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (pile > maxPile) {
                maxPile = pile;
            }
        }

        int start = 1;
        int end = maxPile;
        int k = 0;

        //Binary search to find the minimum speed
        // Imagine Koko trying a speed in the middle of our range
        // If she can finish all bananas at this speed, maybe she can go slower
        // If she can't, she needs to eat faster
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canEatInTime(piles, mid, h)) {
                k = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return k;
    }

    static boolean canEatInTime(int[] piles, int k, int h) {
        long hours = 0;

        // For each pile, calculate hours needed at speed 'k'
        // Using (pile + k - 1) / k to round up without decimals
        for (int pile : piles) {
            // int div = pile / k;
            // hours += div;
            // if (pile % k != 0) hours++;
            hours += (pile + k - 1) / k; // integer ceiling division formula = ceil(a / b​) = (a + b - 1) /​ b
        }

        return hours <= h;
    }
}
