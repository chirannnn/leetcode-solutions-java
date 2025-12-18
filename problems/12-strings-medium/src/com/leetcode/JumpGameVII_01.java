/*
You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

i + minJump <= j <= min(i + maxJump, s.length - 1), and
s[j] == '0'.
Return true if you can reach index s.length - 1 in s, or false otherwise.

Example 1:
Input: s = "011010", minJump = 2, maxJump = 3
Output: true
Explanation:
In the first step, move from index 0 to index 3.
In the second step, move from index 3 to index 5.

Example 2:
Input: s = "01101110", minJump = 2, maxJump = 3
Output: false

Constraints:
2 <= s.length <= 105
s[i] is either '0' or '1'.
s[0] == '0'
1 <= minJump <= maxJump < s.length
 */

package com.leetcode;

public class JumpGameVII_01 {
    public static void main(String[] args) {
        String s = "01101110";
        int minJump = 2, maxJump = 3;

        System.out.println(canReach(s, minJump, maxJump));
    }

    static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        int start = 0;
        int end = 0;
        boolean[] db = new boolean[n];
        db[0] = true;
        for (int i = 0; i < n; i++) {
            if (!db[i]) {
                continue;
            }

            start = Math.max(i + minJump, end + 1);
            end = Math.min(i + maxJump, s.length() - 1);
            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    db[j] = true;
                }
            }

            if (db[n - 1]) {
                return true;
            }
        }
        return db[n - 1];
    }
}
