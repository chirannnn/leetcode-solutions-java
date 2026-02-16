/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets_01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(subsets(nums));
    }

    static List<List<Integer>> subsets(int[] nums) {
        int n = 1 << nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = i, index = 0;
            List<Integer> list = new ArrayList<>();

            while (temp != 0) {
                if ((temp & 1) == 1) list.add(nums[index]);
                temp >>= 1;
                index++;
            }
            ans.add(list);
        }
        return ans;
    }
}
