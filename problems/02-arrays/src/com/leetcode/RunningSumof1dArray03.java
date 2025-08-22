/*
    Leetcode : Running Sum of 1d Array

    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

    Return the running sum of nums.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 */

package com.leetcode;

import java.util.Arrays;

public class RunningSumof1dArray03 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] ans = runningSum(nums);
        System.out.println(Arrays.toString(ans));

    }

    static int[] runningSum(int[] num){
        int[] ans = new int[num.length];

        // optimal version

        ans[0] = num[0];
        for (int i = 1; i < num.length; i++){
            ans[i] = ans[i - 1] + num[i];
        }
        return ans;

//        for (int i = 0; i < num.length; i++){
//            for (int j = 0; j <= i; j++){
//                ans[i] += num[j];
//            }
//        }
//        return ans;
    }
}
