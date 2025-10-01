/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays12 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        // brute-force

        List<Integer> list = new ArrayList<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    boolean exist = false;

                    for (int val : list) {
                        if (val == num1) {
                            exist = true;
                        }
                    }

                    if (!exist) {
                        list.add(num1);
                    }
                }
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

/*
📌 Revision Notes:
1. Current = Brute Force → O(n * m) time, O(1) extra space (ignoring result).
2. When I learn "Sorting + Two Pointers" → I can optimize to O(n log n + m log m).
3. When I learn "HashSet / HashMap" → I can solve in O(n + m) time, O(n) space.
4. This is a standard pattern: "Intersection of Arrays" → Brute → Sort → Hash.
*/