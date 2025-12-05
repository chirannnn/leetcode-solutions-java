/*
A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

Example 1:
Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

Example 2:
Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.

Constraints:
2 <= s.length <= 200
s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
The number of words in s is between 1 and 9.
The words in s are separated by a single space.
s contains no leading or trailing spaces.
 */

package com.leetcode;

public class SortingTheSentence_05 {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";

        System.out.println(sortSentence(s));
    }

    static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        for (String word : words) {
            char position = word.charAt(word.length() - 1);
            // position is a character like '1', '2', '3', ... (ASCII characters)
            // To convert '1' → 0, '2' → 1, '3' → 2, we subtract '1'
            // Because characters store ASCII values internally
            // Example: '3' - '1' = 50 - 49 = 1
            int index = position - '1';
            String pureWord = word.substring(0, word.length() - 1);
            ans[index] = pureWord;
        }
        return String.join(" ", ans);
    }
}
