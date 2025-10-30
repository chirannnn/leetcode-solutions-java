/*
(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example 1:
Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

Example 2:
Input: mountainArr = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 */

package com.leetcode;

public class FindInMountainArray_07 {
    public static void main(String[] args) {
        int[] mountainArr = {1,2,3,4,5,3,1};
        int target = 3;

        System.out.println(findInMountainArray(mountainArr, target));
    }

    /*
Problem:
We are given a mountain array (strictly increasing then strictly decreasing).
We must find the minimum index where target exists.
If not found, return -1.

Approach:
1. Find the peak index of the mountain.
2. Binary search on the ascending part (left side).
3. If not found, binary search on the descending part (right side).
Time Complexity: O(log N)
*/

    static int findInMountainArray(int[] mountainArr, int target) {
        int peak = findPeak(mountainArr);

        if (mountainArr[peak] == target) {
            return peak;
        }
        int ans = search(mountainArr, target, 0, peak - 1, true);

        if (ans != -1) {
            return ans;
        }

        return search(mountainArr, target, peak + 1, mountainArr.length - 1, false);
    }

    static int search(int[] arr, int target, int start, int end, boolean isAsc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
