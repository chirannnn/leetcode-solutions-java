/*
You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.

The ith item is said to match the rule if one of the following is true:

ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.

Example 1:
Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].

Example 2:
Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 */

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingARule11 {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone","blue","pixel"));
        items.add(Arrays.asList("computer","silver","lenovo"));
        items.add(Arrays.asList("phone","gold","iphone"));
        String ruleKey = "type";
        String ruleValue = "phone";

        System.out.println(countMatches(items, ruleKey, ruleValue));
    }

    static int countMatches(List<List<String>> items, String ruleKey, String ruleValue){

        int index = 0;
        if(ruleKey.equals("type")){
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else if (ruleKey.equals("name")) {
            index = 2;
        }

        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            List<String> item = items.get((i));

            if (item.get(index).equals(ruleValue)){
                count++;
            }
        }
        return count;

//        for (List<String> item : items) {
//            if (item.get(index).equals(ruleValue)) {
//                count++;
//            }
//        }
    }
}
