/*
Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:
Input: nums = [-1]
Output: [0]

Example 3:
Input: nums = [-1,-1]
Output: [0,0]
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_08 {
    public static void main(String[] args) {
        int[] nums = {5,2,6,1};

        System.out.println(countSmaller(nums));
    }

    /*
Approach: Binary Search on a sorted list (from right to left)
- We maintain a sorted list of elements seen so far (from right)
- For each number, binary search the index where it fits → that index = count of smaller elements to the right
- Insert number into sorted list at that index

Time: ~O(n log n) average, O(n^2) worst (due to list insertion)
Space: O(n)

Note:
✅ Current method = Binary Search + Dynamic sorted list (clean + intuitive)
🚀 Future optimal solution = Fenwick Tree / Merge-Sort Tree (O(n log n))
*/


    static List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            int start = 0;
            int end = sortedList.size();
            while (start < end) {
                int mid = start + (end - start) / 2;

                if (sortedList.get(mid) < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            int index = start;

            result.add(index);
            sortedList.add(index, num);
        }

        Collections.reverse(result);
        return result;

        // brute-force
//        List<Integer> list = new ArrayList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    count++;
//                }
//            }
//            list.add(count);
//        }
//
//        return list;
    }
}
