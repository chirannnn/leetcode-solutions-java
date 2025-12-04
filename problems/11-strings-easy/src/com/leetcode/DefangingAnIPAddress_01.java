/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 */

package com.leetcode;

public class DefangingAnIPAddress_01 {
    public static void main(String[] args) {
        String address = "1.1.1.1";

        System.out.println(defangIPaddr(address));
    }

    static String defangIPaddr(String address) {
        return address.replace(".", "[.]");

//        StringBuilder ans = new StringBuilder();
//        for (int i = 0; i < address.length(); i++) {
//            char ch = address.charAt(i);
//            ans.append(ch == '.' ? "[.]" : ch);
//        }
//        return ans.toString();
    }
}
