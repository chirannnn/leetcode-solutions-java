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

public class IntersectionOfTwoArrays_05 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (list.size() == 0 || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }
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
        // List<Integer> list = new ArrayList<>();

        // for (int num1 : nums1) {
        //     for (int num2 : nums2) {
        //         if (num1 == num2) {
        //             boolean exist = false;
        //             for (int val : list) {
        //                 if (val == num1) {
        //                     exist = true;
        //                     break;
        //                 }
        //             }

        //             if (!exist) {
        //                 list.add(num1);
        //             }
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
