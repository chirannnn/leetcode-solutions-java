/*
    Leetcode : Subtract the Product and Sum of Digits of an Integer

    Given an integer number n, return the difference between the product of its digits and the sum of its digits.

    Example:
    Input: n = 234
    Output: 15
    Explanation:
    Product of digits = 2 * 3 * 4 = 24
    Sum of digits = 2 + 3 + 4 = 9
    Result = 24 - 9 = 15

 */

package com.leetcode;

public class SubtractProductAndSum {
    public static void main(String[] args) {
        int n = 234;
        System.out.println(subProdAndSum(n));
    }

    static int subProdAndSum(int n){
        int product = 1;
        int sum = 0;
        while (n > 0){
            int rem = n % 10;
            n = n / 10;
            product *= rem;
            sum += rem;
        }
        return product-sum;
    }
}
