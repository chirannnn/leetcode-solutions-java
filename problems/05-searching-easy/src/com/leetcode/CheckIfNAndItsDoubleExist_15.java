/*
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]

Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

Example 2:
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
 */

package com.leetcode;

public class CheckIfNAndItsDoubleExist_15 {
    public static void main(String[] args) {
        int[] arr = {3,1,7,11};

        System.out.println(checkIfExist(arr));
    }

    static boolean checkIfExist(int[] arr) {

        // brute-force
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }

        return false;

        // 🔑 Later Optimization: Use HashSet (O(n)) or Sorting + Binary Search (O(n log n)) instead of O(n^2).
    }
}
