/*
You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.

Example 1:
Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".

Example 2:
Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:
Input: command = "(al)G(al)()()G"
Output: "alGalooG"

Constraints:
1 <= command.length <= 100
command consists of "G", "()", and/or "(al)" in some order.
 */

package com.leetcode;

public class GoalParserInterpretation_03 {
    public static void main(String[] args) {
        String command = "G()(al)";

        System.out.println(interpret(command));
    }

    static String interpret(String command) {
//        return command.replace("()", "o").replace("(al)", "al");

        StringBuilder ans = new StringBuilder();

        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                ans.append('G');
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    ans.append('o');
                    i++;
                } else {
                    ans.append("al");
                    i += 3;
                    continue;
                }
            }
            i++;
        }
        return ans.toString();
    }
}
