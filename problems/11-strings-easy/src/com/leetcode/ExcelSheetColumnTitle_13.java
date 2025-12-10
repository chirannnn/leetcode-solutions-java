/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

Example 1:
Input: columnNumber = 1
Output: "A"

Example 2:
Input: columnNumber = 28
Output: "AB"

Example 3:
Input: columnNumber = 701
Output: "ZY"

Constraints:
1 <= columnNumber <= 231 - 1
 */

package com.leetcode;

public class ExcelSheetColumnTitle_13 {
    public static void main(String[] args) {
        int columnNumber = 28;

        System.out.println(convertToTitle(columnNumber));
    }

    static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char ch =(char) (columnNumber % 26 + 'A');
            ans.append(ch);
            columnNumber = columnNumber / 26;
        }
        return ans.reverse().toString();
    }
}
