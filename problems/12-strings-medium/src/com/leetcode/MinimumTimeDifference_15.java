/*
Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

Example 1:
Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:
Input: timePoints = ["00:00","23:59","00:00"]
Output: 0

Constraints:
2 <= timePoints.length <= 2 * 104
timePoints[i] is in the format "HH:MM".
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference_15 {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");

        System.out.println(findMinDifference(timePoints));
    }

    static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        if (n > 1440) {
            return 0;
        }

        int[] minutes = new int[n];
        for (int i = 0; i < n; i++) {
//            int hour = Integer.parseInt(timePoints.get(i).split(":")[0]);
//            int min = Integer.parseInt(timePoints.get(i).split(":")[1]);

            String str = timePoints.get(i);
            int hour = (str.charAt(0) - '0') * 10 + str.charAt(1) - '0';
            int min = (str.charAt(3) - '0') * 10 + str.charAt(4) - '0';

            minutes[i] = hour * 60 + min;
        }

        Arrays.sort(minutes);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }
        return Math.min(minDiff, (minutes[0] + 1440) - minutes[n - 1]);
    }
}
