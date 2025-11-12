/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr

Example 1:
Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.

Example 2:
Input: arr = [1,3,6,10,15]
Output: [[1,3]]

Example 3:
Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 */

package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference_18 {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};

        System.out.println(minimumAbsDifference(arr));
    }

    static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return result;


        // Arrays.sort(arr);

        // int i = 0;
        // int j = 1;
        // int min = Integer.MAX_VALUE;
        // List<List<Integer>> list = new ArrayList<>();
        // while (i < arr.length && j < arr.length) {
        //     int minCal = arr[j] - arr[i];
        //     if (minCal < min) {
        //         min = minCal;
        //         list.clear();
        //         list.add(List.of(arr[i], arr[j]));
        //     } else if (minCal == min) {
        //         list.add(List.of(arr[i], arr[j]));
        //     }
        //     i++;
        //     j++;
        // }
        // return list;
    }
}
