/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */

package com.leetcode;

import java.util.*;

public class SubsetsII_02 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};


    }

    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        int n = 1 << nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int temp = i, index = 0;
            List<Integer> list = new ArrayList<>();
            while (temp != 0) {
                if ((temp & 1) == 1) list.add(nums[index]);
                temp >>= 1;
                index++;
            }

            if (set.add(list)) {
                ans.add(list);
            }
        }
        return ans;
    }
}
