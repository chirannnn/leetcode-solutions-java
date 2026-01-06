/*
Given a string s. Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
Each word would be put on only one column and that in one column there will be only one word.

Example 1:
Input: s = "HOW ARE YOU"
Output: ["HAY","ORO","WEU"]
Explanation: Each word is printed vertically.
 "HAY"
 "ORO"
 "WEU"

Example 2:
Input: s = "TO BE OR NOT TO BE"
Output: ["TBONTB","OEROOE","   T"]
Explanation: Trailing spaces is not allowed.
"TBONTB"
"OEROOE"
"   T"

Example 3:
Input: s = "CONTEST IS COMING"
Output: ["CIC","OSO","N M","T I","E N","S G","T"]

Constraints:
1 <= s.length <= 200
s contains only upper case English letters.
It's guaranteed that there is only one space between 2 words.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically_17 {
    public static void main(String[] args) {
        String s = "HOW ARE YOU";

        System.out.println(printVertically(s));
    }

    static List<String> printVertically(String s) {
        String[] words = s.split(" ");

        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            StringBuilder str = new StringBuilder();

            for (String word : words) {
                if (i < word.length()) {
                    char ch = word.charAt(i);
                    str.append(ch);
                } else {
                    str.append(" ");
                }
            }

            int j = str.length() - 1;
            while (j > 0 && str.charAt(j) == ' ') {
                str.deleteCharAt(j);
                j--;
            }
            str.setLength(j + 1);

            list.add(str.toString());
        }
        return list;
    }
}
