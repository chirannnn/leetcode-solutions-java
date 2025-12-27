/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string result, return True if and only if there exists a sequence of moves to transform start to result.

Example 1:
Input: start = "RXXLRXRXL", result = "XRLXXRRLX"
Output: true
Explanation: We can transform start to result following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX

Example 2:
Input: start = "X", result = "L"
Output: false

Constraints:
1 <= start.length <= 104
start.length == result.length
Both start and result will only consist of characters in 'L', 'R', and 'X'.
 */

package com.leetcode;

public class SwapAdjacentInLRString_08 {
    public static void main(String[] args) {
        String start = "RXXLRXRXL", result = "XRLXXRRLX";

        System.out.println(canTransform(start, result));
    }

    static boolean canTransform(String start, String result) {
        int n = start.length();

        int i = 0;
        int j = 0;
        while (i < n || j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && result.charAt(j) == 'X') {
                j++;
            }

            if (i == n || j == n) return i == n && j == n;

            if (start.charAt(i) != result.charAt(j)) {
                return false;
            } else {
                char ch = start.charAt(i);
                if (ch == 'L' && j > i) {
                    return false;
                }
                if (ch == 'R' && j < i) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}
