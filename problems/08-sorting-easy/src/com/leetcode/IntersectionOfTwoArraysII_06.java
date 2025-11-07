/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII_06 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }
        return ans;

        // brute-force
        // int n1 = nums1.length;
        // int n2 = nums2.length;

        // List<Integer> list = new ArrayList<>();

        // boolean[] used = new boolean[n2];

        // for (int i = 0; i < n1; i++) {
        //     for (int j = 0; j < n2; j++) {
        //         if (nums1[i] == nums2[j] && !used[j]) {
        //             list.add(nums1[i]);
        //             used[j] = true;
        //             break;
        //         }
        //     }
        // }

        // int[] result = new int[list.size()];

        // for (int i = 0; i < list.size(); i++) {
        //     result[i] = list.get(i);
        // }

        // return result;
    }
}
