/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

Example 2:
Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]

Constraints:
    1 <= arr1.length, arr2.length <= 1000
    0 <= arr1[i], arr2[i] <= 1000
    All the elements of arr2 are distinct.
    Each arr2[i] is in arr1.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RelativeSortArray_17 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for (int num : arr1) {
            freq[num]++;
        }

        int index = 0;
        int[] ans = new int[arr1.length];
        for (int num : arr2) {
            while (freq[num] > 0) {
                ans[index] = num;
                freq[num]--;
                index++;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                ans[index] = i;
                freq[i]--;
                index++;
            }
        }
        return ans;



//        List<Integer> list = new ArrayList<>();
//
//        for (int num1 : arr2) {
//            for (int i = 0; i < arr1.length; i++) {
//                if (num1 == arr1[i]) {
//                    list.add(num1);
//                    arr1[i] = -1;
//                }
//            }
//        }
//
//        List<Integer> rem = new ArrayList<>();
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] != -1) {
//                rem.add(arr1[i]);
//            }
//        }
//
//        Collections.sort(rem);
//        list.addAll(rem);
//
//        int[] ans = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ans[i] = list.get(i);
//        }
//        return ans;
    }
}
