/*
    Leetcode : Concatenation of Array

    Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

    Specifically, ans is the concatenation of two nums arrays.

    Return the array ans.

    Example 1:
    Input: nums = [1,2,1]
    Output: [1,2,1,1,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
    - ans = [1,2,1,1,2,1]
 */

package com.leetcode;

import java.util.Arrays;

public class ConcatenationofArray02 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] ans = concatArray(nums);
        System.out.println(Arrays.toString(ans));
    }

    static int[] concatArray(int[] nums){
        int n =  nums.length;
        int[] ans = new int[2*n];

        for (int i = 0; i < n; i++){
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }

        return ans;
    }
}
